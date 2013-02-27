package com.renren.reco.demo.handler;

import java.util.List;

import com.renren.reco.demo.bean.RecommendDTO;

public interface IRecommendHandler {
	public List<RecommendDTO> getRecommends(long phoneNumber);
	public boolean isExist(RecommendDTO recommendDTO);
	public void updateRecommend(RecommendDTO recommendDTO);
	public void setRecommend(RecommendDTO recommendDTO);
}
