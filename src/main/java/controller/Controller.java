package controller;

import auxiliary.ErrorLog;
import auxiliary.ResponseCode;
import auxiliary.ResultData;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import service.XiaoLuService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class Controller {

    @Autowired
    private XiaoLuService xiaoLuService;

    /**
     * This method is used to upload files.
     * @return
     */
    @CrossOrigin
    @RequestMapping("/upload")
    public ResultData upload(MultipartHttpServletRequest request) {
        ResultData result = new ResultData();
        MultipartFile file = request.getFile("data_file");
        Map<String, Object> condition = new HashMap<String, Object>();
        condition.put("file", file);
        ResultData response = xiaoLuService.upload(condition);
        JSONArray json = new JSONArray();
        if (response.getResponseCode() == ResponseCode.RESPONSE_ERROR) {
            JSONObject title = new JSONObject();
            title.put("errorLog", "上传失败！");
            json.add(title);
            result.setResponseCode(ResponseCode.RESPONSE_ERROR);
            result.setDescription("Fail to upload the file");
            result.setData(json);
            return result;
        }else{
            List<ErrorLog> errorLogs = (List<ErrorLog>) response.getData();
            result.setResponseCode(ResponseCode.RESPONSE_OK);
            if(errorLogs.size() == 0){
                JSONObject title = new JSONObject();
                title.put("errorLog", "上传成功！");
                json.add(title);
                result.setData(json);
                return result;
            }
            JSONObject title = new JSONObject();
            title.put("errorLog", "部分内容上传成功！");
            json.add(title);
            for(ErrorLog errorLog : errorLogs){
                JSONObject temp = new JSONObject();
                temp.put("errorLog", errorLog.toString());
                json.add(temp);
            }
            result.setData(json);
            return result;
        }
    }

}
