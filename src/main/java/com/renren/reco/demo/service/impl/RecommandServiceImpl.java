package com.renren.reco.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import Ice.Current;

import com.renren.reco.demo.manager.IRecommandManager;
import com.renren.recommand.demo.RecoErrorCodeEnum;
import com.renren.recommand.demo.RecommandResult;
import com.renren.recommand.demo.UserProfile;
import com.renren.recommand.demo._RecoServiceDisp;

public class RecommandServiceImpl extends _RecoServiceDisp {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7386196684826218481L;	
	
	private IRecommandManager recommandManager;
	
	@Override
	public RecommandResult getRecommandation(long userPhoneNumber, Current _current) {
		RecommandResult recommandResult = new RecommandResult();
		List<UserProfile> userProfileList = new ArrayList<UserProfile>();
		if(recommandManager.isUserExist(userPhoneNumber)) {
			recommandResult.setContacts(recommandManager.getRecommands(userPhoneNumber));
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

	public void setRecommandManager(IRecommandManager recommandManager) {
		this.recommandManager = recommandManager;
	}

}
