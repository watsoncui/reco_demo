package com.renren.reco.demo.test;

import java.util.Date;
import java.util.List;

import com.renren.reco.demo.bean.ProfileDTO;
import com.renren.reco.demo.bean.RecommandDTO;
import com.renren.reco.demo.bean.RelationDTO;
import com.renren.reco.demo.handler.IProfileHandler;
import com.renren.reco.demo.handler.IRecommandHandler;
import com.renren.reco.demo.handler.IRelationHandler;

import net.paoding.rose.scanning.context.RoseAppContext;

public class HandlerTest {
	public static void main(String[] args) {
		RoseAppContext ctx = new RoseAppContext();
		
		IProfileHandler profileHandler = ctx.getBean(IProfileHandler.class);
		IRecommandHandler recommandHandler = ctx.getBean(IRecommandHandler.class);
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
		
		RecommandDTO recommandDTO = new RecommandDTO();
    	recommandDTO.setUploaderPhoneNumber(1234567890L);
    	recommandDTO.setRecommandPhoneNumber(87654321);
    	recommandDTO.setIsSuccess(0);
    	recommandDTO.setVerifyTime(0L);
    	recommandDTO.setRecommandTime((new Date()).getTime());
    	recommandDTO.setScore(2.5);
    	System.out.println(recommandHandler.isExist(recommandDTO));
    	recommandHandler.setRecommand(recommandDTO);
    	System.out.println(recommandHandler.isExist(recommandDTO));

    	recommandDTO.setUploaderPhoneNumber(1234567890L);
    	recommandDTO.setRecommandPhoneNumber(654321);
    	recommandDTO.setIsSuccess(0);
    	recommandDTO.setVerifyTime(0L);
    	recommandDTO.setRecommandTime((new Date()).getTime());
    	recommandDTO.setScore(2.5);
    	recommandHandler.setRecommand(recommandDTO);
    	recommandDTO.setScore(3.5);
    	recommandHandler.updateRecommand(recommandDTO);
    	
    	List<RecommandDTO> recommandList = recommandHandler.getRecommands(1234567890L);
    	for(RecommandDTO recommand:recommandList) {
    		System.out.println(recommand.getRecommandPhoneNumber());
    		System.out.println(recommand.getRecommandTime());
    		System.out.println(recommand.getScore());
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
