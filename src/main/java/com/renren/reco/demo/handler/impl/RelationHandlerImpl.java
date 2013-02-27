package com.renren.reco.demo.handler.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.renren.reco.demo.bean.RelationDTO;
import com.renren.reco.demo.dao.IRelationDAO;
import com.renren.reco.demo.handler.IRelationHandler;

public class RelationHandlerImpl implements IRelationHandler {

	@Autowired
	private IRelationDAO relationDAO;
	
	@Override
	public void setRelation(RelationDTO relationDTO) {
		if(null != relationDTO) {		
			relationDAO.insertRelation(relationDTO);
		}
	}

	@Override
	public boolean isExist(RelationDTO relationDTO) {
		if(null != relationDTO) {
			if(null != relationDAO.getRelation(relationDTO.getUploaderPhoneNumber(), relationDTO.getContactorPhoneNumber())) {
				return true;
			}
			if(null != relationDAO.getRelation(relationDTO.getContactorPhoneNumber(), relationDTO.getUploaderPhoneNumber())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public List<RelationDTO> getRelations(long phoneNumber) {
		return relationDAO.getRelations(phoneNumber);
		
	}
	
	@Override
	public List<RelationDTO> getReverseRelations(long phoneNumber) {
		return relationDAO.getReverseRelations(phoneNumber);
	}
	public void setRelationDAO(IRelationDAO relationDAO) {
		this.relationDAO = relationDAO;
	}

}
