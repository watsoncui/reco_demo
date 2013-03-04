	package com.renren.reco.demo.task;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
	
	private boolean profileInReverseList(long profile, List<RelationDTO> reverseList) {
		if((null != reverseList) && (reverseList.size() > 0)) {
			for(RelationDTO temp:reverseList) {
				if(temp.getUploaderPhoneNumber() == profile) {
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
	
private int commonFriends(List<RelationDTO> relationList1, List<RelationDTO> relationList2, List<RelationDTO> reverseRelationList1, List<RelationDTO> reverseRelationList2) {
		
		int common = 0;
		
		if(((null == relationList1) || (relationList1.size() == 0)) && ((null == reverseRelationList1) || (reverseRelationList1.size() == 0))) {
			return common;
		}
		if(((null == relationList2) || (relationList2.size() == 0)) && ((null == reverseRelationList2) || (reverseRelationList2.size() == 0))) {
			return common;
		}
		
		for(RelationDTO relation1:relationList1) {
			for(RelationDTO relation2:relationList2) {
				if(relation1.getContactorPhoneNumber() == relation2.getContactorPhoneNumber()) {
					common++;
				}
			}
		}
		
		for(RelationDTO relation1:reverseRelationList1) {
			for(RelationDTO relation2:reverseRelationList2) {
				if(relation1.getUploaderPhoneNumber() == relation2.getUploaderPhoneNumber()) {
					common++;
				}
			}
		}
		
		for(RelationDTO relation1:relationList1) {
			for(RelationDTO relation2:reverseRelationList2) {
				if(relation1.getContactorPhoneNumber() == relation2.getUploaderPhoneNumber()) {
					common++;
				}
			}
		}
		
		for(RelationDTO relation1:reverseRelationList1) {
			for(RelationDTO relation2:relationList2) {
				if(relation1.getUploaderPhoneNumber() == relation2.getContactorPhoneNumber()) {
					common++;
				}
			}
		}
		
		return common;
	}
	
	public void computeRecommend() {
		List<Long> profileList = recommendManager.sendProfileData();
		logger.info("quartz task, read all profiles " + profileList.get(0));
		Map<Long, List<RelationDTO>> profileMap = new HashMap<Long, List<RelationDTO>>();
		Map<Long, List<RelationDTO>> profileReverseMap = new HashMap<Long, List<RelationDTO>>();
		
		if((null != profileList) && (profileList.size() > 0)) {
			for(long profile:profileList) {
				List<RelationDTO> relationList = null;
				List<RelationDTO> reverseRelationList = null;
				if(profileMap.containsKey(profile)) {
					relationList = profileMap.get(profile);
				} else {
					relationList = recommendManager.sendRelation(profile);
					profileMap.put(profile, relationList);
				}
				if(profileReverseMap.containsKey(profile)) {
					reverseRelationList = profileReverseMap.get(profile);
				} else {
					reverseRelationList = recommendManager.sendReverseRelation(profile);
					profileReverseMap.put(profile, reverseRelationList);
				}
				
				if((relationList.size() > 0) || (reverseRelationList.size() > 0)) {
					List<RecommendDTO> recommendList = new ArrayList<RecommendDTO>();
					List<Long> optionList = new ArrayList<Long>();
					for(RelationDTO relation:relationList) {
						if(null != relation) {
							List<RelationDTO> hisRelationList = null;
							List<RelationDTO> hisReverseRelationList = null;
							if(profileMap.containsKey(relation.getContactorPhoneNumber())) {
								hisRelationList = profileMap.get(relation.getContactorPhoneNumber());
							} else {
								hisRelationList = recommendManager.sendRelation(relation.getContactorPhoneNumber());
								profileMap.put(relation.getContactorPhoneNumber(), hisRelationList);
							}
							if(profileReverseMap.containsKey(relation.getUploaderPhoneNumber())) {
								hisReverseRelationList = profileReverseMap.get(relation.getUploaderPhoneNumber());
							} else {
								hisReverseRelationList = recommendManager.sendReverseRelation(relation.getUploaderPhoneNumber());
								profileReverseMap.put(relation.getUploaderPhoneNumber(), hisReverseRelationList);
							}
							
							if(null != hisRelationList) {
								for(RelationDTO hisRelation:hisRelationList) {
									if(null != hisRelation) {
										optionList.add(hisRelation.getContactorPhoneNumber());
									}
								}
							}
							
							if(null != hisReverseRelationList) {
								for(RelationDTO hisReverseRelation:hisReverseRelationList) {
									if(null != hisReverseRelation) {
										optionList.add(hisReverseRelation.getUploaderPhoneNumber());
									}
								}
							}
						}
					}
					
					for(RelationDTO relation:reverseRelationList) {
						if(null != relation) {
							List<RelationDTO> hisRelationList = null;
							List<RelationDTO> hisReverseRelationList = null;
							if(profileMap.containsKey(relation.getUploaderPhoneNumber())) {
								hisRelationList = profileMap.get(relation.getUploaderPhoneNumber());
							} else {
								hisRelationList = recommendManager.sendRelation(relation.getUploaderPhoneNumber());
								profileMap.put(relation.getUploaderPhoneNumber(), hisRelationList);
							}
							if(profileReverseMap.containsKey(relation.getContactorPhoneNumber())) {
								hisReverseRelationList = profileReverseMap.get(relation.getContactorPhoneNumber());
							} else {
								hisReverseRelationList = recommendManager.sendReverseRelation(relation.getContactorPhoneNumber());
								profileReverseMap.put(relation.getContactorPhoneNumber(), hisReverseRelationList);
							}
							
							if(null != hisRelationList) {
								for(RelationDTO hisRelation:hisRelationList) {
									if(null != hisRelation) {
										optionList.add(hisRelation.getContactorPhoneNumber());
									}
								}
							}
							
							if(null != hisReverseRelationList) {
								for(RelationDTO hisReverseRelation:hisReverseRelationList) {
									if(null != hisReverseRelation) {
										optionList.add(hisReverseRelation.getUploaderPhoneNumber());
									}
								}
							}
						}
					}
					
					for(long profile2:optionList) {
						if((profile2 != profile) && (!profileInList(profile2, relationList)) && (!profileInReverseList(profile2, reverseRelationList))) {
							List<RelationDTO> optionProfileList = null;
							List<RelationDTO> optionReverseProfileList = null;
							if(profileMap.containsKey(profile2)) {
								optionProfileList = profileMap.get(profile2);
							} else {
								optionProfileList = recommendManager.sendRelation(profile2);
								profileMap.put(profile2, optionProfileList);
							}
							if(profileReverseMap.containsKey(profile2)) {
								optionReverseProfileList = profileReverseMap.get(profile2);
							} else {
								optionReverseProfileList = recommendManager.sendReverseRelation(profile2);
								profileReverseMap.put(profile2, optionReverseProfileList);
							}
							int score = commonFriends(relationList, optionProfileList, reverseRelationList, optionReverseProfileList);
							if(score > 1.5) {
								RecommendDTO recommendDTO = new RecommendDTO();
								recommendDTO.setRecommendPhoneNumber(profile2);
								recommendDTO.setScore(score);
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
