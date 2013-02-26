#ifndef RESULT_ICE
#define RESULT_ICE

#include <errorCode.ice>

module com {
	module renren {
		module recommand {
			module demo {
				["java:getset"]
				class BaseResult {
					
					// �Ƿ�����ɹ�
					bool success;
					
					// ������
					RecoErrorCodeEnum errorCode;
					
					// ������Ϣ
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