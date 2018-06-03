package dao;

import auxiliary.ResultData;

import java.util.Map;

public interface XiaoLuDao {

    ResultData createIntermediary(Map<String, Object> condition);

    ResultData createCallCustomer(Map<String, Object> condition);

    ResultData createExtension(Map<String, Object> condition);

    ResultData createIncomingCall(Map<String, Object> condition);

    ResultData createVisit(Map<String, Object> condition);

    ResultData createDeal(Map<String, Object> condition);

    ResultData handleUnknown(Map<String, Object> condition);

    ResultData queryIntermediary(Map<String, Object> condition);

    ResultData searchIntermediary(Map<String , Object> condition);

    ResultData queryCallCustomer(Map<String, Object> condition);

    ResultData searchCallCustomer(Map<String , Object> condition);

    ResultData queryExtension(Map<String, Object> condition);

    ResultData searchExtension(Map<String , Object> condition);

    ResultData queryIncomingCall(Map<String, Object> condition);

    ResultData searchIncomingCall(Map<String , Object> condition);
}
