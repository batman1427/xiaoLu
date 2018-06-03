package service.impl;

import auxiliary.ErrorLog;
import auxiliary.ResponseCode;
import auxiliary.ResultData;
import dao.XiaoLuDao;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import service.XiaoLuService;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class XiaoLuServiceImpl implements XiaoLuService {

    @Autowired
    XiaoLuDao xiaoLuDao;

    @Override
    public ResultData upload(Map<String, Object> condition) {
        ResultData result = new ResultData();
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd-HHmmss");
        String time = format.format(date);
        MultipartFile file = (MultipartFile) condition.get("file");
        String path = this.getClass().getClassLoader().getResource("").getPath()+"records/"+time+"/"+file.getOriginalFilename();
        File data = new File(path);
        if(!data.getParentFile().exists()){
            data.getParentFile().mkdirs();
        }
        try {
            file.transferTo(data);
        } catch (IOException e) {
            result.setResponseCode(ResponseCode.RESPONSE_ERROR);
            result.setDescription(e.getMessage());
        }
        try {
            Workbook workbook = WorkbookFactory.create(new File(path));
            int countSheet = workbook.getNumberOfSheets();
            List<ErrorLog> errorLogList = new ArrayList<ErrorLog>();
            for(int i=0;i<countSheet;i++){
                Sheet sheet = workbook.getSheetAt(i);
                ResultData response = this.save(file, sheet, workbook);
                if(response.getResponseCode() == ResponseCode.RESPONSE_ERROR){
                    return response;
                }else{
                    List<ErrorLog> tempErrorLogs = (List<ErrorLog>)response.getData();
                    if(tempErrorLogs != null){
                        errorLogList.addAll(tempErrorLogs);
                    }
                    result.setData(errorLogList);
                }
            }
            System.out.println("所有表格处理完成。");
        } catch (IOException e) {
            result.setResponseCode(ResponseCode.RESPONSE_ERROR);
            result.setDescription(e.getMessage());
        } catch (InvalidFormatException e) {
            result.setResponseCode(ResponseCode.RESPONSE_ERROR);
            result.setDescription(e.getMessage());
        }
        String logFile=this.getClass().getClassLoader().getResource("").getPath()+"records/"+time+"/"+"errorLog.txt";
        try {
            BufferedWriter out=new BufferedWriter(new FileWriter(logFile));
            List<ErrorLog> errorLogs = (List<ErrorLog>)result.getData();
            for(ErrorLog errorLog: errorLogs){
                out.write(errorLog.toString());
                out.newLine();
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public ResultData save(MultipartFile file, Sheet sheet, Workbook workbook){
        Map<String, Object> condition = new HashMap<String, Object>();
        ResultData result = new ResultData();
        condition.put("sheet", sheet);
        condition.put("file", file);
        condition.put("workbook", workbook);
        String sheetName = sheet.getSheetName();
        switch(sheetName){
            case "中介带访":
                result = xiaoLuDao.createIntermediary(condition);
                break;
            case "CALL客表":
                result = xiaoLuDao.createCallCustomer(condition);
                break;
            case "外拓表":
                result = xiaoLuDao.createExtension(condition);
                break;
            case "来电":
                result = xiaoLuDao.createIncomingCall(condition);
                break;
            case "来访":
                result = xiaoLuDao.createVisit(condition);
                break;
            case "成交":
                result = xiaoLuDao.createDeal(condition);
                break;
            default:
                result = xiaoLuDao.handleUnknown(condition);

        }
        return result;
    }

    @Override
    public ResultData fetchIntermediary(Map<String, Object> condition) {
        ResultData result = new ResultData();
        ResultData response = xiaoLuDao.queryIntermediary(condition);
        if (response.getResponseCode() == ResponseCode.RESPONSE_OK) {
            result.setResponseCode(ResponseCode.RESPONSE_OK);
            result.setData(response.getData());
        }
        if (response.getResponseCode() == ResponseCode.RESPONSE_NULL) {
            result.setResponseCode(ResponseCode.RESPONSE_NULL);
            result.setDescription("No intermediary record found");
        }
        if (response.getResponseCode() == ResponseCode.RESPONSE_ERROR) {
            result.setResponseCode(ResponseCode.RESPONSE_ERROR);
            result.setDescription("Fail to fetch intermediary from database");
        }
        return result;
    }

    @Override
    public ResultData searchIntermediary(Map<String, Object> condition) {
        ResultData result = new ResultData();
        ResultData response = xiaoLuDao.searchIntermediary(condition);
        if (response.getResponseCode() == ResponseCode.RESPONSE_OK) {
            result.setResponseCode(ResponseCode.RESPONSE_OK);
            result.setData(response.getData());
        }
        if (response.getResponseCode() == ResponseCode.RESPONSE_NULL) {
            result.setResponseCode(ResponseCode.RESPONSE_NULL);
            result.setDescription("No intermediary record found");
        }
        if (response.getResponseCode() == ResponseCode.RESPONSE_ERROR) {
            result.setResponseCode(ResponseCode.RESPONSE_ERROR);
            result.setDescription("Fail to fetch intermediary from database");
        }
        return result;
    }

    @Override
    public ResultData fetchCallCustomer(Map<String, Object> condition) {
        ResultData result = new ResultData();
        ResultData response = xiaoLuDao.queryCallCustomer(condition);
        if (response.getResponseCode() == ResponseCode.RESPONSE_OK) {
            result.setResponseCode(ResponseCode.RESPONSE_OK);
            result.setData(response.getData());
        }
        if (response.getResponseCode() == ResponseCode.RESPONSE_NULL) {
            result.setResponseCode(ResponseCode.RESPONSE_NULL);
            result.setDescription("No callcustomer record found");
        }
        if (response.getResponseCode() == ResponseCode.RESPONSE_ERROR) {
            result.setResponseCode(ResponseCode.RESPONSE_ERROR);
            result.setDescription("Fail to fetch callcustomer from database");
        }
        return result;
    }

    @Override
    public ResultData searchCallCustomer(Map<String, Object> condition) {
        ResultData result = new ResultData();
        ResultData response = xiaoLuDao.searchCallCustomer(condition);
        if (response.getResponseCode() == ResponseCode.RESPONSE_OK) {
            result.setResponseCode(ResponseCode.RESPONSE_OK);
            result.setData(response.getData());
        }
        if (response.getResponseCode() == ResponseCode.RESPONSE_NULL) {
            result.setResponseCode(ResponseCode.RESPONSE_NULL);
            result.setDescription("No callcustomer record found");
        }
        if (response.getResponseCode() == ResponseCode.RESPONSE_ERROR) {
            result.setResponseCode(ResponseCode.RESPONSE_ERROR);
            result.setDescription("Fail to fetch callcustomer from database");
        }
        return result;
    }

    @Override
    public ResultData fetchExtension(Map<String, Object> condition) {
        ResultData result = new ResultData();
        ResultData response = xiaoLuDao.queryExtension(condition);
        if (response.getResponseCode() == ResponseCode.RESPONSE_OK) {
            result.setResponseCode(ResponseCode.RESPONSE_OK);
            result.setData(response.getData());
        }
        if (response.getResponseCode() == ResponseCode.RESPONSE_NULL) {
            result.setResponseCode(ResponseCode.RESPONSE_NULL);
            result.setDescription("No extension record found");
        }
        if (response.getResponseCode() == ResponseCode.RESPONSE_ERROR) {
            result.setResponseCode(ResponseCode.RESPONSE_ERROR);
            result.setDescription("Fail to fetch extension from database");
        }
        return result;
    }

    @Override
    public ResultData searchExtension(Map<String, Object> condition) {
        ResultData result = new ResultData();
        ResultData response = xiaoLuDao.searchExtension(condition);
        if (response.getResponseCode() == ResponseCode.RESPONSE_OK) {
            result.setResponseCode(ResponseCode.RESPONSE_OK);
            result.setData(response.getData());
        }
        if (response.getResponseCode() == ResponseCode.RESPONSE_NULL) {
            result.setResponseCode(ResponseCode.RESPONSE_NULL);
            result.setDescription("No extension record found");
        }
        if (response.getResponseCode() == ResponseCode.RESPONSE_ERROR) {
            result.setResponseCode(ResponseCode.RESPONSE_ERROR);
            result.setDescription("Fail to fetch extension from database");
        }
        return result;
    }

    @Override
    public ResultData fetchIncomingCall(Map<String, Object> condition) {
        ResultData result = new ResultData();
        ResultData response = xiaoLuDao.queryIncomingCall(condition);
        if (response.getResponseCode() == ResponseCode.RESPONSE_OK) {
            result.setResponseCode(ResponseCode.RESPONSE_OK);
            result.setData(response.getData());
        }
        if (response.getResponseCode() == ResponseCode.RESPONSE_NULL) {
            result.setResponseCode(ResponseCode.RESPONSE_NULL);
            result.setDescription("No incomingcall record found");
        }
        if (response.getResponseCode() == ResponseCode.RESPONSE_ERROR) {
            result.setResponseCode(ResponseCode.RESPONSE_ERROR);
            result.setDescription("Fail to fetch incomingcall from database");
        }
        return result;
    }

    @Override
    public ResultData searchIncomingCall(Map<String, Object> condition) {
        ResultData result = new ResultData();
        ResultData response = xiaoLuDao.searchIncomingCall(condition);
        if (response.getResponseCode() == ResponseCode.RESPONSE_OK) {
            result.setResponseCode(ResponseCode.RESPONSE_OK);
            result.setData(response.getData());
        }
        if (response.getResponseCode() == ResponseCode.RESPONSE_NULL) {
            result.setResponseCode(ResponseCode.RESPONSE_NULL);
            result.setDescription("No incomingcall record found");
        }
        if (response.getResponseCode() == ResponseCode.RESPONSE_ERROR) {
            result.setResponseCode(ResponseCode.RESPONSE_ERROR);
            result.setDescription("Fail to fetch incomingcall from database");
        }
        return result;
    }

    @Override
    public ResultData fetchVisit(Map<String, Object> condition) {
        ResultData result = new ResultData();
        ResultData response = xiaoLuDao.queryVisit(condition);
        if (response.getResponseCode() == ResponseCode.RESPONSE_OK) {
            result.setResponseCode(ResponseCode.RESPONSE_OK);
            result.setData(response.getData());
        }
        if (response.getResponseCode() == ResponseCode.RESPONSE_NULL) {
            result.setResponseCode(ResponseCode.RESPONSE_NULL);
            result.setDescription("No visit record found");
        }
        if (response.getResponseCode() == ResponseCode.RESPONSE_ERROR) {
            result.setResponseCode(ResponseCode.RESPONSE_ERROR);
            result.setDescription("Fail to fetch visit from database");
        }
        return result;
    }

    @Override
    public ResultData searchVisit(Map<String, Object> condition) {
        ResultData result = new ResultData();
        ResultData response = xiaoLuDao.searchVisit(condition);
        if (response.getResponseCode() == ResponseCode.RESPONSE_OK) {
            result.setResponseCode(ResponseCode.RESPONSE_OK);
            result.setData(response.getData());
        }
        if (response.getResponseCode() == ResponseCode.RESPONSE_NULL) {
            result.setResponseCode(ResponseCode.RESPONSE_NULL);
            result.setDescription("No visit record found");
        }
        if (response.getResponseCode() == ResponseCode.RESPONSE_ERROR) {
            result.setResponseCode(ResponseCode.RESPONSE_ERROR);
            result.setDescription("Fail to fetch visit from database");
        }
        return result;
    }

    @Override
    public ResultData fetchDeal(Map<String, Object> condition) {
        ResultData result = new ResultData();
        ResultData response = xiaoLuDao.queryDeal(condition);
        if (response.getResponseCode() == ResponseCode.RESPONSE_OK) {
            result.setResponseCode(ResponseCode.RESPONSE_OK);
            result.setData(response.getData());
        }
        if (response.getResponseCode() == ResponseCode.RESPONSE_NULL) {
            result.setResponseCode(ResponseCode.RESPONSE_NULL);
            result.setDescription("No deal record found");
        }
        if (response.getResponseCode() == ResponseCode.RESPONSE_ERROR) {
            result.setResponseCode(ResponseCode.RESPONSE_ERROR);
            result.setDescription("Fail to fetch deal from database");
        }
        return result;
    }

    @Override
    public ResultData searchDeal(Map<String, Object> condition) {
        ResultData result = new ResultData();
        ResultData response = xiaoLuDao.searchDeal(condition);
        if (response.getResponseCode() == ResponseCode.RESPONSE_OK) {
            result.setResponseCode(ResponseCode.RESPONSE_OK);
            result.setData(response.getData());
        }
        if (response.getResponseCode() == ResponseCode.RESPONSE_NULL) {
            result.setResponseCode(ResponseCode.RESPONSE_NULL);
            result.setDescription("No visit deal found");
        }
        if (response.getResponseCode() == ResponseCode.RESPONSE_ERROR) {
            result.setResponseCode(ResponseCode.RESPONSE_ERROR);
            result.setDescription("Fail to fetch deal from database");
        }
        return result;
    }
}
