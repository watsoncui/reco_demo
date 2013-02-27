package com.renren.reco.demo.test;

import java.util.Date;
import java.util.List;

import com.renren.reco.demo.bean.ProfileDTO;
import com.renren.reco.demo.bean.RecommendDTO;
import com.renren.reco.demo.bean.RelationDTO;
import com.renren.reco.demo.handler.IProfileHandler;
import com.renren.reco.demo.handler.IRecommendHandler;
import com.renren.reco.demo.handler.IRelationHandler;

import net.paoding.rose.scanning.context.RoseAppContext;

public class HandlerTest {
	public static void main(String[] args) {
		RoseAppContext ctx = new RoseAppContext();
		
		IProfileHandler profileHandler = ctx.getBean(IProfileHandler.class);
		IRecommendHandler recommendHandler = ctx.getBean(IRecommendHandler.class);
		IRelationHandler relationHandler = ctx.getBean(IRelationHandler.class);
		
		ProfileDTO profileDTO = new ProfileDTO();
		profileDTO.setPhoneNumber(1234567890L);
		System.out.println(profileHandler.isExist(profileDTO));
		profileHandler.setProfile(profileDTO);
		System.out.println(profileHandler.isExist(profileDTO));
		profileDTO = profileHandler.getProfile(12345678);
		System.out.println(profileDTO.getPhoneNumber());
		System.out.println();
		List<Long> phoneNumberList = profileHandler.getAllPhoneNumbers();
		
		for(long phoneNumber:phoneNumberList) {
			System.out.println(phoneNumber);
		}
		System.out.println();
		
		RecommendDTO recommendDTO = new RecommendDTO();
    	recommendDTO.setUploaderPhoneNumber(1234567890L);
    	recommendDTO.setRecommendPhoneNumber(87654321);
    	recommendDTO.setIsSuccess(0);
    	recommendDTO.setVerifyTime(0L);
    	recommendDTO.setRecommendTime((new Date()).getTime());
    	recommendDTO.setScore(2.5);
    	System.out.println(recommendHandler.isExist(recommendDTO));
    	recommendHandler.setRecommend(recommendDTO);
    	System.out.println(recommendHandler.isExist(recommendDTO));

    	recommendDTO.setUploaderPhoneNumber(1234567890L);
    	recommendDTO.setRecommendPhoneNumber(654321);
    	recommendDTO.setIsSuccess(0);
    	recommendDTO.setVerifyTime(0L);
    	recommendDTO.setRecommendTime((new Date()).getTime());
    	recommendDTO.setScore(2.5);
    	recommendHandler.setRecommend(recommendDTO);
    	recommendDTO.setScore(3.5);
    	recommendHandler.updateRecommend(recommendDTO);
    	
    	List<RecommendDTO> recommendList = recommendHandler.getRecommends(1234567890L);
    	for(RecommendDTO recommend:recommendList) {
    		System.out.println(recommend.getRecommendPhoneNumber());
    		System.out.println(recommend.getRecommendTime());
    		System.out.println(recommend.getScore());
    		System.out.println();
    	}
    	
    	RelationDTO relationDTO = new RelationDTO();
    	relationDTO.setUploaderPhoneNumber(12345678);
    	relationDTO.setContactorPhoneNumber(1234567890L);
    	System.out.println(relationHandler.isExist(relationDTO));
    	relationHandler.setRelation(relationDTO);
    	System.out.println(relationHandler.isExist(relationDTO));
    	List<RelationDTO> relationList = relationHandler.getRelations(12345678);
    	for(RelationDTO relation:relationList) {
    		System.out.println(relation.getUploaderPhoneNumber());
    		System.out.println(relation.getContactorPhoneNumber());
    		System.out.println();
    	}
    	
    	ctx.stop();
	}
}
