package com.renren.reco.demo.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.renren.reco.demo.bean.RecommendDTO;
import com.renren.reco.demo.bean.RelationDTO;
import com.renren.reco.demo.manager.IRecommendManager;
import com.renren.recommand.demo.UserProfile;

import net.paoding.rose.scanning.context.RoseAppContext;

public class ManagerTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RoseAppContext ctx = new RoseAppContext();
		
		IRecommendManager recommendManager = ctx.getBean(IRecommendManager.class);
		
		List<Long> phoneNumberList = recommendManager.sendProfileData();
		
		for(long phoneNumber:phoneNumberList) {
			System.out.println(phoneNumber);
		}
		System.out.println();
		
		for(long phoneNumber:phoneNumberList) {
			List<RelationDTO> relationList = recommendManager.sendRelation(phoneNumber);
			for(RelationDTO relation:relationList) {
				System.out.println(relation.getUploaderPhoneNumber());
				System.out.println(relation.getContactorPhoneNumber());
				System.out.println();
			}
			System.out.println();
		}
		System.out.println();
		
		List<RecommendDTO> recommendDTOList = new ArrayList<RecommendDTO>();
		RecommendDTO recommendDTO = new RecommendDTO();
		recommendDTO.setUploaderPhoneNumber(123456);
		recommendDTO.setRecommendPhoneNumber(12345678);
		recommendDTO.setIsSuccess(0);
		recommendDTO.setRecommendTime((new Date()).getTime());
		recommendDTO.setScore(2.0);
		recommendDTOList.add(recommendDTO);
		recommendDTO.setUploaderPhoneNumber(123456);
		recommendDTO.setRecommendPhoneNumber(87654321);
		recommendDTO.setIsSuccess(0);
		recommendDTO.setRecommendTime((new Date()).getTime());
		recommendDTO.setScore(3.0);
		recommendDTOList.add(recommendDTO);
		recommendDTO.setUploaderPhoneNumber(654321);
		recommendDTO.setRecommendPhoneNumber(12345678);
		recommendDTO.setIsSuccess(0);
		recommendDTO.setRecommendTime((new Date()).getTime());
		recommendDTO.setScore(2.0);
		recommendDTOList.add(recommendDTO);
		recommendDTO.setUploaderPhoneNumber(654321);
		recommendDTO.setRecommendPhoneNumber(87654321);
		recommendDTO.setIsSuccess(0);
		recommendDTO.setRecommendTime((new Date()).getTime());
		recommendDTO.setScore(3.0);
		recommendDTOList.add(recommendDTO);
		recommendManager.recieveRecommend(recommendDTOList);
		
		System.out.println(recommendManager.isUserExist(123456));
		System.out.println(recommendManager.isUserExist(1234567));
		
		for(long phoneNumber:phoneNumberList) {
			List<UserProfile> userProfileList = recommendManager.getRecommends(phoneNumber);
			for(UserProfile userProfile:userProfileList) {
				System.out.println(userProfile.getUserName());
				System.out.println(userProfile.getPhoneNumber());
				System.out.println(userProfile.getScore());
				System.out.println();
			}
			
			System.out.println();
		}
		System.out.println();
		
		ctx.stop();
	}

}
