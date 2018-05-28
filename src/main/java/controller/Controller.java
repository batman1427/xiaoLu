package controller;

import auxiliary.ResponseCode;
import auxiliary.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import service.XiaoLuService;

import java.util.HashMap;
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
        if (response.getResponseCode() == ResponseCode.RESPONSE_ERROR) {
            result.setResponseCode(ResponseCode.RESPONSE_ERROR);
            result.setDescription("Fail to upload the file");
            return result;
        }
        result.setResponseCode(ResponseCode.RESPONSE_OK);
        result.setDescription(file.getOriginalFilename()+"has been saved.");
        return result;
    }

}
