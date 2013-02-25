package com.renren.reco.demo.handler;

import java.util.List;

import com.renren.reco.demo.bean.ProfileDTO;

public interface IProfileHandler {
	public ProfileDTO getProfile(long phoneNumber);
	public void setProfile(ProfileDTO profileDTO);
	public boolean isExist(ProfileDTO profileDTO);
	public List<Long> getAllPhoneNumbers();
}
