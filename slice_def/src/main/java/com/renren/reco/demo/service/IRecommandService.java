package com.renren.reco.demo.service;

import com.renren.recommand.demo.RecommandResult;

public interface IRecommandService {
	RecommandResult getRecommandation(long userPhoneNumber);
}
