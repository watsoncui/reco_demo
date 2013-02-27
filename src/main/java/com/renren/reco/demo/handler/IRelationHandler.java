package com.renren.reco.demo.handler;

import java.util.List;

import com.renren.reco.demo.bean.RelationDTO;

public interface IRelationHandler {
	public void setRelation(RelationDTO relationDTO);
	public boolean isExist(RelationDTO relationDTO);
	public List<RelationDTO> getRelations(long phoneNumber);
	public List<RelationDTO> getReverseRelations(long phoneNumber);
}
