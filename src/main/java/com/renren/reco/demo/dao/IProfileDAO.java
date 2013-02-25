package com.renren.reco.demo.dao;

import java.util.List;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.SQL;

import com.renren.reco.demo.bean.ProfileDTO;
import com.renren.reco.demo.util.DataSourceCatalog;

@DAO
public interface IProfileDAO {
	final static String TABLE = "users";
	final static String PN = "phone_number";
	
	@SQL("INSERT INTO " + TABLE + " ( " + PN + " ) VALUES ( :1.phoneNumber )")
	public void insertProfiles(ProfileDTO profileDTO);
		
	@SQL("SELECT " + PN + " FROM " + TABLE )
	public List<Long> getProfiles();
	
	@SQL("SELECT " + PN + " FROM " + TABLE + " WHERE " + PN + "=:1")
	public ProfileDTO getProfile(long phoneNumber);
}
