#ifndef SERVICE_ICE
#define SERVICE_ICE

#include<result.ice>

module com {
	module renren {
		module recommand {
			module demo {
				["java:getset"]	
				class RecommandResult extends BaseResult {
					
					// 推荐联系人集合
					RecommandList contacts;
				};
				
				interface RecoService {
					RecommandResult getRecommandation(long userPhoneNumber);
				};
			};
		};
	};
};

#endif