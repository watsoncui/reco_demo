package com.renren.reco.demo.manager.impl;

import java.util.ArrayList;
import java.util.List;

import com.renren.reco.demo.bean.RecommendDTO;
import com.renren.reco.demo.bean.RelationDTO;
import com.renren.reco.demo.handler.IProfileHandler;
import com.renren.reco.demo.handler.IRecommendHandler;
import com.renren.reco.demo.handler.IRelationHandler;
import com.renren.reco.demo.manager.IRecommendManager;
import com.renren.recommand.demo.UserProfile;

public class RecommendManagerImpl implements IRecommendManager {

	private static final String TEST = "test";
	
	private IProfileHandler profileHandler;
	
	private IRecommendHandler recommendHandler;
	
	private IRelationHandler relationHandler;
	
	@Override
	public boolean isUserExist(long phoneNumber) {
		if(null != profileHandler.getProfile(phoneNumber)) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public List<Long> sendProfileData() {
		List<Long> list = profileHandler.getAllPhoneNumbers();
		if(null == list) {
			return new ArrayList<Long>();
		} else {
			return list;
		}
	}

	@Override
	public List<RelationDTO> sendRelation(long phoneNumber) {
		List<RelationDTO> list = relationHandler.getRelations(phoneNumber);
		if(null == list) {
			return new ArrayList<RelationDTO>();
		} else {
			return list;
		}
	}
	

	@Override
	public List<RelationDTO> sendReverseRelation(long phoneNumber) {
		List<RelationDTO> list = relationHandler.getReverseRelations(phoneNumber);
		if(null == list) {
			return new ArrayList<RelationDTO>();
		} else {
			return list;
		}
	}

	@Override
	public void recieveRecommend(List<RecommendDTO> recommendDTOList) {
		if(null != recommendDTOList) {
			for(RecommendDTO recommendDTO:recommendDTOList) {
				if(null != recommendDTO) {
					if(recommendHandler.isExist(recommendDTO)) {
						recommendHandler.updateRecommend(recommendDTO);
					} else {
						recommendHandler.setRecommend(recommendDTO);
					}
				}
			}
		}
	}

	@Override
	public List<UserProfile> getRecommends(long phoneNumber) {
		List<UserProfile> userProfileList = new ArrayList<UserProfile>();
		List<RecommendDTO> recommendDTOList = recommendHandler.getRecommends(phoneNumber);
		for(RecommendDTO recommendDTO:recommendDTOList) {
			UserProfile userProfile = recommendDTO2UserProfile(recommendDTO);
			if((null != userProfile.getUserName()) && (userProfile.getUserName().equals(TEST))) {
				userProfileList.add(userProfile);
			}
		}
		return userProfileList;
	}
	
	private UserProfile recommendDTO2UserProfile(RecommendDTO recommendDTO) {
		UserProfile userProfile = new UserProfile();
		if(null != recommendDTO) {
			userProfile.setUserName(TEST);
			userProfile.setPhoneNumber(recommendDTO.getRecommendPhoneNumber());
			userProfile.setScore(recommendDTO.getScore());
		}
		return userProfile;
	}

	public void setProfileHandler(IProfileHandler profileHandler) {
		this.profileHandler = profileHandler;
	}

	public void setRecommendHandler(IRecommendHandler recommendHandler) {
		this.recommendHandler = recommendHandler;
	}

	public void setRelationHandler(IRelationHandler relationHandler) {
		this.relationHandler = relationHandler;
	}
}
