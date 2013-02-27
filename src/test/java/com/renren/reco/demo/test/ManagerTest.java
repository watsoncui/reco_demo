package com.renren.reco.demo.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.renren.reco.demo.bean.RecommandDTO;
import com.renren.reco.demo.bean.RelationDTO;
import com.renren.reco.demo.manager.IRecommandManager;
import com.renren.recommand.demo.UserProfile;

import net.paoding.rose.scanning.context.RoseAppContext;

public class ManagerTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RoseAppContext ctx = new RoseAppContext();
		
		IRecommandManager recommandManager = ctx.getBean(IRecommandManager.class);
		
		List<Long> phoneNumberList = recommandManager.sendProfileData();
		
		for(long phoneNumber:phoneNumberList) {
			System.out.println(phoneNumber);
		}
		System.out.println();
		
		for(long phoneNumber:phoneNumberList) {
			List<RelationDTO> relationList = recommandManager.sendRelation(phoneNumber);
			for(RelationDTO relation:relationList) {
				System.out.println(relation.getUploaderPhoneNumber());
				System.out.println(relation.getContactorPhoneNumber());
				System.out.println();
			}
			System.out.println();
		}
		System.out.println();
		
		List<RecommandDTO> recommandDTOList = new ArrayList<RecommandDTO>();
		RecommandDTO recommandDTO = new RecommandDTO();
		recommandDTO.setUploaderPhoneNumber(123456);
		recommandDTO.setRecommandPhoneNumber(12345678);
		recommandDTO.setIsSuccess(0);
		recommandDTO.setRecommandTime((new Date()).getTime());
		recommandDTO.setScore(2.0);
		recommandDTOList.add(recommandDTO);
		recommandDTO.setUploaderPhoneNumber(123456);
		recommandDTO.setRecommandPhoneNumber(87654321);
		recommandDTO.setIsSuccess(0);
		recommandDTO.setRecommandTime((new Date()).getTime());
		recommandDTO.setScore(3.0);
		recommandDTOList.add(recommandDTO);
		recommandDTO.setUploaderPhoneNumber(654321);
		recommandDTO.setRecommandPhoneNumber(12345678);
		recommandDTO.setIsSuccess(0);
		recommandDTO.setRecommandTime((new Date()).getTime());
		recommandDTO.setScore(2.0);
		recommandDTOList.add(recommandDTO);
		recommandDTO.setUploaderPhoneNumber(654321);
		recommandDTO.setRecommandPhoneNumber(87654321);
		recommandDTO.setIsSuccess(0);
		recommandDTO.setRecommandTime((new Date()).getTime());
		recommandDTO.setScore(3.0);
		recommandDTOList.add(recommandDTO);
		recommandManager.recieveRecommand(recommandDTOList);
		
		System.out.println(recommandManager.isUserExist(123456));
		System.out.println(recommandManager.isUserExist(1234567));
		
		for(long phoneNumber:phoneNumberList) {
			List<UserProfile> userProfileList = recommandManager.getRecommands(phoneNumber);
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
