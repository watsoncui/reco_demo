#ifndef RESULT_ICE
#define RESULT_ICE

#include <errorCode.ice>

module com {
	module renren {
		module recommand {
			module demo {
				["java:getset"]
				class BaseResult {
					
					// 是否操作成功
					bool success;
					
					// 错误码
					RecoErrorCodeEnum errorCode;
					
					// 错误消息
					string errorMessage;
				
				};
				
				
				["java:getset"]
				class UserProfile{
					
					string userName;
					
					long phoneNumber;
					
					double score;
					
				};
				
				["java:type:java.util.ArrayList"]sequence<UserProfile> RecommandList;
			};
		};
	};
};

#endif