package com.renren.reco.demo.test;

import java.util.Date;
import java.util.List;

import com.renren.reco.demo.bean.ProfileDTO;
import com.renren.reco.demo.bean.RecommendDTO;
import com.renren.reco.demo.bean.RelationDTO;
import com.renren.reco.demo.dao.IProfileDAO;
import com.renren.reco.demo.dao.IRecommendDAO;
import com.renren.reco.demo.dao.IRelationDAO;

import net.paoding.rose.scanning.context.RoseAppContext;

public class DAOTest {
	
    public static void main(String[] args) {

    	RoseAppContext ctx = new RoseAppContext();

        IProfileDAO profileDAO = ctx.getBean(IProfileDAO.class);
        IRecommendDAO recommendDAO = ctx.getBean(IRecommendDAO.class);
        IRelationDAO relationDAO = ctx.getBean(IRelationDAO.class);
        
        long phoneNumber = 12345678;
        
        ProfileDTO profileDTO = profileDAO.getProfile(phoneNumber);
        
        System.out.println(profileDTO.getPhoneNumber());
        System.out.println();
        
        List<Long> profileDTOList = profileDAO.getProfiles();
        
        for(long profile:profileDTOList) {
        	System.out.println(profile);
        }
        System.out.println();
        
        profileDTO = new ProfileDTO();
        profileDTO.setPhoneNumber(12345678910L);
    	profileDAO.insertProfiles(profileDTO);
    	System.out.println(profileDAO.getProfile(12345678910L).getPhoneNumber());
    	System.out.println();
    	
    	RelationDTO relationDTO = new RelationDTO();
    	relationDTO.setUploaderPhoneNumber(12345678);
    	relationDTO.setContactorPhoneNumber(12345678910L);
    	relationDAO.insertRelation(relationDTO);
    	relationDTO = relationDAO.getRelation(12345678, 12345678910L);
    	System.out.println(relationDTO.getUploaderPhoneNumber());
    	System.out.println(relationDTO.getContactorPhoneNumber());
    	System.out.println();
    	
    	List<RelationDTO> relationDTOList = relationDAO.getRelations(12345678);
    	for(RelationDTO relation:relationDTOList) {
    		System.out.println(relation.getUploaderPhoneNumber());
    		System.out.println(relation.getContactorPhoneNumber());
    	}
    	System.out.println();
    	
    	RecommendDTO recommendDTO = new RecommendDTO();
    	recommendDTO.setUploaderPhoneNumber(12345678910L);
    	recommendDTO.setRecommendPhoneNumber(87654321);
    	recommendDTO.setIsSuccess(0);
    	recommendDTO.setVerifyTime(0L);
    	recommendDTO.setRecommendTime((new Date()).getTime());
    	recommendDTO.setScore(2.5);
    	recommendDAO.insertRecommend(recommendDTO);
    	recommendDTO.setUploaderPhoneNumber(12345678910L);
    	recommendDTO.setRecommendPhoneNumber(654321);
    	recommendDTO.setIsSuccess(0);
    	recommendDTO.setVerifyTime(0L);
    	recommendDTO.setRecommendTime((new Date()).getTime());
    	recommendDTO.setScore(2.5);
    	recommendDAO.insertRecommend(recommendDTO);
    	recommendDTO.setScore(3.5);
    	recommendDAO.updateRecommend(recommendDTO);
    	
    	recommendDTO = recommendDAO.getRecommend(12345678910L, 654321);
    	System.out.println(recommendDTO.getUploaderPhoneNumber());
    	System.out.println(recommendDTO.getRecommendPhoneNumber());
    	System.out.println(recommendDTO.getScore());
    	System.out.println();
    	
    	List<RecommendDTO> recommendDTOList = recommendDAO.getRecommends(12345678910L);
    	for(int i = 0; i < recommendDTOList.size(); i++) {
    		System.out.println(recommendDTOList.get(i).getRecommendPhoneNumber());
    		System.out.println(recommendDTOList.get(i).getScore());
    		System.out.println();
    	}
    	
    	ctx.stop();
    }
}