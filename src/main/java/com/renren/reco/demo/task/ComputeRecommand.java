	package com.renren.reco.demo.task;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import com.renren.reco.demo.task.Deg2friend;
import com.renren.reco.demo.task.Deg2friend.Node;

import com.renren.reco.demo.bean.RecommandDTO;
import com.renren.reco.demo.bean.RelationDTO;
import com.renren.reco.demo.manager.IRecommandManager;

public class ComputeRecommand {

	private final static Logger logger = Logger.getLogger(ComputeRecommand.class.getName());
	private IRecommandManager recommandManager;
	private Deg2friend compute = new Deg2friend();
	
	public void computeRecommand() {
		List<Long> profileList = recommandManager.sendProfileData();
		logger.info("quartz task, read all profiles " + profileList.get(0));
		List<List<RelationDTO>> allRelations = new ArrayList<List<RelationDTO>>();
		List<List<RecommandDTO>> allRecommands = new ArrayList<List<RecommandDTO>>();
		if(null == profileList) 
			return ;
		
		for(Long profile:profileList) {
			compute.getAlluser().put(profile.toString(), new Node (profile.toString()));
			List<RelationDTO> relationList = recommandManager.sendRelation(profile);
			if(null != relationList) {
				allRelations.add(relationList);
				for(RelationDTO relation:relationList){
					 Long relation1 = relation.getUploaderPhoneNumber();
					 Long relation2 = relation.getContactorPhoneNumber();
					if(compute.getAlluser().containsKey(relation1)&&compute.getAlluser().containsKey(relation2)){
						(compute.getAlluser().get(relation1.toString())).addFirstFriend(compute.getAlluser().get(relation2.toString()));
						(compute.getAlluser().get(relation2.toString())).addFirstFriend(compute.getAlluser().get(relation1.toString()));
					}
				}
			}
			
		}
		
		//TODO:compute recommandations
		compute.pushFriend();
		
		for(Long profile:profileList) {
			List<RecommandDTO> temp = new ArrayList<RecommandDTO>();
			Set<Map.Entry<String, Double>> set = compute.getAlluser().get(profile).getFriend().entrySet();
       	 	for (Iterator<Map.Entry<String, Double>> it = set.iterator(); it.hasNext();) {
       	 		Map.Entry<String, Double> entry =  (Map.Entry<String, Double>)it.next();
       	 		
       	 		temp.add(new RecommandDTO(profile,Long.parseLong(entry.getKey()),entry.getValue()));
       	 	}		
       	 	allRecommands.add(temp);
		}
		
		for(List<RecommandDTO> recommandDTOList:allRecommands) {
			if(null != recommandDTOList) {
				recommandManager.recieveRecommand(recommandDTOList);
			}
		}
		
	}
	
	public void setRecommandManager(IRecommandManager recommandManager) {
		this.recommandManager = recommandManager;
	}
}
