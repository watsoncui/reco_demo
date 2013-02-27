package com.renren.reco.demo.dao;

import java.util.List;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.SQL;

import com.renren.reco.demo.bean.RecommendDTO;

@DAO
public interface IRecommendDAO {
	final static String TABLE = "recommend";
	final static String OPN = "uploader_phone_number";
	final static String APN = "recommend_phone_number";
	
	@SQL("INSERT INTO " + TABLE + " ( " + OPN + " ," + APN + " ,recommend_time, verify_time, is_success, score ) VALUES ( :1.uploaderPhoneNumber, :1.recommendPhoneNumber, :1.recommendTime, :1.verifyTime, :1.isSuccess, :1.score)")
	public void insertRecommend(RecommendDTO recommendDTO);
	
	@SQL("UPDATE " + TABLE + " SET recommend_time=:1.recommendTime, verify_time=:1.verifyTime, is_success=:1.isSuccess, score=:1.score WHERE " + OPN + "=:1.uploaderPhoneNumber AND " + APN + "=:1.recommendPhoneNumber")
	public void updateRecommend(RecommendDTO recommendDTO);
	
	@SQL("SELECT " + OPN + " ," + APN + ", recommend_time, verify_time, is_success, score FROM " + TABLE + " WHERE " + OPN + "=:1 AND " + APN + " =:2")
	public RecommendDTO getRecommend(long uploaderPhoneNumber, long recommendPhoneNumber);
	
	@SQL("SELECT " + OPN + " ," + APN + ", recommend_time, verify_time, is_success, score FROM " + TABLE + " WHERE " + OPN + "=:1 ORDER BY score DESC")
	public List<RecommendDTO> getRecommends(long uploaderPhoneNumber);
}
