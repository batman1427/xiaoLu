package dao.impl;

import auxiliary.*;
import dao.BaseDao;
import dao.XiaoLuDao;
import model.*;
import org.apache.poi.hssf.usermodel.HSSFFormulaEvaluator;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class XiaoLuDaoImpl extends BaseDao implements XiaoLuDao{

    @Transactional
    @Override
    public ResultData createIntermediary(Map<String, Object> condition) {
        ResultData result = new ResultData();
        List<ErrorLog> errorLogList = new ArrayList<ErrorLog>();
        Sheet sheet = (Sheet) condition.get("sheet");
        for(int i=2;i<sheet.getPhysicalNumberOfRows();i++){
            System.out.println("正在处理表"+sheet.getSheetName()+"的第"+(i-1)+"条记录;");
            if(sheet.getRow(i) != null && sheet.getRow(i).getFirstCellNum()==0 && sheet.getRow(i).getCell(0).toString().trim().length() > 0){
                try{
                    Row row = sheet.getRow(i);
                    String reportTime = row.getCell(1).toString().trim();
                    String tempTel = row.getCell(5).toString().trim();
                    reportTime = TimeFilter.getTime(reportTime);
                    ArrayList<String> customerTel = TelFilter.getTel(tempTel);
                    String customerSource = row.getCell(2)==null ? "" : row.getCell(2).toString().trim();
                    String reportBuilding = row.getCell(3)==null ? "" : row.getCell(3).toString().trim();
                    String customerName = row.getCell(4)==null ? "" : row.getCell(4).toString().trim();
                    String intentionLevel = row.getCell(6)==null ? "" : row.getCell(6).toString().trim();
                    String visitTime = row.getCell(7)==null ? "" : row.getCell(7).toString().trim();
                    String visitBuilding = row.getCell(8)==null ? "" : row.getCell(8).toString().trim();
                    String customerSituation = row.getCell(9)==null ? "" : row.getCell(9).toString().trim();
                    String dealTime = row.getCell(10)==null ? "" : row.getCell(10).toString().trim();
                    String dealBuilding = row.getCell(11)==null ? "" : row.getCell(11).toString().trim();
                    String dealRoomnum = row.getCell(12)==null ? "" : row.getCell(12).toString().trim();
                    String remark = row.getCell(13)==null ? "" : row.getCell(13).toString().trim();
                    if(customerTel.size() == 0){
                        ErrorLog errorLog = new ErrorLog(sheet.getSheetName(), i-1, "客户电话为空或者无法识别");
                        errorLogList.add(errorLog);
                        continue;
                    }
                    for(int k=0;k<customerTel.size();k++){
                        condition.clear();
                        condition.put("blockFlag", false);
                        Intermediary intermediary = new Intermediary(reportTime, customerSource, reportBuilding, customerName, customerTel.get(k), intentionLevel, visitTime, visitBuilding, customerSituation, dealTime, dealBuilding, dealRoomnum, remark);
                        intermediary.setIntermediaryId(IDGenerator.generate("ITM"));
                        if(reportTime.equals("false")){
                            ErrorLog errorLog = new ErrorLog(sheet.getSheetName(), i-1, "报备时间为空或者无法识别");
                            errorLogList.add(errorLog);
                            continue;
                        }
                        condition.put("reportTime", reportTime);
                        condition.put("customerTel", customerTel.get(k));
                        try {
                            List<Intermediary> list = sqlSession.selectList("xiaolu.intermediary.query", condition);
                            if (list.isEmpty()) {
                                try {
                                    sqlSession.insert("xiaolu.intermediary.insert", intermediary);
                                } catch (Exception e) {
                                    ErrorLog errorLog = new ErrorLog(sheet.getSheetName(), i-1, "数据库插入出错："+e.getMessage());
                                    errorLogList.add(errorLog);
                                    continue;
                                }
                            }else{
                                try {
                                    condition.remove("blockFlag");
                                    condition.put("blockFlag", true);
                                    sqlSession.update("xiaolu.intermediary.update", condition);
                                } catch (Exception e) {
                                    ErrorLog errorLog = new ErrorLog(sheet.getSheetName(), i-1, "数据库更新出错："+e.getMessage());
                                    errorLogList.add(errorLog);
                                    continue;
                                }
                                try {
                                    sqlSession.insert("xiaolu.intermediary.insert", intermediary);
                                } catch (Exception e) {
                                    ErrorLog errorLog = new ErrorLog(sheet.getSheetName(), i-1, "数据库插入出错："+e.getMessage());
                                    errorLogList.add(errorLog);
                                    continue;
                                }
                            }
                        } catch (Exception e) {
                            ErrorLog errorLog = new ErrorLog(sheet.getSheetName(), i-1, "数据库查询出错："+e.getMessage());
                            errorLogList.add(errorLog);
                            continue;
                        }
                    }
                }catch(Exception e){
                    ErrorLog errorLog = new ErrorLog(sheet.getSheetName(), i-1, "存在非法单元格："+e.getMessage());
                    errorLogList.add(errorLog);
                    continue;
                }
            }else{
                break;
            }
        }
        result.setData(errorLogList);
        return result;
    }

    @Transactional
    @Override
    public ResultData createCallCustomer(Map<String, Object> condition) {
        ResultData result = new ResultData();
        List<ErrorLog> errorLogList = new ArrayList<ErrorLog>();
        Sheet sheet = (Sheet) condition.get("sheet");
        for(int i=2;i<sheet.getPhysicalNumberOfRows();i++){
            System.out.println("正在处理表"+sheet.getSheetName()+"的第"+(i-1)+"条记录;");
            if(sheet.getRow(i) != null && sheet.getRow(i).getFirstCellNum()==0 && sheet.getRow(i).getCell(0).toString().trim().length() > 0){
                try{
                    Row row = sheet.getRow(i);
                    String callTime = row.getCell(6).toString().trim();
                    String tempTel = row.getCell(5).toString().trim();
                    callTime = TimeFilter.getTime(callTime);
                    ArrayList<String> customerTel = TelFilter.getTel(tempTel);
                    String datasourceArea = row.getCell(1)==null ? "" : row.getCell(1).toString().trim();
                    String datasourceBuilding = row.getCell(2)==null ? "" : row.getCell(2).toString().trim();
                    String datasourceType = row.getCell(3)==null ? "" : row.getCell(3).toString().trim();
                    String customerName = row.getCell(4)==null ? "" : row.getCell(4).toString().trim();
                    String callSalesman = row.getCell(7)==null ? "" : row.getCell(7).toString().trim();
                    String feedback = row.getCell(8)==null ? "" : row.getCell(8).toString().trim();
                    String intentionLevel = row.getCell(9)==null ? "" : row.getCell(9).toString().trim();
                    String intentionBuilding = row.getCell(10)==null ? "" : row.getCell(10).toString().trim();
                    String visitTime = row.getCell(11)==null ? "" : row.getCell(11).toString().trim();
                    String visitBuilding = row.getCell(12)==null ? "" : row.getCell(12).toString().trim();
                    String customerSituation = row.getCell(13)==null ? "" : row.getCell(13).toString().trim();
                    String dealTime = row.getCell(14)==null ? "" : row.getCell(14).toString().trim();
                    String dealBuilding = row.getCell(15)==null ? "" : row.getCell(15).toString().trim();
                    String dealRoomnum = row.getCell(16)==null ? "" : row.getCell(16).toString().trim();
                    String remark = row.getCell(17)==null ? "" : row.getCell(17).toString().trim();
                    if(customerTel.size() == 0){
                        ErrorLog errorLog = new ErrorLog(sheet.getSheetName(), i-1, "客户电话为空或者无法识别");
                        errorLogList.add(errorLog);
                        continue;
                    }
                    for(int k=0;k<customerTel.size();k++){
                        condition.clear();
                        condition.put("blockFlag", false);
                        CallCustomer callCustomer = new CallCustomer(datasourceArea, datasourceBuilding, datasourceType, customerName, customerTel.get(k), callTime, callSalesman, feedback, intentionLevel, intentionBuilding, visitTime, visitBuilding, customerSituation, dealTime, dealBuilding, dealRoomnum, remark);
                        callCustomer.setCallCustomerId(IDGenerator.generate("CCT"));
                        if(callTime.equals("false")){
                            ErrorLog errorLog = new ErrorLog(sheet.getSheetName(), i-1, "CALL客日期为空或者无法识别");
                            errorLogList.add(errorLog);
                            continue;
                        }
                        condition.put("callTime", callTime);
                        condition.put("customerTel", customerTel.get(k));
                        try {
                            List<CallCustomer> list = sqlSession.selectList("xiaolu.callcustomer.query", condition);
                            if (list.isEmpty()) {
                                try {
                                    sqlSession.insert("xiaolu.callcustomer.insert", callCustomer);
                                } catch (Exception e) {
                                    ErrorLog errorLog = new ErrorLog(sheet.getSheetName(), i-1, "数据库插入出错："+e.getMessage());
                                    errorLogList.add(errorLog);
                                    continue;
                                }
                            }else{
                                try {
                                    condition.remove("blockFlag");
                                    condition.put("blockFlag", true);
                                    sqlSession.update("xiaolu.callcustomer.update", condition);
                                } catch (Exception e) {
                                    ErrorLog errorLog = new ErrorLog(sheet.getSheetName(), i-1, "数据库更新出错："+e.getMessage());
                                    errorLogList.add(errorLog);
                                    continue;
                                }
                                try {
                                    sqlSession.insert("xiaolu.callcustomer.insert", callCustomer);
                                } catch (Exception e) {
                                    ErrorLog errorLog = new ErrorLog(sheet.getSheetName(), i-1, "数据库插入出错："+e.getMessage());
                                    errorLogList.add(errorLog);
                                    continue;
                                }
                            }
                        } catch (Exception e) {
                            ErrorLog errorLog = new ErrorLog(sheet.getSheetName(), i-1, "数据库查询出错："+e.getMessage());
                            errorLogList.add(errorLog);
                            continue;
                        }
                    }
                }catch(Exception e){
                    ErrorLog errorLog = new ErrorLog(sheet.getSheetName(), i-1, "存在非法单元格："+e.getMessage());
                    errorLogList.add(errorLog);
                    continue;
                }
            }else{
                break;
            }
        }
        result.setData(errorLogList);
        return result;
    }

    @Transactional
    @Override
    public ResultData createExtension(Map<String, Object> condition) {
        ResultData result = new ResultData();
        List<ErrorLog> errorLogList = new ArrayList<ErrorLog>();
        Sheet sheet = (Sheet) condition.get("sheet");
        for(int i=2;i<sheet.getPhysicalNumberOfRows();i++){
            System.out.println("正在处理表"+sheet.getSheetName()+"的第"+(i-1)+"条记录;");
            if(sheet.getRow(i) != null && sheet.getRow(i).getFirstCellNum()==0 && sheet.getRow(i).getCell(0).toString().trim().length() > 0){
                try{
                    Row row = sheet.getRow(i);
                    String extensionTime = row.getCell(1).toString().trim();
                    String tempTel = row.getCell(4).toString().trim();
                    extensionTime = TimeFilter.getTime(extensionTime);
                    ArrayList<String> customerTel = TelFilter.getTel(tempTel);
                    String extensionLocation = row.getCell(2)==null ? "" : row.getCell(2).toString().trim();
                    String customerName = row.getCell(3)==null ? "" : row.getCell(3).toString().trim();
                    String realtyConsultant = row.getCell(5)==null ? "" : row.getCell(5).toString().trim();
                    String visitTime = row.getCell(6)==null ? "" : row.getCell(6).toString().trim();
                    String customerSituation = row.getCell(7)==null ? "" : row.getCell(7).toString().trim();
                    String dealTime = row.getCell(8)==null ? "" : row.getCell(8).toString().trim();
                    String dealBuilding = row.getCell(9)==null ? "" : row.getCell(9).toString().trim();
                    String dealRoomnum = row.getCell(10)==null ? "" : row.getCell(10).toString().trim();
                    String remark = row.getCell(11)==null ? "" : row.getCell(11).toString().trim();
                    if(customerTel.size() == 0){
                        ErrorLog errorLog = new ErrorLog(sheet.getSheetName(), i-1, "客户电话为空或者无法识别");
                        errorLogList.add(errorLog);
                        continue;
                    }
                    for(int k=0;k<customerTel.size();k++){
                        condition.clear();
                        condition.put("blockFlag", false);
                        Extension extension = new Extension(extensionTime, extensionLocation, customerName, customerTel.get(k), realtyConsultant, visitTime, customerSituation, dealTime, dealBuilding, dealRoomnum, remark);
                        extension.setExtensionId(IDGenerator.generate("EXT"));
                        if(extensionTime.equals("false")){
                            ErrorLog errorLog = new ErrorLog(sheet.getSheetName(), i-1, "外拓时间为空或者无法识别");
                            errorLogList.add(errorLog);
                            continue;
                        }
                        condition.put("extensionTime", extensionTime);
                        condition.put("customerTel", customerTel.get(k));
                        try {
                            List<Extension> list = sqlSession.selectList("xiaolu.extension.query", condition);
                            if (list.isEmpty()) {
                                try {
                                    sqlSession.insert("xiaolu.extension.insert", extension);
                                } catch (Exception e) {
                                    ErrorLog errorLog = new ErrorLog(sheet.getSheetName(), i-1, "数据库插入出错："+e.getMessage());
                                    errorLogList.add(errorLog);
                                    continue;
                                }
                            }else{
                                try {
                                    condition.remove("blockFlag");
                                    condition.put("blockFlag", true);
                                    sqlSession.update("xiaolu.extension.update", condition);
                                } catch (Exception e) {
                                    ErrorLog errorLog = new ErrorLog(sheet.getSheetName(), i-1, "数据库更新出错："+e.getMessage());
                                    errorLogList.add(errorLog);
                                    continue;
                                }
                                try {
                                    sqlSession.insert("xiaolu.extension.insert", extension);
                                } catch (Exception e) {
                                    ErrorLog errorLog = new ErrorLog(sheet.getSheetName(), i-1, "数据库插入出错："+e.getMessage());
                                    errorLogList.add(errorLog);
                                    continue;
                                }
                            }
                        } catch (Exception e) {
                            ErrorLog errorLog = new ErrorLog(sheet.getSheetName(), i-1, "数据库查询出错："+e.getMessage());
                            errorLogList.add(errorLog);
                            continue;
                        }
                    }
                }catch(Exception e){
                    ErrorLog errorLog = new ErrorLog(sheet.getSheetName(), i-1, "存在非法单元格："+e.getMessage());
                    errorLogList.add(errorLog);
                    continue;
                }
            }else{
                break;
            }
        }
        result.setData(errorLogList);
        return result;
    }

    @Transactional
    @Override
    public ResultData createIncomingCall(Map<String, Object> condition) {
        ResultData result = new ResultData();
        List<ErrorLog> errorLogList = new ArrayList<ErrorLog>();
        Sheet sheet = (Sheet) condition.get("sheet");
        for(int i=2;i<sheet.getPhysicalNumberOfRows();i++){
            System.out.println("正在处理表"+sheet.getSheetName()+"的第"+(i-1)+"条记录;");
            if(sheet.getRow(i) != null && sheet.getRow(i).getFirstCellNum()==0 && sheet.getRow(i).getCell(0).toString().trim().length() > 0){
                try{
                    Row row = sheet.getRow(i);
                    String callTime = row.getCell(1).toString().trim();
                    String tempTel = row.getCell(3).toString().trim();
                    callTime = TimeFilter.getTime(callTime);
                    ArrayList<String> customerTel = TelFilter.getTel(tempTel);
                    String customerName = row.getCell(2)==null ? "" : row.getCell(2).toString().trim();
                    String realtyPurpose = row.getCell(4)==null ? "" : row.getCell(4).toString().trim();
                    String demandArea = row.getCell(5)==null ? "" : row.getCell(5).toString().trim();
                    String houseType = row.getCell(6)==null ? "" : row.getCell(6).toString().trim();
                    String residentialZone = row.getCell(7)==null ? "" : row.getCell(7).toString().trim();
                    String acceptPrice = row.getCell(8)==null ? "" : row.getCell(8).toString().trim();
                    String accessKnown = row.getCell(9)==null ? "" : row.getCell(9).toString().trim();
                    String consultContent = row.getCell(10)==null ? "" : row.getCell(10).toString().trim();
                    String visitTime = row.getCell(11)==null ? "" : row.getCell(11).toString().trim();
                    String customerSituation = row.getCell(12)==null ? "" : row.getCell(12).toString().trim();
                    String dealTime = row.getCell(13)==null ? "" : row.getCell(13).toString().trim();
                    String dealBuilding = row.getCell(14)==null ? "" : row.getCell(14).toString().trim();
                    String dealRoomnum = row.getCell(15)==null ? "" : row.getCell(15).toString().trim();
                    String salesman = row.getCell(16)==null ? "" : row.getCell(16).toString().trim();
                    if(customerTel.size() == 0){
                        ErrorLog errorLog = new ErrorLog(sheet.getSheetName(), i-1, "客户电话为空或者无法识别");
                        errorLogList.add(errorLog);
                        continue;
                    }
                    for(int k=0;k<customerTel.size();k++){
                        condition.clear();
                        condition.put("blockFlag", false);
                        IncomingCall incomingCall = new IncomingCall(callTime, customerName, customerTel.get(k), realtyPurpose, demandArea, houseType, residentialZone, acceptPrice, accessKnown, consultContent, visitTime, customerSituation, dealTime, dealBuilding, dealRoomnum, salesman);
                        incomingCall.setIncomingCallId(IDGenerator.generate("ICC"));
                        if(callTime.equals("false")){
                            ErrorLog errorLog = new ErrorLog(sheet.getSheetName(), i-1, "来电时间为空或者无法识别");
                            errorLogList.add(errorLog);
                            continue;
                        }
                        condition.put("callTime", callTime);
                        condition.put("customerTel", customerTel.get(k));
                        try {
                            List<IncomingCall> list = sqlSession.selectList("xiaolu.incomingcall.query", condition);
                            if (list.isEmpty()) {
                                try {
                                    sqlSession.insert("xiaolu.incomingcall.insert", incomingCall);
                                } catch (Exception e) {
                                    ErrorLog errorLog = new ErrorLog(sheet.getSheetName(), i-1, "数据库插入出错："+e.getMessage());
                                    errorLogList.add(errorLog);
                                    continue;
                                }
                            }else{
                                try {
                                    condition.remove("blockFlag");
                                    condition.put("blockFlag", true);
                                    sqlSession.update("xiaolu.incomingcall.update", condition);
                                } catch (Exception e) {
                                    ErrorLog errorLog = new ErrorLog(sheet.getSheetName(), i-1, "数据库更新出错："+e.getMessage());
                                    errorLogList.add(errorLog);
                                    continue;
                                }
                                try {
                                    sqlSession.insert("xiaolu.incomingcall.insert", incomingCall);
                                } catch (Exception e) {
                                    ErrorLog errorLog = new ErrorLog(sheet.getSheetName(), i-1, "数据库插入出错："+e.getMessage());
                                    errorLogList.add(errorLog);
                                    continue;
                                }
                            }
                        } catch (Exception e) {
                            ErrorLog errorLog = new ErrorLog(sheet.getSheetName(), i-1, "数据库查询出错："+e.getMessage());
                            errorLogList.add(errorLog);
                            continue;
                        }
                    }
                }catch(Exception e){
                    ErrorLog errorLog = new ErrorLog(sheet.getSheetName(), i-1, "存在非法单元格："+e.getMessage());
                    errorLogList.add(errorLog);
                    continue;
                }
            }else{
                break;
            }
        }
        result.setData(errorLogList);
        return result;
    }

    @Transactional
    @Override
    public ResultData createVisit(Map<String, Object> condition) {
        ResultData result = new ResultData();
        List<ErrorLog> errorLogList = new ArrayList<ErrorLog>();
        Sheet sheet = (Sheet) condition.get("sheet");
        FormulaEvaluator formulaEvaluator = null;
        Workbook workbook = (Workbook) condition.get("workbook");
        MultipartFile file = (MultipartFile) condition.get("file");
        if(file.getOriginalFilename().endsWith("xlsx")){
            formulaEvaluator = new XSSFFormulaEvaluator((XSSFWorkbook) workbook);
        }else{
            formulaEvaluator = new HSSFFormulaEvaluator((HSSFWorkbook) workbook);
        }
        for(int i=1;i<sheet.getPhysicalNumberOfRows();i++){
            System.out.println("正在处理表"+sheet.getSheetName()+"的第"+i+"条记录;");
            if(sheet.getRow(i) != null && sheet.getRow(i).getFirstCellNum()==0 && sheet.getRow(i).getCell(0).toString().trim().length() > 0){
                try{
                    Row row = sheet.getRow(i);
                    String visitTime = row.getCell(0).toString().trim();
                    String tempTel = row.getCell(2).toString().trim();
                    visitTime = TimeFilter.getTime(visitTime);
                    ArrayList<String> customerTel = TelFilter.getTel(tempTel);
                    String customerName = row.getCell(1)==null ? "" : row.getCell(1).toString().trim();
                    String visitedTimes = row.getCell(3)==null ? "" : row.getCell(3).toString().trim();
                    String intentionalArea = row.getCell(4)==null ? "" : row.getCell(4).toString().trim();
                    String acceptPrice = "";
                    if(row.getCell(5)!=null && row.getCell(5).getCellType() == Cell.CELL_TYPE_FORMULA){
                        acceptPrice = getCellValueFormula(row.getCell(5), formulaEvaluator);
                    }else {
                        acceptPrice = row.getCell(5) == null ? "" : row.getCell(5).toString().trim();
                    }
                    String realtyTimes = row.getCell(6)==null ? "" : row.getCell(6).toString().trim();
                    String age = row.getCell(7)==null ? "" : row.getCell(7).toString().trim();
                    String residentialZone = row.getCell(8)==null ? "" : row.getCell(8).toString().trim();
                    String workZone = row.getCell(9)==null ? "" : row.getCell(9).toString().trim();
                    String occupation = row.getCell(10)==null ? "" : row.getCell(10).toString().trim();
                    String accessKnown = row.getCell(11)==null ? "" : row.getCell(11).toString().trim();
                    String realtyPurpose = row.getCell(12)==null ? "" : row.getCell(12).toString().trim();
                    String realtyType = row.getCell(13)==null ? "" : row.getCell(13).toString().trim();
                    String concerns = row.getCell(14)==null ? "" : row.getCell(14).toString().trim();
                    String customerDescription = row.getCell(15)==null ? "" : row.getCell(15).toString().trim();
                    String latestState = row.getCell(16)==null ? "" : row.getCell(16).toString().trim();
                    String customerType = row.getCell(17)==null ? "" : row.getCell(17).toString().trim();
                    String realtyConsultant = row.getCell(18)==null ? "" : row.getCell(18).toString().trim();
                    String dealTime = row.getCell(19)==null ? "" : row.getCell(19).toString().trim();
                    String dealRoomnum = row.getCell(20)==null ? "" : row.getCell(20).toString().trim();
                    if(customerTel.size() == 0){
                        ErrorLog errorLog = new ErrorLog(sheet.getSheetName(), i, "客户电话为空或者无法识别");
                        errorLogList.add(errorLog);
                        continue;
                    }
                    for(int k=0;k<customerTel.size();k++){
                        condition.clear();
                        condition.put("blockFlag", false);
                        Visit visit = new Visit(visitTime, customerName, customerTel.get(k), visitedTimes, intentionalArea, acceptPrice, realtyTimes, age, residentialZone, workZone, occupation, accessKnown, realtyPurpose, realtyType, concerns, customerDescription, latestState, customerType, realtyConsultant, dealTime, dealRoomnum);
                        visit.setVisitId(IDGenerator.generate("VIT"));
                        if(visitTime.equals("false")){
                            ErrorLog errorLog = new ErrorLog(sheet.getSheetName(), i, "来访时间为空或者无法识别");
                            errorLogList.add(errorLog);
                            continue;
                        }
                        condition.put("visitTime", visitTime);
                        condition.put("customerTel", customerTel.get(k));
                        try {
                            List<Visit> list = sqlSession.selectList("xiaolu.visit.query", condition);
                            if (list.isEmpty()) {
                                try {
                                    sqlSession.insert("xiaolu.visit.insert", visit);
                                } catch (Exception e) {
                                    ErrorLog errorLog = new ErrorLog(sheet.getSheetName(), i, "数据库插入出错："+e.getMessage());
                                    errorLogList.add(errorLog);
                                    continue;
                                }
                            }else{
                                try {
                                    condition.remove("blockFlag");
                                    condition.put("blockFlag", true);
                                    sqlSession.update("xiaolu.visit.update", condition);
                                } catch (Exception e) {
                                    ErrorLog errorLog = new ErrorLog(sheet.getSheetName(), i, "数据库更新出错："+e.getMessage());
                                    errorLogList.add(errorLog);
                                    continue;
                                }
                                try {
                                    sqlSession.insert("xiaolu.visit.insert", visit);
                                } catch (Exception e) {
                                    ErrorLog errorLog = new ErrorLog(sheet.getSheetName(), i, "数据库插入出错："+e.getMessage());
                                    errorLogList.add(errorLog);
                                    continue;
                                }
                            }
                        } catch (Exception e) {
                            ErrorLog errorLog = new ErrorLog(sheet.getSheetName(), i, "数据库查询出错："+e.getMessage());
                            errorLogList.add(errorLog);
                            continue;
                        }
                    }
                }catch(Exception e){
                    ErrorLog errorLog = new ErrorLog(sheet.getSheetName(), i, "存在非法单元格："+e.getMessage());
                    errorLogList.add(errorLog);
                    continue;
                }
            }else{
                break;
            }
        }
        result.setData(errorLogList);
        return result;
    }

    public static String getCellValueFormula(Cell cell, FormulaEvaluator formulaEvaluator) {
        return String.valueOf(formulaEvaluator.evaluate(cell).getNumberValue());
    }


    @Override
    public ResultData handleUnknown(Map<String, Object> condition) {
        ResultData result = new ResultData();
        List<ErrorLog> errorLogList = new ArrayList<ErrorLog>();
        Sheet sheet = (Sheet) condition.get("sheet");
        ErrorLog errorLog = new ErrorLog(sheet.getSheetName(), -1, "不能识别的表格类型");
        errorLogList.add(errorLog);
        result.setData(errorLogList);
        return result;
    }

}
