	package com.renren.reco.demo.task;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import com.renren.reco.demo.bean.RecommendDTO;
import com.renren.reco.demo.bean.RelationDTO;
import com.renren.reco.demo.manager.IRecommendManager;

public class ComputeRecommend {

	private final static Logger logger = Logger.getLogger(ComputeRecommend.class.getName());
	private IRecommendManager recommendManager;
	
	private boolean profileInList(long profile, List<RelationDTO> list) {
		if((null != list) && (list.size() > 0)) {
			for(RelationDTO temp:list) {
				if(temp.getContactorPhoneNumber() == profile) {
					return true;
				}
			}
		}
		return false;
	}
	
	private int commonFriends(List<RelationDTO> relationList1, List<RelationDTO> relationList2) {
		
		int common = 0;
		
		if((null == relationList1) || (relationList1.size() == 0)) {
			return common;
		}
		if((null == relationList2) || (relationList2.size() == 0)) {
			return common;
		}
		
		for(RelationDTO relation1:relationList1) {
			for(RelationDTO relation2:relationList2) {
				if(relation1.getContactorPhoneNumber() == relation2.getContactorPhoneNumber()) {
					common++;
				}
			}
		}
		return common;
	}
	
	public void computeRecommend() {
		List<Long> profileList = recommendManager.sendProfileData();
		logger.info("quartz task, read all profiles " + profileList.get(0));
		
		if((null != profileList) && (profileList.size() > 0)) {
			for(long profile:profileList) {
				List<RelationDTO> relationList = recommendManager.sendRelation(profile);
				if(relationList.size() > 0) {
					List<RecommendDTO> recommendList = new ArrayList<RecommendDTO>();
					List<Long> optionList = new ArrayList<Long>();
					for(RelationDTO relation:relationList) {
						if(null != relation) {
							List<RelationDTO> hisRelationList = recommendManager.sendRelation(relation.getUploaderPhoneNumber());
							if(null != hisRelationList) {
								for(RelationDTO hisRelation:hisRelationList) {
									if(null != hisRelation) {
										optionList.add(hisRelation.getContactorPhoneNumber());
									}
								}
							}
						}
					}
					
					for(long profile2:optionList) {
						if((profile2 != profile) && (!profileInList(profile2, relationList))) {
							List<RelationDTO> optionProfileList = recommendManager.sendRelation(profile2);
							int score = commonFriends(relationList, optionProfileList);
							if(score > 0) {
								RecommendDTO recommendDTO = new RecommendDTO();
								recommendDTO.setRecommendPhoneNumber(profile2);
								recommendDTO.setIsSuccess(0);
								recommendDTO.setRecommendTime((new Date()).getTime());
								recommendDTO.setUploaderPhoneNumber(profile);
								recommendDTO.setVerifyTime(0L);
								recommendList.add(recommendDTO);
							}
						}
					}
					if(recommendList.size() > 0) {
						logger.info("quartz task, get commendList for " + profile);
						recommendManager.recieveRecommend(recommendList);
					}
				}
			}
		}
		
		logger.info("quartz task completely");
	}
	
	public void setRecommendManager(IRecommendManager recommendManager) {
		this.recommendManager = recommendManager;
	}
}
