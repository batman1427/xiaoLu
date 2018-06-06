package service;

import auxiliary.ResultData;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface XiaoLuService {
        ResultData upload(Map<String, Object> condition);

        ResultData fetchIntermediary(Map<String, Object> condition);

        ResultData searchIntermediary(Map<String, Object> condition);

        ResultData fetchCallCustomer(Map<String, Object> condition);

        ResultData searchCallCustomer(Map<String, Object> condition);

        ResultData fetchExtension(Map<String, Object> condition);

        ResultData searchExtension(Map<String, Object> condition);

        ResultData fetchIncomingCall(Map<String, Object> condition);

        ResultData searchIncomingCall(Map<String, Object> condition);

        ResultData fetchVisit(Map<String, Object> condition);

        ResultData searchVisit(Map<String, Object> condition);

        ResultData fetchDeal(Map<String, Object> condition);

        ResultData searchDeal(Map<String, Object> condition);

        ResultData fetchSummary(Map<String, Object> condition);

        ResultData screenSummary(Map<String, Object> condition);
}
