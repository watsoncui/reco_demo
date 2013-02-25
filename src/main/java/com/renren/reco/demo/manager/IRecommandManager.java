package com.renren.reco.demo.manager;

import java.util.List;

import com.renren.reco.demo.bean.RecommandDTO;
import com.renren.reco.demo.bean.RelationDTO;
import com.renren.recommand.demo.UserProfile;

public interface IRecommandManager {
	public List<Long> sendProfileData();
	public List<RelationDTO> sendRelation(long phoneNumber);
	public void recieveRecommand(List<RecommandDTO> recommandDTOList);
	
	public List<UserProfile> getRecommands(long phoneNumber);
	public boolean isUserExist(long phoneNumber);
}
