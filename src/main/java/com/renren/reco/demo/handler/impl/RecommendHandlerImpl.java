package com.renren.reco.demo.handler.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.renren.reco.demo.bean.RecommendDTO;
import com.renren.reco.demo.dao.IRecommendDAO;
import com.renren.reco.demo.handler.IRecommendHandler;

public class RecommendHandlerImpl implements IRecommendHandler {

	@Autowired
	private IRecommendDAO recommendDAO;
	
	@Override
	public List<RecommendDTO> getRecommends(long phoneNumber) {
		return recommendDAO.getRecommends(phoneNumber);
	}

	@Override
	public boolean isExist(RecommendDTO recommendDTO) {
		if(null != recommendDTO) {
			if(null != recommendDAO.getRecommend(recommendDTO.getUploaderPhoneNumber(), recommendDTO.getRecommendPhoneNumber())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void updateRecommend(RecommendDTO recommendDTO) {
		if(null != recommendDTO) {
			recommendDAO.updateRecommend(recommendDTO);
		}
	}

	@Override
	public void setRecommend(RecommendDTO recommendDTO) {
		if(null != recommendDTO) {
			recommendDAO.insertRecommend(recommendDTO);
		}
	}

	public void setRecommendDAO(IRecommendDAO recommendDAO) {
		this.recommendDAO = recommendDAO;
	}

}
