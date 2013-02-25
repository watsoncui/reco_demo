package com.renren.reco.demo.handler.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.renren.reco.demo.bean.ProfileDTO;
import com.renren.reco.demo.dao.IProfileDAO;
import com.renren.reco.demo.handler.IProfileHandler;

public class ProfileHandlerImpl implements IProfileHandler {

	@Autowired
	private IProfileDAO profileDAO;
	@Override
	public ProfileDTO getProfile(long phoneNumber) {
		return profileDAO.getProfile(phoneNumber);
	}

	@Override
	public void setProfile(ProfileDTO profileDTO) {
		if(null != profileDTO) {
			profileDAO.insertProfiles(profileDTO);
		}
	}

	@Override
	public boolean isExist(ProfileDTO profileDTO) {
		if(null != profileDTO) {
			if(null != getProfile(profileDTO.getPhoneNumber())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public List<Long> getAllPhoneNumbers() {
		return profileDAO.getProfiles();
	}
	
	public void setProfileDAO(IProfileDAO profileDAO) {
		this.profileDAO = profileDAO;
	}


}
