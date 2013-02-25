package com.renren.reco.demo.test;

import java.util.Date;
import java.util.List;

import com.renren.reco.demo.bean.ProfileDTO;
import com.renren.reco.demo.bean.RecommandDTO;
import com.renren.reco.demo.bean.RelationDTO;
import com.renren.reco.demo.dao.IProfileDAO;
import com.renren.reco.demo.dao.IRecommandDAO;
import com.renren.reco.demo.dao.IRelationDAO;

import net.paoding.rose.scanning.context.RoseAppContext;

public class DAOTest {
	
    public static void main(String[] args) {

    	RoseAppContext ctx = new RoseAppContext();

        IProfileDAO profileDAO = ctx.getBean(IProfileDAO.class);
        IRecommandDAO recommandDAO = ctx.getBean(IRecommandDAO.class);
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
    	
    	RecommandDTO recommandDTO = new RecommandDTO();
    	recommandDTO.setUploaderPhoneNumber(12345678910L);
    	recommandDTO.setRecommandPhoneNumber(87654321);
    	recommandDTO.setIsSuccess(0);
    	recommandDTO.setVerifyTime(0L);
    	recommandDTO.setRecommandTime((new Date()).getTime());
    	recommandDTO.setScore(2.5);
    	recommandDAO.insertRecommand(recommandDTO);
    	recommandDTO.setUploaderPhoneNumber(12345678910L);
    	recommandDTO.setRecommandPhoneNumber(654321);
    	recommandDTO.setIsSuccess(0);
    	recommandDTO.setVerifyTime(0L);
    	recommandDTO.setRecommandTime((new Date()).getTime());
    	recommandDTO.setScore(2.5);
    	recommandDAO.insertRecommand(recommandDTO);
    	recommandDTO.setScore(3.5);
    	recommandDAO.updateRecommand(recommandDTO);
    	
    	recommandDTO = recommandDAO.getRecommand(12345678910L, 654321);
    	System.out.println(recommandDTO.getUploaderPhoneNumber());
    	System.out.println(recommandDTO.getRecommandPhoneNumber());
    	System.out.println(recommandDTO.getScore());
    	System.out.println();
    	
    	List<RecommandDTO> recommandDTOList = recommandDAO.getRecommands(12345678910L);
    	for(int i = 0; i < recommandDTOList.size(); i++) {
    		System.out.println(recommandDTOList.get(i).getRecommandPhoneNumber());
    		System.out.println(recommandDTOList.get(i).getScore());
    		System.out.println();
    	}
    	
    	ctx.stop();
    }
}