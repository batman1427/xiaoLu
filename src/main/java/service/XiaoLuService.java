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
}
