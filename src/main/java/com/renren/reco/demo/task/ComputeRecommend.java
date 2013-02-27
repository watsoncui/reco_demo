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

import com.renren.reco.demo.bean.RecommendDTO;
import com.renren.reco.demo.bean.RelationDTO;
import com.renren.reco.demo.manager.IRecommendManager;

public class ComputeRecommend {

	private final static Logger logger = Logger.getLogger(ComputeRecommend.class.getName());
	private IRecommendManager recommendManager;
	private Deg2friend compute = new Deg2friend();
	
	public void computeRecommend() {
		List<Long> profileList = recommendManager.sendProfileData();
		logger.info("quartz task, read all profiles " + profileList.get(0));
		List<List<RelationDTO>> allRelations = new ArrayList<List<RelationDTO>>();
		List<List<RecommendDTO>> allRecommends = new ArrayList<List<RecommendDTO>>();
		if(null == profileList) 
			return ;
		
		for(Long profile:profileList) {
			compute.getAlluser().put(profile.toString(), new Node (profile.toString()));
			List<RelationDTO> relationList = recommendManager.sendRelation(profile);
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
		
		//TODO:compute recommendations
		compute.pushFriend();
		
		for(Long profile:profileList) {
			List<RecommendDTO> temp = new ArrayList<RecommendDTO>();
			Set<Map.Entry<String, Double>> set = compute.getAlluser().get(profile).getFriend().entrySet();
       	 	for (Iterator<Map.Entry<String, Double>> it = set.iterator(); it.hasNext();) {
       	 		Map.Entry<String, Double> entry =  (Map.Entry<String, Double>)it.next();
       	 		
       	 		temp.add(new RecommendDTO(profile,Long.parseLong(entry.getKey()),entry.getValue()));
       	 	}		
       	 	allRecommends.add(temp);
		}
		
		for(List<RecommendDTO> recommendDTOList:allRecommends) {
			if(null != recommendDTOList) {
				recommendManager.recieveRecommend(recommendDTOList);
			}
		}
		
	}
	
	public void setRecommendManager(IRecommendManager recommendManager) {
		this.recommendManager = recommendManager;
	}
}
