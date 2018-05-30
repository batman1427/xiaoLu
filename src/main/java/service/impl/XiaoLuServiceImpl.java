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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

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

        //condition.put("logPath", this.getClass().getClassLoader().getResource("").getPath()+"records/"+time+"/");
        try {
            Workbook workbook = WorkbookFactory.create(new File(path));
            int countSheet = workbook.getNumberOfSheets();
            List<ErrorLog> errorLogList = new ArrayList<ErrorLog>();
            for(int i=0;i<countSheet;i++){
                Sheet sheet = workbook.getSheetAt(i);
                ResultData response = this.save(condition, sheet);
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

    public ResultData save(Map<String, Object> condition, Sheet sheet){
        ResultData result = new ResultData();
        condition.put("sheet", sheet);
        String sheetName = sheet.getSheetName();
        switch(sheetName){
            case "中介带访":
                //result = xiaoLuDao.createIntermediary(condition);
                break;
            case "CALL客表":
                //result = xiaoLuDao.createCallCustomer(condition);
                break;
            case "外拓表":
                //result = xiaoLuDao.createExtension(condition);
                break;
            case "来电":
                result = xiaoLuDao.createIncomingCall(condition);
                break;
            case "来访":
                //result = xiaoLuDao.createVisit(condition);
                break;
            default:
                //result = xiaoLuDao.handleUnknown(condition);

        }
        return result;
    }
}
