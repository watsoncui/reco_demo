package com.renren.reco.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import Ice.Current;

import com.renren.reco.demo.manager.IRecommendManager;
import com.renren.recommand.demo.RecoErrorCodeEnum;
import com.renren.recommand.demo.RecommandResult;
import com.renren.recommand.demo.UserProfile;
import com.renren.recommand.demo._RecoServiceDisp;

public class RecommendServiceImpl extends _RecoServiceDisp {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7386196684826218481L;	
	
	private IRecommendManager recommendManager;
	
	@Override
	public RecommandResult getRecommandation(long userPhoneNumber, Current _current) {
		RecommandResult recommandResult = new RecommandResult();
		List<UserProfile> userProfileList = new ArrayList<UserProfile>();
		if(recommendManager.isUserExist(userPhoneNumber)) {
			recommandResult.setContacts(recommendManager.getRecommends(userPhoneNumber));
			recommandResult.setSuccess(true);
			recommandResult.setErrorCode(RecoErrorCodeEnum.SystemSuccess);
			recommandResult.setErrorMessage("Operate Success!");
		} else {
			recommandResult.setContacts(userProfileList);
			recommandResult.setSuccess(false);
			recommandResult.setErrorCode(RecoErrorCodeEnum.SystemError);
			recommandResult.setErrorMessage("Null Phone Number!");
		}
		return recommandResult;
	}

	public void setRecommendManager(IRecommendManager recommendManager) {
		this.recommendManager = recommendManager;
	}

}
