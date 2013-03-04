package com.renren.reco.demo.test;

import Ice.Util;

import com.renren.recommand.demo.RecoServicePrx;
import com.renren.recommand.demo.RecoServicePrxHelper;
import com.renren.recommand.demo.RecommandResult;
import com.renren.recommand.demo.UserProfile;

public class ICETest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ice.Communicator ic = Util.initialize();
		 Ice.ObjectPrx base = ic.stringToProxy("RecommendService:default -h 10.4.16.206 -p 10000");
		 RecoServicePrx recommendService = RecoServicePrxHelper.checkedCast(base);
         
		 //long user = 13311397008L;
		 long user = 13312345678L;
		 RecommandResult result = recommendService.getRecommandation(user);
		 System.out.println(result.getSuccess());
		 System.out.println(result.getErrorCode());
		 System.out.println(result.getErrorMessage());
		 int size = result.getContacts().size();
		 if(size > 0) {
			 System.out.println("recommend for user " + user);
			 for(int i = 0; i < size; i++) {
				 UserProfile profile = result.getContacts().get(i);
				 System.out.println(profile.getPhoneNumber() + " " + profile.getScore());
			 }
		 }
		 System.out.println();
	}

}
