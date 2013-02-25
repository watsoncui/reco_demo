package com.renren.reco.demo.handler.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.renren.reco.demo.bean.RecommandDTO;
import com.renren.reco.demo.dao.IRecommandDAO;
import com.renren.reco.demo.handler.IRecommandHandler;

public class RecommandHandlerImpl implements IRecommandHandler {

	@Autowired
	private IRecommandDAO recommandDAO;
	
	@Override
	public List<RecommandDTO> getRecommands(long phoneNumber) {
		return recommandDAO.getRecommands(phoneNumber);
	}

	@Override
	public boolean isExist(RecommandDTO recommandDTO) {
		if(null != recommandDTO) {
			if(null != recommandDAO.getRecommand(recommandDTO.getUploaderPhoneNumber(), recommandDTO.getRecommandPhoneNumber())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void updateRecommand(RecommandDTO recommandDTO) {
		if(null != recommandDTO) {
			recommandDAO.updateRecommand(recommandDTO);
		}
	}

	@Override
	public void setRecommand(RecommandDTO recommandDTO) {
		if(null != recommandDTO) {
			recommandDAO.insertRecommand(recommandDTO);
		}
	}

	public void setRecommandDAO(IRecommandDAO recommandDAO) {
		this.recommandDAO = recommandDAO;
	}

}
