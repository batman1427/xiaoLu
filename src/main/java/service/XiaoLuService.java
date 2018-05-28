package service;

import auxiliary.ResultData;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface XiaoLuService {
        ResultData upload(Map<String, Object> condition);
}
