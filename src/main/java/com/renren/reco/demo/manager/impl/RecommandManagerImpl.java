package com.renren.reco.demo.manager.impl;

import java.util.ArrayList;
import java.util.List;

import com.renren.reco.demo.bean.RecommandDTO;
import com.renren.reco.demo.bean.RelationDTO;
import com.renren.reco.demo.handler.IProfileHandler;
import com.renren.reco.demo.handler.IRecommandHandler;
import com.renren.reco.demo.handler.IRelationHandler;
import com.renren.reco.demo.manager.IRecommandManager;
import com.renren.recommand.demo.UserProfile;

public class RecommandManagerImpl implements IRecommandManager {

	private static final String TEST = "test";
	
	private IProfileHandler profileHandler;
	
	private IRecommandHandler recommandHandler;
	
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
	public void recieveRecommand(List<RecommandDTO> recommandDTOList) {
		if(null != recommandDTOList) {
			for(RecommandDTO recommandDTO:recommandDTOList) {
				if(null != recommandDTO) {
					if(recommandHandler.isExist(recommandDTO)) {
						recommandHandler.updateRecommand(recommandDTO);
					} else {
						recommandHandler.setRecommand(recommandDTO);
					}
				}
			}
		}
	}

	@Override
	public List<UserProfile> getRecommands(long phoneNumber) {
		List<UserProfile> userProfileList = new ArrayList<UserProfile>();
		List<RecommandDTO> recommandDTOList = recommandHandler.getRecommands(phoneNumber);
		for(RecommandDTO recommandDTO:recommandDTOList) {
			UserProfile userProfile = recommandDTO2UserProfile(recommandDTO);
			if((null != userProfile.getUserName()) && (userProfile.getUserName().equals(TEST))) {
				userProfileList.add(userProfile);
			}
		}
		return userProfileList;
	}
	
	private UserProfile recommandDTO2UserProfile(RecommandDTO recommandDTO) {
		UserProfile userProfile = new UserProfile();
		if(null != recommandDTO) {
			userProfile.setUserName(TEST);
			userProfile.setPhoneNumber(recommandDTO.getRecommandPhoneNumber());
			userProfile.setScore(recommandDTO.getScore());
		}
		return userProfile;
	}

	public void setProfileHandler(IProfileHandler profileHandler) {
		this.profileHandler = profileHandler;
	}

	public void setRecommandHandler(IRecommandHandler recommandHandler) {
		this.recommandHandler = recommandHandler;
	}

	public void setRelationHandler(IRelationHandler relationHandler) {
		this.relationHandler = relationHandler;
	}

	

}
