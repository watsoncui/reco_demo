package com.renren.reco.demo.dao;

import java.util.List;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.SQL;

import com.renren.reco.demo.bean.RecommandDTO;

@DAO
public interface IRecommandDAO {
	final static String TABLE = "recommand";
	final static String OPN = "uploader_phone_number";
	final static String APN = "recommand_phone_number";
	
	@SQL("INSERT INTO " + TABLE + " ( " + OPN + " ," + APN + " ,recommand_time, verify_time, is_success, score ) VALUES ( :1.uploaderPhoneNumber, :1.recommandPhoneNumber, :1.recommandTime, :1.verifyTime, :1.isSuccess, :1.score)")
	public void insertRecommand(RecommandDTO recommandDTO);
	
	@SQL("UPDATE " + TABLE + " SET recommand_time=:1.recommandTime, verify_time=:1.verifyTime, is_success=:1.isSuccess, score=:1.score WHERE " + OPN + "=:1.uploaderPhoneNumber AND " + APN + "=:1.recommandPhoneNumber")
	public void updateRecommand(RecommandDTO recommandDTO);
	
	@SQL("SELECT " + OPN + " ," + APN + ", recommand_time, verify_time, is_success, score FROM " + TABLE + " WHERE " + OPN + "=:1 AND " + APN + " =:2")
	public RecommandDTO getRecommand(long uploaderPhoneNumber, long recommandPhoneNumber);
	
	@SQL("SELECT " + OPN + " ," + APN + ", recommand_time, verify_time, is_success, score FROM " + TABLE + " WHERE " + OPN + "=:1 ORDER BY score DESC")
	public List<RecommandDTO> getRecommands(long uploaderPhoneNumber);
}
