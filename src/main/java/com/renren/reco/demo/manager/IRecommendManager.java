package com.renren.reco.demo.manager;

import java.util.List;

import com.renren.reco.demo.bean.RecommendDTO;
import com.renren.reco.demo.bean.RelationDTO;
import com.renren.recommand.demo.UserProfile;

public interface IRecommendManager {
	public List<Long> sendProfileData();
	public List<RelationDTO> sendRelation(long phoneNumber);
	public List<RelationDTO> sendReverseRelation(long phoneNumber);
	public void recieveRecommend(List<RecommendDTO> recommandDTOList);
	
	public List<UserProfile> getRecommends(long phoneNumber);
	public boolean isUserExist(long phoneNumber);
}
