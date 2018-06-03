package controller;

import auxiliary.ErrorLog;
import auxiliary.ResponseCode;
import auxiliary.ResultData;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import excel.XiaoluExcel;
import form.DateForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import service.XiaoLuService;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class Controller {

    @Autowired
    private XiaoLuService xiaoLuService;

    @Autowired
    private XiaoluExcel xiaoluExcel;

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

    /**
     * This method is used to fetch intermediary.
     * @return
     */
    @CrossOrigin
    @RequestMapping("/intermediary")
    public ResultData fetchIntermediary() {
        ResultData result = new ResultData();
        Map<String, Object> condition = new HashMap<>();
        condition.put("blockFlag", false);
        ResultData response = xiaoLuService.fetchIntermediary(condition);
        result = this.setResponse(response);
        condition.clear();
        condition.put("data", response.getData());
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd-HHmmss");
        String time = format.format(date);
        condition.put("file", this.getClass().getClassLoader().getResource("").getPath()+"download/"+time+".xls");
        condition.put("response", result.getResponseCode());
        xiaoluExcel.createIntermediary(condition);
        result.setFileUrl(this.getClass().getClassLoader().getResource("").getPath()+"download/"+time+".xls");
        return result;
    }

    /**
     * This method is used to fetch intermediary by conditon.
     * @return
     */
    @CrossOrigin
    @RequestMapping("/intermediary/search")
    public ResultData fetchIntermediaryByConditon(DateForm form) {
        String startDate = form.getStartDate().trim();
        String endDate = form.getEndDate().trim();
        ResultData result = new ResultData();
        Map<String, Object> condition = new HashMap<>();
        condition.put("blockFlag", false);
        if(!startDate.equals("")) {
            condition.put("startDate", startDate.replace("-", ""));
        }
        if(!endDate.equals("")) {
            condition.put("endDate", endDate.replace("-", ""));
        }
        ResultData response = xiaoLuService.searchIntermediary(condition);
        result = this.setResponse(response);
        condition.clear();
        condition.put("data", response.getData());
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd-HHmmss");
        String time = format.format(date);
        condition.put("file", this.getClass().getClassLoader().getResource("").getPath()+"download/"+time+".xls");
        condition.put("response", result.getResponseCode());
        xiaoluExcel.createIntermediary(condition);
        result.setFileUrl(this.getClass().getClassLoader().getResource("").getPath()+"download/"+time+".xls");
        return result;
    }

    /**
     * This method is used to fetch callcustomer.
     * @return
     */
    @CrossOrigin
    @RequestMapping("/callcustomer")
    public ResultData fetchCallCustomer() {
        ResultData result = new ResultData();
        Map<String, Object> condition = new HashMap<>();
        condition.put("blockFlag", false);
        ResultData response = xiaoLuService.fetchCallCustomer(condition);
        result = this.setResponse(response);
        condition.clear();
        condition.put("data", response.getData());
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd-HHmmss");
        String time = format.format(date);
        condition.put("file", this.getClass().getClassLoader().getResource("").getPath()+"download/"+time+".xls");
        condition.put("response", result.getResponseCode());
        xiaoluExcel.createCallCustomer(condition);
        result.setFileUrl(this.getClass().getClassLoader().getResource("").getPath()+"download/"+time+".xls");
        return result;
    }

    /**
     * This method is used to fetch callcustomer by conditon.
     * @return
     */
    @CrossOrigin
    @RequestMapping("/callcustomer/search")
    public ResultData fetchCallCustomerByConditon(DateForm form) {
        String startDate = form.getStartDate().trim();
        String endDate = form.getEndDate().trim();
        ResultData result = new ResultData();
        Map<String, Object> condition = new HashMap<>();
        condition.put("blockFlag", false);
        if(!startDate.equals("")) {
            condition.put("startDate", startDate.replace("-", ""));
        }
        if(!endDate.equals("")) {
            condition.put("endDate", endDate.replace("-", ""));
        }
        ResultData response = xiaoLuService.searchCallCustomer(condition);
        result = this.setResponse(response);
        condition.clear();
        condition.put("data", response.getData());
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd-HHmmss");
        String time = format.format(date);
        condition.put("file", this.getClass().getClassLoader().getResource("").getPath()+"download/"+time+".xls");
        condition.put("response", result.getResponseCode());
        xiaoluExcel.createCallCustomer(condition);
        result.setFileUrl(this.getClass().getClassLoader().getResource("").getPath()+"download/"+time+".xls");
        return result;
    }

    /**
     * This method is used to fetch extension.
     * @return
     */
    @CrossOrigin
    @RequestMapping("/extension")
    public ResultData fetchExtension() {
        ResultData result = new ResultData();
        Map<String, Object> condition = new HashMap<>();
        condition.put("blockFlag", false);
        ResultData response = xiaoLuService.fetchExtension(condition);
        result = this.setResponse(response);
        condition.clear();
        condition.put("data", response.getData());
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd-HHmmss");
        String time = format.format(date);
        condition.put("file", this.getClass().getClassLoader().getResource("").getPath()+"download/"+time+".xls");
        condition.put("response", result.getResponseCode());
        xiaoluExcel.createExtension(condition);
        result.setFileUrl(this.getClass().getClassLoader().getResource("").getPath()+"download/"+time+".xls");
        return result;
    }

    /**
     * This method is used to fetch extension by conditon.
     * @return
     */
    @CrossOrigin
    @RequestMapping("/extension/search")
    public ResultData fetchExtensionByConditon(DateForm form) {
        String startDate = form.getStartDate().trim();
        String endDate = form.getEndDate().trim();
        ResultData result = new ResultData();
        Map<String, Object> condition = new HashMap<>();
        condition.put("blockFlag", false);
        if(!startDate.equals("")) {
            condition.put("startDate", startDate.replace("-", ""));
        }
        if(!endDate.equals("")) {
            condition.put("endDate", endDate.replace("-", ""));
        }
        ResultData response = xiaoLuService.searchExtension(condition);
        result = this.setResponse(response);
        condition.clear();
        condition.put("data", response.getData());
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd-HHmmss");
        String time = format.format(date);
        condition.put("file", this.getClass().getClassLoader().getResource("").getPath()+"download/"+time+".xls");
        condition.put("response", result.getResponseCode());
        xiaoluExcel.createExtension(condition);
        result.setFileUrl(this.getClass().getClassLoader().getResource("").getPath()+"download/"+time+".xls");
        return result;
    }

    /**
     * This method is used to fetch incomingcall.
     * @return
     */
    @CrossOrigin
    @RequestMapping("/incomingcall")
    public ResultData fetchIncomingCall() {
        ResultData result = new ResultData();
        Map<String, Object> condition = new HashMap<>();
        condition.put("blockFlag", false);
        ResultData response = xiaoLuService.fetchIncomingCall(condition);
        result = this.setResponse(response);
        condition.clear();
        condition.put("data", response.getData());
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd-HHmmss");
        String time = format.format(date);
        condition.put("file", this.getClass().getClassLoader().getResource("").getPath()+"download/"+time+".xls");
        condition.put("response", result.getResponseCode());
        xiaoluExcel.createIncomingCall(condition);
        result.setFileUrl(this.getClass().getClassLoader().getResource("").getPath()+"download/"+time+".xls");
        return result;
    }

    /**
     * This method is used to fetch incomingcall by conditon.
     * @return
     */
    @CrossOrigin
    @RequestMapping("/incomingcall/search")
    public ResultData fetchIncomingCallByConditon(DateForm form) {
        String startDate = form.getStartDate().trim();
        String endDate = form.getEndDate().trim();
        ResultData result = new ResultData();
        Map<String, Object> condition = new HashMap<>();
        condition.put("blockFlag", false);
        if(!startDate.equals("")) {
            condition.put("startDate", startDate.replace("-", ""));
        }
        if(!endDate.equals("")) {
            condition.put("endDate", endDate.replace("-", ""));
        }
        ResultData response = xiaoLuService.searchIncomingCall(condition);
        result = this.setResponse(response);
        condition.clear();
        condition.put("data", response.getData());
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd-HHmmss");
        String time = format.format(date);
        condition.put("file", this.getClass().getClassLoader().getResource("").getPath()+"download/"+time+".xls");
        condition.put("response", result.getResponseCode());
        xiaoluExcel.createIncomingCall(condition);
        result.setFileUrl(this.getClass().getClassLoader().getResource("").getPath()+"download/"+time+".xls");
        return result;
    }

    /**
     * This method is used to fetch visit.
     * @return
     */
    @CrossOrigin
    @RequestMapping("/visit")
    public ResultData fetchVisit() {
        ResultData result = new ResultData();
        Map<String, Object> condition = new HashMap<>();
        condition.put("blockFlag", false);
        ResultData response = xiaoLuService.fetchVisit(condition);
        result = this.setResponse(response);
        condition.clear();
        condition.put("data", response.getData());
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd-HHmmss");
        String time = format.format(date);
        condition.put("file", this.getClass().getClassLoader().getResource("").getPath()+"download/"+time+".xls");
        condition.put("response", result.getResponseCode());
        xiaoluExcel.createVisit(condition);
        result.setFileUrl(this.getClass().getClassLoader().getResource("").getPath()+"download/"+time+".xls");
        return result;
    }

    /**
     * This method is used to fetch visit by conditon.
     * @return
     */
    @CrossOrigin
    @RequestMapping("/visit/search")
    public ResultData fetchVisitByConditon(DateForm form) {
        String startDate = form.getStartDate().trim();
        String endDate = form.getEndDate().trim();
        ResultData result = new ResultData();
        Map<String, Object> condition = new HashMap<>();
        condition.put("blockFlag", false);
        if(!startDate.equals("")) {
            condition.put("startDate", startDate.replace("-", ""));
        }
        if(!endDate.equals("")) {
            condition.put("endDate", endDate.replace("-", ""));
        }
        ResultData response = xiaoLuService.searchVisit(condition);
        result = this.setResponse(response);
        condition.clear();
        condition.put("data", response.getData());
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd-HHmmss");
        String time = format.format(date);
        condition.put("file", this.getClass().getClassLoader().getResource("").getPath()+"download/"+time+".xls");
        condition.put("response", result.getResponseCode());
        xiaoluExcel.createVisit(condition);
        result.setFileUrl(this.getClass().getClassLoader().getResource("").getPath()+"download/"+time+".xls");
        return result;
    }

    /**
     * This method is used to fetch deal.
     * @return
     */
    @CrossOrigin
    @RequestMapping("/deal")
    public ResultData fetchDeal() {
        ResultData result = new ResultData();
        Map<String, Object> condition = new HashMap<>();
        condition.put("blockFlag", false);
        ResultData response = xiaoLuService.fetchDeal(condition);
        result = this.setResponse(response);
        condition.clear();
        condition.put("data", response.getData());
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd-HHmmss");
        String time = format.format(date);
        condition.put("file", this.getClass().getClassLoader().getResource("").getPath()+"download/"+time+".xls");
        condition.put("response", result.getResponseCode());
        xiaoluExcel.createDeal(condition);
        result.setFileUrl(this.getClass().getClassLoader().getResource("").getPath()+"download/"+time+".xls");
        return result;
    }

    /**
     * This method is used to fetch deal by conditon.
     * @return
     */
    @CrossOrigin
    @RequestMapping("/deal/search")
    public ResultData fetchDealByConditon(DateForm form) {
        String startDate = form.getStartDate().trim();
        String endDate = form.getEndDate().trim();
        ResultData result = new ResultData();
        Map<String, Object> condition = new HashMap<>();
        condition.put("blockFlag", false);
        if(!startDate.equals("")) {
            condition.put("startDate", startDate.replace("-", ""));
        }
        if(!endDate.equals("")) {
            condition.put("endDate", endDate.replace("-", ""));
        }
        ResultData response = xiaoLuService.searchDeal(condition);
        result = this.setResponse(response);
        condition.clear();
        condition.put("data", response.getData());
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd-HHmmss");
        String time = format.format(date);
        condition.put("file", this.getClass().getClassLoader().getResource("").getPath()+"download/"+time+".xls");
        condition.put("response", result.getResponseCode());
        xiaoluExcel.createDeal(condition);
        result.setFileUrl(this.getClass().getClassLoader().getResource("").getPath()+"download/"+time+".xls");
        return result;
    }

    /**
     * This method is used to export file.
     * @return
     */
    @CrossOrigin
    @RequestMapping("/export")
    public void export(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String fileUrl = request.getParameter("fileName");
        File f = new File(fileUrl);
        if(f.exists()){
            FileInputStream fis = new FileInputStream(f);
            String filename=URLEncoder.encode(f.getName(),"utf-8"); //解决中文文件名下载后乱码的问题
            byte[] b = new byte[fis.available()];
            fis.read(b);
            response.setCharacterEncoding("utf-8");
            response.setHeader("Content-Disposition","attachment; filename="+filename+"");
            ServletOutputStream out =response.getOutputStream();
            out.write(b);
            out.flush();
            out.close();
        }
    }

    public ResultData setResponse(ResultData response){
        ResultData result = new ResultData();
        if (response.getResponseCode() == ResponseCode.RESPONSE_OK) {
            result.setResponseCode(ResponseCode.RESPONSE_OK);
            result.setData(response.getData());
            return result;
        }else if(response.getResponseCode() == ResponseCode.RESPONSE_NULL){
            result.setResponseCode(ResponseCode.RESPONSE_NULL);
            result.setDescription(response.getDescription());
            return result;
        }else{
            result.setResponseCode(ResponseCode.RESPONSE_ERROR);
            result.setDescription(response.getDescription());
            return result;
        }
    }

}
