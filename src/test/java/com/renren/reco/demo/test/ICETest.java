package com.renren.reco.demo.test;

import Ice.Util;

import com.renren.recommand.demo.RecoServicePrx;
import com.renren.recommand.demo.RecoServicePrxHelper;
import com.renren.recommand.demo.RecommandResult;

public class ICETest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ice.Communicator ic = Util.initialize();
		 Ice.ObjectPrx base = ic.stringToProxy("RecommendService:default -h 10.4.16.206 -p 10000");
		 RecoServicePrx recommendService = RecoServicePrxHelper.checkedCast(base);
         
		 RecommandResult result = recommendService.getRecommandation(13001106232L);
		 System.out.println(result.getSuccess());
		 System.out.println(result.getErrorCode());
		 System.out.println(result.getErrorMessage());
	}

}
