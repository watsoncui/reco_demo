package com.renren.reco.demo.dao;

import java.util.List;

import com.renren.reco.demo.bean.RelationDTO;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.SQL;

@DAO
public interface IRelationDAO {
	
	final static String TABLE = "user_relation";
	final static String OPN = "uploader_phone_number";
	final static String APN = "contactor_phone_number";
	
	@SQL("INSERT INTO " + TABLE + " ( " + OPN + " ," + APN + " ) VALUES ( :1.uploaderPhoneNumber, :1.contactorPhoneNumber )")
	public void insertRelation(RelationDTO relationDTO);
	
	//public void deleteRelation(RelationDTO relationDTO);
	
	@SQL("SELECT " + OPN + " ," + APN + " FROM " + TABLE + " WHERE " + OPN + "=:1")
	public List<RelationDTO> getRelations(long uploaderPhoneNumber);
	
	@SQL("SELECT " + OPN + " ," + APN + " FROM " + TABLE + " WHERE " + APN + "=:1")
	public List<RelationDTO> getReverseRelations(long contactor_phone_number);
	
	@SQL("SELECT " + OPN + " ," + APN + " FROM " + TABLE + " WHERE " + OPN + "=:1 AND " + APN + " =:2")
	public RelationDTO getRelation(long uploaderPhoneNumber, long contactorPhoneNumber);
}
