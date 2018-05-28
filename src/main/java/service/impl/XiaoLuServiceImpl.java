package service.impl;

import auxiliary.ErrorLog;
import auxiliary.ResponseCode;
import auxiliary.ResultData;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import service.XiaoLuService;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class XiaoLuServiceImpl implements XiaoLuService {

    @Override
    public ResultData upload(Map<String, Object> condition) {
        ResultData result = new ResultData();
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd-hhmmss");
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
        condition.put("logPath", this.getClass().getClassLoader().getResource("").getPath()+"records/"+time+"/");
        try {
            Workbook workbook = WorkbookFactory.create(new File(path));
            int countSheet = workbook.getNumberOfSheets();
            System.out.println(countSheet);
            for(int i=0;i<countSheet;i++){
                Sheet sheet = workbook.getSheetAt(i);
                ResultData response = this.save(condition, sheet);
                if(response.getResponseCode() == ResponseCode.RESPONSE_ERROR){
                    return response;
                }else{
                    List<ErrorLog> tempErrorLogs = (List<ErrorLog>)response.getData();
                    List<ErrorLog> errorLogs = (List<ErrorLog>)result.getData();
                    errorLogs.addAll(tempErrorLogs);
                    result.setData(errorLogs);
                }
            }
        } catch (IOException e) {
            result.setResponseCode(ResponseCode.RESPONSE_ERROR);
            result.setDescription(e.getMessage());
        } catch (InvalidFormatException e) {
            result.setResponseCode(ResponseCode.RESPONSE_ERROR);
            result.setDescription(e.getMessage());
        }
        return result;
    }

    public ResultData save(Map<String, Object> condition, Sheet sheet){
        ResultData result = new ResultData();
        String sheetType = sheet.getSheetName();
        switch(sheetType){
            case "中介带访":
                break;
            case "CALL客表":
                break;
            case "外拓表":
                break;
            case "来电":
                break;
            case "来访":
                break;
            default:



        }
        return result;
    }
}
