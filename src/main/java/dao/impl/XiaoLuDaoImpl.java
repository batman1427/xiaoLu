package dao.impl;

import auxiliary.*;
import dao.BaseDao;
import dao.XiaoLuDao;
import model.*;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFFormulaEvaluator;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.*;

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
                        Intermediary intermediary = new Intermediary(Integer.valueOf(reportTime), customerSource, reportBuilding, customerName, customerTel.get(k), intentionLevel, visitTime, visitBuilding, customerSituation, dealTime, dealBuilding, dealRoomnum, remark);
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
                                    this.createTel(intermediary.getCustomerName(), intermediary.getCustomerTel());
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
                                    this.createTel(intermediary.getCustomerName(), intermediary.getCustomerTel());
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
                        CallCustomer callCustomer = new CallCustomer(datasourceArea, datasourceBuilding, datasourceType, customerName, customerTel.get(k), Integer.valueOf(callTime), callSalesman, feedback, intentionLevel, intentionBuilding, visitTime, visitBuilding, customerSituation, dealTime, dealBuilding, dealRoomnum, remark);
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
                                    this.createTel(callCustomer.getCustomerName(), callCustomer.getCustomerTel());
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
                                    this.createTel(callCustomer.getCustomerName(), callCustomer.getCustomerTel());
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
                        Extension extension = new Extension(Integer.valueOf(extensionTime), extensionLocation, customerName, customerTel.get(k), realtyConsultant, visitTime, customerSituation, dealTime, dealBuilding, dealRoomnum, remark);
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
                                    this.createTel(extension.getCustomerName(), extension.getCustomerTel());
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
                                    this.createTel(extension.getCustomerName(), extension.getCustomerTel());
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
                        IncomingCall incomingCall = new IncomingCall(Integer.valueOf(callTime), customerName, customerTel.get(k), realtyPurpose, demandArea, houseType, residentialZone, acceptPrice, accessKnown, consultContent, visitTime, customerSituation, dealTime, dealBuilding, dealRoomnum, salesman);
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
                                    this.createTel(incomingCall.getCustomerName(), incomingCall.getCustomerTel());
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
                                    this.createTel(incomingCall.getCustomerName(), incomingCall.getCustomerTel());
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
                    String acceptPrice = getCellValueFormula(row.getCell(5), formulaEvaluator, null);
                    String realtyTimes = row.getCell(6)==null ? "" : row.getCell(6).toString().trim();
                    String age = row.getCell(7)==null ? "" : row.getCell(7).toString().trim();
                    String residentialZone = row.getCell(8)==null ? "" : row.getCell(8).toString().trim();
                    String workZone = getCellValueFormula(row.getCell(9), formulaEvaluator, null);
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
                        Visit visit = new Visit(Integer.valueOf(visitTime), customerName, customerTel.get(k), visitedTimes, intentionalArea, acceptPrice, realtyTimes, age, residentialZone, workZone, occupation, accessKnown, realtyPurpose, realtyType, concerns, customerDescription, latestState, customerType, realtyConsultant, dealTime, dealRoomnum);
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
                                    this.createTel(visit.getCustomerName(), visit.getCustomerTel());
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
                                    this.createTel(visit.getCustomerName(), visit.getCustomerTel());
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

    public static String getCellValueFormula(Cell cell, FormulaEvaluator formulaEvaluator, String end) {
        String result = "";
        if(end == null){
            if(cell!=null && cell.getCellType() == Cell.CELL_TYPE_FORMULA){
                if(formulaEvaluator.evaluate(cell).getCellType() == Cell.CELL_TYPE_NUMERIC){
                    result = String.valueOf(formulaEvaluator.evaluate(cell).getNumberValue());
                }else {
                    result = String.valueOf(formulaEvaluator.evaluate(cell).getStringValue());
                }
            }else{
                result = cell == null ? "" : cell.toString().trim();
            }
        }else if(end.equals("xlsx")){
            if(cell!=null && cell.getCellType() == Cell.CELL_TYPE_FORMULA){
                if(formulaEvaluator.evaluate(cell).getCellType() == Cell.CELL_TYPE_NUMERIC){
                    if(HSSFDateUtil.isCellDateFormatted(cell)){
                        Date date = cell.getDateCellValue();
                        SimpleDateFormat format = new SimpleDateFormat("yyyy"+"/"+"MM"+"/"+"dd");
                        result = format.format(date);
                    }else {
                        result = String.valueOf(formulaEvaluator.evaluate(cell).getNumberValue());
                    }
                }else {
                    if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC && HSSFDateUtil.isCellDateFormatted(cell)){
                        Date date = cell.getDateCellValue();
                        SimpleDateFormat format = new SimpleDateFormat("yyyy"+"/"+"MM"+"/"+"dd");
                        result = format.format(date);
                    }else {
                        result = String.valueOf(formulaEvaluator.evaluate(cell).getStringValue());
                    }
                }
            }else{
                if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC && HSSFDateUtil.isCellDateFormatted(cell)){
                    Date date = cell.getDateCellValue();
                    SimpleDateFormat format = new SimpleDateFormat("yyyy"+"/"+"MM"+"/"+"dd");
                    result = format.format(date);
                }else {
                    result = cell == null ? "" : cell.toString().trim();
                }
            }
        }else if(end.equals("xls")){
            if(cell!=null && cell.getCellType() == Cell.CELL_TYPE_FORMULA){
                if(formulaEvaluator.evaluate(cell).getCellType() == Cell.CELL_TYPE_NUMERIC){
                    if(org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(cell)){
                        Date date = cell.getDateCellValue();
                        SimpleDateFormat format = new SimpleDateFormat("yyyy"+"/"+"MM"+"/"+"dd");
                        result = format.format(date);
                    }else {
                        result = String.valueOf(formulaEvaluator.evaluate(cell).getNumberValue());
                    }
                }else {
                    if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC && org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(cell)){
                        Date date = cell.getDateCellValue();
                        SimpleDateFormat format = new SimpleDateFormat("yyyy"+"/"+"MM"+"/"+"dd");
                        result = format.format(date);
                    }else {
                        result = String.valueOf(formulaEvaluator.evaluate(cell).getStringValue());
                    }
                }
            }else{
                /**
                 * can not handle "付款日期3"
                 */
                if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC && org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(cell)){
                    Date date = cell.getDateCellValue();
                    SimpleDateFormat format = new SimpleDateFormat("yyyy"+"/"+"MM"+"/"+"dd");
                    result = format.format(date);
                }else {
                    result = cell == null ? "" : cell.toString().trim();
                }
            }
        }
        return result;
    }

    @Transactional
    @Override
    public ResultData createDeal(Map<String, Object> condition) {
        ResultData result = new ResultData();
        List<ErrorLog> errorLogList = new ArrayList<ErrorLog>();
        Sheet sheet = (Sheet) condition.get("sheet");
        FormulaEvaluator formulaEvaluator = null;
        Workbook workbook = (Workbook) condition.get("workbook");
        MultipartFile file = (MultipartFile) condition.get("file");
        String end = "";
        if(file.getOriginalFilename().endsWith("xlsx")){
            formulaEvaluator = new XSSFFormulaEvaluator((XSSFWorkbook) workbook);
            end = "xlsx";
        }else{
            formulaEvaluator = new HSSFFormulaEvaluator((HSSFWorkbook) workbook);
            end = "xls";
        }
        for(int i=1;i<sheet.getPhysicalNumberOfRows();i++){
            System.out.println("正在处理表"+sheet.getSheetName()+"的第"+i+"条记录;");
            if(sheet.getRow(i) != null && sheet.getRow(i).getFirstCellNum()==0 && sheet.getRow(i).getCell(0).toString().trim().length() > 0){
                try{
                    Row row = sheet.getRow(i);
                    String subscriptionTime = row.getCell(1).toString().trim();
                    String tempTel = row.getCell(10).toString().trim();
                    subscriptionTime = TimeFilter.getTime(subscriptionTime);
                    ArrayList<String> customerTel = TelFilter.getTel(tempTel);
                    String recognitionTime = getCellValueFormula(row.getCell(2), formulaEvaluator, end);
                    String propertyType = getCellValueFormula(row.getCell(3), formulaEvaluator, end);
                    String dealSection = getCellValueFormula(row.getCell(4), formulaEvaluator, end);
                    String decoration = getCellValueFormula(row.getCell(5), formulaEvaluator, end);
                    String buildingId = getCellValueFormula(row.getCell(6), formulaEvaluator, end);
                    String roomNum = getCellValueFormula(row.getCell(7), formulaEvaluator, end);
                    String customerName = getCellValueFormula(row.getCell(8), formulaEvaluator, end);
                    String wechatId = getCellValueFormula(row.getCell(9), formulaEvaluator, end);
                    String predictedArea = getCellValueFormula(row.getCell(11), formulaEvaluator, end);
                    String subscriptionUnitPrice = getCellValueFormula(row.getCell(12), formulaEvaluator, end);
                    String subscriptionTotalPrice = getCellValueFormula(row.getCell(13), formulaEvaluator, end);
                    String discountDetail = getCellValueFormula(row.getCell(14), formulaEvaluator, end);
                    String fiveToFifteen = getCellValueFormula(row.getCell(15), formulaEvaluator, end);
                    String fifteenAfterDiscount = getCellValueFormula(row.getCell(16), formulaEvaluator, end);
                    String openingQuotationDiscount = getCellValueFormula(row.getCell(17), formulaEvaluator, end);
                    String discountOfContractOntime = getCellValueFormula(row.getCell(18), formulaEvaluator, end);
                    String actualDealUnitPrice = getCellValueFormula(row.getCell(19), formulaEvaluator, end);
                    String dealTotalPriceInput = getCellValueFormula(row.getCell(20), formulaEvaluator, end);
                    String dealTotalPriceCheck = getCellValueFormula(row.getCell(21), formulaEvaluator, end);
                    String amountOfPaymentFirst = getCellValueFormula(row.getCell(22), formulaEvaluator, end);
                    String dateOfPaymentFirst = getCellValueFormula(row.getCell(23), formulaEvaluator, end);
                    String amountOfPaymentSecond = getCellValueFormula(row.getCell(24), formulaEvaluator, end);
                    String dateOfPaymentSecond = getCellValueFormula(row.getCell(25), formulaEvaluator, end);
                    String amountOfPaymentThird = getCellValueFormula(row.getCell(26), formulaEvaluator, end);

                    String dateOfPaymentThird = getCellValueFormula(row.getCell(27), formulaEvaluator, end);

                    String arrangeContractDate = getCellValueFormula(row.getCell(28), formulaEvaluator, end);
                    String subscriptionWithoutContract = getCellValueFormula(row.getCell(29), formulaEvaluator, end);
                    String actualContractDate = getCellValueFormula(row.getCell(30), formulaEvaluator, end);
                    String loanAmount = getCellValueFormula(row.getCell(31), formulaEvaluator, end);
                    String transactLoanDate = getCellValueFormula(row.getCell(32), formulaEvaluator, end);
                    String loanBank = getCellValueFormula(row.getCell(33), formulaEvaluator, end);
                    String paymentMethod = getCellValueFormula(row.getCell(34), formulaEvaluator, end);
                    String paymentRate = getCellValueFormula(row.getCell(35), formulaEvaluator, end);
                    String accumulativePayment = getCellValueFormula(row.getCell(36), formulaEvaluator, end);
                    String unPayment = getCellValueFormula(row.getCell(37), formulaEvaluator, end);
                    String completePaymentDate = getCellValueFormula(row.getCell(38), formulaEvaluator, end);
                    String mortgageSchedule = getCellValueFormula(row.getCell(39), formulaEvaluator, end);
                    String salesCompany = getCellValueFormula(row.getCell(40), formulaEvaluator, end);
                    String staffPercentage = getCellValueFormula(row.getCell(41), formulaEvaluator, end);
                    String realtyConsultantSalary = getCellValueFormula(row.getCell(42), formulaEvaluator, end);
                    String realtyConsultant = getCellValueFormula(row.getCell(43), formulaEvaluator, end);
                    String abutmentPerson = getCellValueFormula(row.getCell(44), formulaEvaluator, end);
                    String agreementAuthenticationDate = getCellValueFormula(row.getCell(45), formulaEvaluator, end);
                    String address = getCellValueFormula(row.getCell(46), formulaEvaluator, end);
                    String cardId = getCellValueFormula(row.getCell(47), formulaEvaluator, end);
                    String age = getCellValueFormula(row.getCell(48), formulaEvaluator, end);
                    String residentialZone = getCellValueFormula(row.getCell(49), formulaEvaluator, end);
                    String workZone = getCellValueFormula(row.getCell(50), formulaEvaluator, end);
                    String occupation = getCellValueFormula(row.getCell(51), formulaEvaluator, end);
                    String accessKnown = getCellValueFormula(row.getCell(52), formulaEvaluator, end);
                    String referee = getCellValueFormula(row.getCell(53), formulaEvaluator, end);
                    String refereeTel = getCellValueFormula(row.getCell(54), formulaEvaluator, end);
                    String realtyPurpose = getCellValueFormula(row.getCell(55), formulaEvaluator, end);
                    String realtyTimes = getCellValueFormula(row.getCell(56), formulaEvaluator, end);
                    String salarySettlementSubmitTime = getCellValueFormula(row.getCell(57), formulaEvaluator, end);
                    String salaryGrantTime = getCellValueFormula(row.getCell(58), formulaEvaluator, end);
                    String salarySettlementRate = getCellValueFormula(row.getCell(59), formulaEvaluator, end);
                    String settleSalaryRate = getCellValueFormula(row.getCell(60), formulaEvaluator, end);
                    String settleSalaryMoney = getCellValueFormula(row.getCell(61), formulaEvaluator, end);
                    String salarySettlementSubmitTimeSecond = getCellValueFormula(row.getCell(62), formulaEvaluator, end);
                    String salaryGrantTimeSecond = getCellValueFormula(row.getCell(63), formulaEvaluator, end);
                    String salarySettlementRateSecond = getCellValueFormula(row.getCell(64), formulaEvaluator, end);
                    String deposit = getCellValueFormula(row.getCell(65), formulaEvaluator, end);
                    String predictedDeliverTime = getCellValueFormula(row.getCell(66), formulaEvaluator, end);
                    String signPurchaseContract = getCellValueFormula(row.getCell(67), formulaEvaluator, end);
                    String signPropertyContract = getCellValueFormula(row.getCell(68), formulaEvaluator, end);
                    String intermediaryMoney = getCellValueFormula(row.getCell(69), formulaEvaluator, end);
                    String oldToNew = getCellValueFormula(row.getCell(70), formulaEvaluator, end);
                    String customerOwnership = getCellValueFormula(row.getCell(71), formulaEvaluator, end);
                    String availableSignTime = getCellValueFormula(row.getCell(72), formulaEvaluator, end);
                    String mortgageHandle = getCellValueFormula(row.getCell(73), formulaEvaluator, end);
                    String remark = getCellValueFormula(row.getCell(74), formulaEvaluator, end);
                    if(customerTel.size() == 0){
                        ErrorLog errorLog = new ErrorLog(sheet.getSheetName(), i, "联系方式为空或者无法识别");
                        errorLogList.add(errorLog);
                        continue;
                    }
                    for(int k=0;k<customerTel.size();k++){
                        condition.clear();
                        condition.put("blockFlag", false);
                        Deal deal = new Deal(Integer.valueOf(subscriptionTime), recognitionTime, propertyType, dealSection, decoration, buildingId, roomNum, customerName, wechatId, customerTel.get(k), predictedArea, subscriptionUnitPrice, subscriptionTotalPrice, discountDetail, fiveToFifteen, fifteenAfterDiscount, openingQuotationDiscount, discountOfContractOntime, actualDealUnitPrice, dealTotalPriceInput, dealTotalPriceCheck, amountOfPaymentFirst, dateOfPaymentFirst, amountOfPaymentSecond, dateOfPaymentSecond, amountOfPaymentThird, dateOfPaymentThird, arrangeContractDate, subscriptionWithoutContract, actualContractDate, loanAmount, transactLoanDate, loanBank, paymentMethod, paymentRate, accumulativePayment, unPayment, completePaymentDate, mortgageSchedule, salesCompany, staffPercentage, realtyConsultantSalary, realtyConsultant, abutmentPerson, agreementAuthenticationDate, address, cardId, age, residentialZone, workZone, occupation, accessKnown, referee, refereeTel, realtyPurpose, realtyTimes, salarySettlementSubmitTime, salaryGrantTime, salarySettlementRate, settleSalaryRate, settleSalaryMoney, salarySettlementSubmitTimeSecond, salaryGrantTimeSecond, salarySettlementRateSecond, deposit, predictedDeliverTime, signPurchaseContract, signPropertyContract, intermediaryMoney, oldToNew, customerOwnership, availableSignTime, mortgageHandle, remark);
                        deal.setDealId(IDGenerator.generate("DEA"));
                        if(subscriptionTime.equals("false")){
                            ErrorLog errorLog = new ErrorLog(sheet.getSheetName(), i, "认购日期为空或者无法识别");
                            errorLogList.add(errorLog);
                            continue;
                        }
                        condition.put("subscriptionTime", subscriptionTime);
                        condition.put("customerTel", customerTel.get(k));
                        try {
                            List<Deal> list = sqlSession.selectList("xiaolu.deal.query", condition);
                            if (list.isEmpty()) {
                                try {
                                    sqlSession.insert("xiaolu.deal.insert", deal);
                                    this.createTel(deal.getCustomerName(), deal.getCustomerTel());
                                } catch (Exception e) {
                                    ErrorLog errorLog = new ErrorLog(sheet.getSheetName(), i, "数据库插入出错："+e.getMessage());
                                    errorLogList.add(errorLog);
                                    continue;
                                }
                            }else{
                                try {
                                    condition.remove("blockFlag");
                                    condition.put("blockFlag", true);
                                    sqlSession.update("xiaolu.deal.update", condition);
                                } catch (Exception e) {
                                    ErrorLog errorLog = new ErrorLog(sheet.getSheetName(), i, "数据库更新出错："+e.getMessage());
                                    errorLogList.add(errorLog);
                                    continue;
                                }
                                try {
                                    sqlSession.insert("xiaolu.deal.insert", deal);
                                    this.createTel(deal.getCustomerName(), deal.getCustomerTel());
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

    @Transactional
    @Override
    public ResultData createSummary(Map<String, Object> condition) {
        ResultData result = new ResultData();
        List<ErrorLog> errorLogList = new ArrayList<ErrorLog>();
        Sheet sheet = (Sheet) condition.get("sheet");
        Workbook workbook = (Workbook) condition.get("workbook");
        for(int i=1;i<sheet.getPhysicalNumberOfRows();i++){
            System.out.println("正在处理表"+sheet.getSheetName()+"的第"+i+"条记录;");
            if(sheet.getRow(i) != null && sheet.getRow(i).getFirstCellNum()==0 && sheet.getRow(i).getCell(0).toString().trim().length() > 0){
                Row row = sheet.getRow(i);
                String customerName = row.getCell(1) == null ? "" : row.getCell(1).toString().trim();
                String customerTel = row.getCell(2) == null ? "" : row.getCell(2).toString().trim();
                String intermediaryReportTime = row.getCell(3) == null ? "" : row.getCell(3).toString().trim();
                String intermediaryReportBuilding = row.getCell(4) == null ? "" : row.getCell(4).toString().trim();
                String intermediaryIntentionLevel = row.getCell(5) == null ? "" : row.getCell(5).toString().trim();
                String intermediaryVisitTime = row.getCell(6) == null ? "" : row.getCell(6).toString().trim();
                String intermediaryVisitBuilding = row.getCell(7) == null ? "" : row.getCell(7).toString().trim();
                String intermediaryCustomerSituation = row.getCell(8) == null ? "" : row.getCell(8).toString().trim();
                String intermediaryDealTime = row.getCell(9) == null ? "" : row.getCell(9).toString().trim();
                String intermediaryDealBuilding = row.getCell(10) == null ? "" : row.getCell(10).toString().trim();
                String intermediaryDealRoomnum = row.getCell(11) == null ? "" : row.getCell(11).toString().trim();
                String callCustomerDatasourceArea = row.getCell(12) == null ? "" : row.getCell(12).toString().trim();
                String callCustomerDatasourceBuilding = row.getCell(13) == null ? "" : row.getCell(13).toString().trim();
                String callCustomerCallTime = row.getCell(14) == null ? "" : row.getCell(14).toString().trim();
                String callCustomerCallSalesman = row.getCell(15) == null ? "" : row.getCell(15).toString().trim();
                String callCustomerIntentionLevel = row.getCell(16) == null ? "" : row.getCell(16).toString().trim();
                String callCustomerIntentionBuilding = row.getCell(17) == null ? "" : row.getCell(17).toString().trim();
                String callCustomerVisitTime = row.getCell(18) == null ? "" : row.getCell(18).toString().trim();
                String callCustomerVisitBuilding = row.getCell(19) == null ? "" : row.getCell(19).toString().trim();
                String callCustomerCustomerSituation = row.getCell(20) == null ? "" : row.getCell(20).toString().trim();
                String callCustomerDealTime = row.getCell(21) == null ? "" : row.getCell(21).toString().trim();
                String extensionExtensionTime = row.getCell(22) == null ? "" : row.getCell(22).toString().trim();
                String extensionRealtyConsultant = row.getCell(23) == null ? "" : row.getCell(23).toString().trim();
                String extensionVisitTime = row.getCell(24) == null ? "" : row.getCell(24).toString().trim();
                String extensionCustomerSituation = row.getCell(25) == null ? "" : row.getCell(25).toString().trim();
                String extensionDealTime = row.getCell(26) == null ? "" : row.getCell(26).toString().trim();
                String extensionDealBuilding = row.getCell(27) == null ? "" : row.getCell(27).toString().trim();
                String extensionDealRoomnum = row.getCell(28) == null ? "" : row.getCell(28).toString().trim();
                String incomingCallCallTime = row.getCell(29) == null ? "" : row.getCell(29).toString().trim();
                String incomingCallRealtyPurpose = row.getCell(30) == null ? "" : row.getCell(30).toString().trim();
                String incomingCallDemandArea = row.getCell(31) == null ? "" : row.getCell(31).toString().trim();
                String incomingCallHouseType = row.getCell(32) == null ? "" : row.getCell(32).toString().trim();
                String incomingCallResidentialZone = row.getCell(33) == null ? "" : row.getCell(33).toString().trim();
                String incomingCallAcceptPrice = row.getCell(34) == null ? "" : row.getCell(34).toString().trim();
                String incomingCallVisitTime = row.getCell(35) == null ? "" : row.getCell(35).toString().trim();
                String incomingCallCustomerSituation = row.getCell(36) == null ? "" : row.getCell(36).toString().trim();
                String incomingCallDealTime = row.getCell(37) == null ? "" : row.getCell(37).toString().trim();
                String incomingCallDealBuilding = row.getCell(38) == null ? "" : row.getCell(38).toString().trim();
                String incomingCallDealRoomnum = row.getCell(39) == null ? "" : row.getCell(39).toString().trim();
                String incomingCallSalesman = row.getCell(40) == null ? "" : row.getCell(40).toString().trim();
                String visitVisitTime = row.getCell(41) == null ? "" : row.getCell(41).toString().trim();
                String visitIntentionalArea = row.getCell(42) == null ? "" : row.getCell(42).toString().trim();
                String visitAcceptPrice = row.getCell(43) == null ? "" : row.getCell(43).toString().trim();
                String visitResidentialZone = row.getCell(44) == null ? "" : row.getCell(44).toString().trim();
                String visitRealtyPurpose = row.getCell(45) == null ? "" : row.getCell(45).toString().trim();
                String visitCustomerType = row.getCell(46) == null ? "" : row.getCell(46).toString().trim();
                String visitRealtyConsultant = row.getCell(47) == null ? "" : row.getCell(47).toString().trim();
                String visitDealTime = row.getCell(48) == null ? "" : row.getCell(48).toString().trim();
                String visitDealRoomnum = row.getCell(49) == null ? "" : row.getCell(49).toString().trim();
                String dealSubscriptionTime = row.getCell(50) == null ? "" : row.getCell(50).toString().trim();
                String dealAccessKnown = row.getCell(51) == null ? "" : row.getCell(51).toString().trim();
                String dealReferee = row.getCell(52) == null ? "" : row.getCell(52).toString().trim();
                String dealRefereeTel = row.getCell(53) == null ? "" : row.getCell(53).toString().trim();
                if(intermediaryReportTime.length()>0){
                    condition.clear();
                    condition.put("blockFlag", false);
                    condition.put("customerTel", customerTel);
                    condition.put("reportTime", Integer.valueOf(intermediaryReportTime.replace("/", "")));
                    condition.put("reportBuilding", intermediaryReportBuilding);
                    condition.put("intentionLevel", intermediaryIntentionLevel);
                    condition.put("visitTime", intermediaryVisitTime);
                    condition.put("visitBuilding", intermediaryVisitBuilding);
                    condition.put("customerSituation", intermediaryCustomerSituation);
                    condition.put("dealTime", intermediaryDealTime);
                    condition.put("dealBuilding", intermediaryDealBuilding);
                    condition.put("dealRoomnum", intermediaryDealRoomnum);
                    try {
                        sqlSession.update("xiaolu.intermediary.summaryupdate", condition);
                    } catch (Exception e) {
                        ErrorLog errorLog = new ErrorLog(sheet.getSheetName(), i, "中介表更新出错："+e.getMessage());
                        errorLogList.add(errorLog);
                    }
                }
                if(callCustomerCallTime.length()>0) {
                    condition.clear();
                    condition.put("blockFlag", false);
                    condition.put("customerTel", customerTel);
                    condition.put("datasourceArea", callCustomerDatasourceArea);
                    condition.put("datasourceBuilding", callCustomerDatasourceBuilding);
                    condition.put("callTime", Integer.valueOf(callCustomerCallTime.replace("/", "")));
                    condition.put("callSalesman", callCustomerCallSalesman);
                    condition.put("intentionLevel", callCustomerIntentionLevel);
                    condition.put("intentionBuilding", callCustomerIntentionBuilding);
                    condition.put("visitTime", callCustomerVisitTime);
                    condition.put("visitBuilding", callCustomerVisitBuilding);
                    condition.put("customerSituation", callCustomerCustomerSituation);
                    condition.put("dealTime", callCustomerDealTime);
                    try {
                        sqlSession.update("xiaolu.callcustomer.summaryupdate", condition);
                    } catch (Exception e) {
                        ErrorLog errorLog = new ErrorLog(sheet.getSheetName(), i, "CALL客表更新出错：" + e.getMessage());
                        errorLogList.add(errorLog);
                    }
                }
                if(extensionExtensionTime.length()>0) {
                    condition.clear();
                    condition.put("blockFlag", false);
                    condition.put("customerTel", customerTel);
                    condition.put("extensionTime", Integer.valueOf(extensionExtensionTime.replace("/", "")));
                    condition.put("realtyConsultant", extensionRealtyConsultant);
                    condition.put("visitTime", extensionVisitTime);
                    condition.put("customerSituation", extensionCustomerSituation);
                    condition.put("dealTime", extensionDealTime);
                    condition.put("dealBuilding", extensionDealBuilding);
                    condition.put("dealRoomnum", extensionDealRoomnum);
                    try {
                        sqlSession.update("xiaolu.extension.summaryupdate", condition);
                    } catch (Exception e) {
                        ErrorLog errorLog = new ErrorLog(sheet.getSheetName(), i, "外拓表更新出错：" + e.getMessage());
                        errorLogList.add(errorLog);
                    }
                }
                if(incomingCallCallTime.length()>0) {
                    condition.clear();
                    condition.put("blockFlag", false);
                    condition.put("customerTel", customerTel);
                    condition.put("callTime", Integer.valueOf(incomingCallCallTime.replace("/", "")));
                    condition.put("realtyPurpose", incomingCallRealtyPurpose);
                    condition.put("demandArea", incomingCallDemandArea);
                    condition.put("houseType", incomingCallHouseType);
                    condition.put("residentialZone", incomingCallResidentialZone);
                    condition.put("acceptPrice", incomingCallAcceptPrice);
                    condition.put("visitTime", incomingCallVisitTime);
                    condition.put("customerSituation", incomingCallCustomerSituation);
                    condition.put("dealTime", incomingCallDealTime);
                    condition.put("dealBuilding", incomingCallDealBuilding);
                    condition.put("dealRoomnum", incomingCallDealRoomnum);
                    condition.put("salesman", incomingCallSalesman);
                    try {
                        sqlSession.update("xiaolu.incomingcall.summaryupdate", condition);
                    } catch (Exception e) {
                        ErrorLog errorLog = new ErrorLog(sheet.getSheetName(), i, "来电表更新出错：" + e.getMessage());
                        errorLogList.add(errorLog);
                    }
                }
                if(visitVisitTime.length()>0) {
                    condition.clear();
                    condition.put("blockFlag", false);
                    condition.put("customerTel", customerTel);
                    condition.put("visitTime", Integer.valueOf(visitVisitTime.replace("/", "")));
                    condition.put("intentionalArea", visitIntentionalArea);
                    condition.put("acceptPrice", visitAcceptPrice);
                    condition.put("residentialZone", visitResidentialZone);
                    condition.put("realtyPurpose", visitRealtyPurpose);
                    condition.put("customerType", visitCustomerType);
                    condition.put("realtyConsultant", visitRealtyConsultant);
                    condition.put("dealTime", visitDealTime);
                    condition.put("dealRoomnum", visitDealRoomnum);
                    try {
                        sqlSession.update("xiaolu.visit.summaryupdate", condition);
                    } catch (Exception e) {
                        ErrorLog errorLog = new ErrorLog(sheet.getSheetName(), i, "来访表更新出错：" + e.getMessage());
                        errorLogList.add(errorLog);
                    }
                }
                if(dealSubscriptionTime.length()>0) {
                    condition.clear();
                    condition.put("blockFlag", false);
                    condition.put("customerTel", customerTel);
                    condition.put("subscriptionTime", Integer.valueOf(dealSubscriptionTime.replace("/", "")));
                    condition.put("accessKnown", dealAccessKnown);
                    condition.put("referee", dealReferee);
                    condition.put("refereeTel", dealRefereeTel);
                    try {
                        sqlSession.update("xiaolu.deal.summaryupdate", condition);
                    } catch (Exception e) {
                        ErrorLog errorLog = new ErrorLog(sheet.getSheetName(), i, "成交表更新出错：" + e.getMessage());
                        errorLogList.add(errorLog);
                    }
                }
            }else{
                break;
            }
        }
        result.setData(errorLogList);
        return result;
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

    @Override
    public ResultData queryIntermediary(Map<String, Object> condition) {
        ResultData result = new ResultData();
        try {
            List<Intermediary> list = sqlSession.selectList("xiaolu.intermediary.query", condition);
            if (list.isEmpty()) {
                result.setResponseCode(ResponseCode.RESPONSE_NULL);
            }
            result.setData(list);
        } catch (Exception e) {
            result.setResponseCode(ResponseCode.RESPONSE_ERROR);
            result.setDescription(e.getMessage());
        }
        return result;
    }

    @Override
    public ResultData searchIntermediary(Map<String, Object> condition) {
        ResultData result = new ResultData();
        try {
            List<Intermediary> list = sqlSession.selectList("xiaolu.intermediary.search", condition);
            if (list.isEmpty()) {
                result.setResponseCode(ResponseCode.RESPONSE_NULL);
            }
            result.setData(list);
        } catch (Exception e) {
            result.setResponseCode(ResponseCode.RESPONSE_ERROR);
            result.setDescription(e.getMessage());
        }
        return result;
    }

    @Override
    public ResultData queryCallCustomer(Map<String, Object> condition) {
        ResultData result = new ResultData();
        try {
            List<CallCustomer> list = sqlSession.selectList("xiaolu.callcustomer.query", condition);
            if (list.isEmpty()) {
                result.setResponseCode(ResponseCode.RESPONSE_NULL);
            }
            result.setData(list);
        } catch (Exception e) {
            result.setResponseCode(ResponseCode.RESPONSE_ERROR);
            result.setDescription(e.getMessage());
        }
        return result;
    }

    @Override
    public ResultData searchCallCustomer(Map<String, Object> condition) {
        ResultData result = new ResultData();
        try {
            List<CallCustomer> list = sqlSession.selectList("xiaolu.callcustomer.search", condition);
            if (list.isEmpty()) {
                result.setResponseCode(ResponseCode.RESPONSE_NULL);
            }
            result.setData(list);
        } catch (Exception e) {
            result.setResponseCode(ResponseCode.RESPONSE_ERROR);
            result.setDescription(e.getMessage());
        }
        return result;
    }

    @Override
    public ResultData queryExtension(Map<String, Object> condition) {
        ResultData result = new ResultData();
        try {
            List<Extension> list = sqlSession.selectList("xiaolu.extension.query", condition);
            if (list.isEmpty()) {
                result.setResponseCode(ResponseCode.RESPONSE_NULL);
            }
            result.setData(list);
        } catch (Exception e) {
            result.setResponseCode(ResponseCode.RESPONSE_ERROR);
            result.setDescription(e.getMessage());
        }
        return result;
    }

    @Override
    public ResultData searchExtension(Map<String, Object> condition) {
        ResultData result = new ResultData();
        try {
            List<Extension> list = sqlSession.selectList("xiaolu.extension.search", condition);
            if (list.isEmpty()) {
                result.setResponseCode(ResponseCode.RESPONSE_NULL);
            }
            result.setData(list);
        } catch (Exception e) {
            result.setResponseCode(ResponseCode.RESPONSE_ERROR);
            result.setDescription(e.getMessage());
        }
        return result;
    }

    @Override
    public ResultData queryIncomingCall(Map<String, Object> condition) {
        ResultData result = new ResultData();
        try {
            List<IncomingCall> list = sqlSession.selectList("xiaolu.incomingcall.query", condition);
            if (list.isEmpty()) {
                result.setResponseCode(ResponseCode.RESPONSE_NULL);
            }
            result.setData(list);
        } catch (Exception e) {
            result.setResponseCode(ResponseCode.RESPONSE_ERROR);
            result.setDescription(e.getMessage());
        }
        return result;
    }

    @Override
    public ResultData searchIncomingCall(Map<String, Object> condition) {
        ResultData result = new ResultData();
        try {
            List<IncomingCall> list = sqlSession.selectList("xiaolu.incomingcall.search", condition);
            if (list.isEmpty()) {
                result.setResponseCode(ResponseCode.RESPONSE_NULL);
            }
            result.setData(list);
        } catch (Exception e) {
            result.setResponseCode(ResponseCode.RESPONSE_ERROR);
            result.setDescription(e.getMessage());
        }
        return result;
    }

    @Override
    public ResultData queryVisit(Map<String, Object> condition) {
        ResultData result = new ResultData();
        try {
            List<Visit> list = sqlSession.selectList("xiaolu.visit.query", condition);
            if (list.isEmpty()) {
                result.setResponseCode(ResponseCode.RESPONSE_NULL);
            }
            result.setData(list);
        } catch (Exception e) {
            result.setResponseCode(ResponseCode.RESPONSE_ERROR);
            result.setDescription(e.getMessage());
        }
        return result;
    }

    @Override
    public ResultData searchVisit(Map<String, Object> condition) {
        ResultData result = new ResultData();
        try {
            List<Visit> list = sqlSession.selectList("xiaolu.visit.search", condition);
            if (list.isEmpty()) {
                result.setResponseCode(ResponseCode.RESPONSE_NULL);
            }
            result.setData(list);
        } catch (Exception e) {
            result.setResponseCode(ResponseCode.RESPONSE_ERROR);
            result.setDescription(e.getMessage());
        }
        return result;
    }

    @Override
    public ResultData queryDeal(Map<String, Object> condition) {
        ResultData result = new ResultData();
        try {
            List<Deal> list = sqlSession.selectList("xiaolu.deal.query", condition);
            if (list.isEmpty()) {
                result.setResponseCode(ResponseCode.RESPONSE_NULL);
            }
            result.setData(list);
        } catch (Exception e) {
            result.setResponseCode(ResponseCode.RESPONSE_ERROR);
            result.setDescription(e.getMessage());
        }
        return result;
    }

    @Override
    public ResultData searchDeal(Map<String, Object> condition) {
        ResultData result = new ResultData();
        try {
            List<Deal> list = sqlSession.selectList("xiaolu.deal.search", condition);
            if (list.isEmpty()) {
                result.setResponseCode(ResponseCode.RESPONSE_NULL);
            }
            result.setData(list);
        } catch (Exception e) {
            result.setResponseCode(ResponseCode.RESPONSE_ERROR);
            result.setDescription(e.getMessage());
        }
        return result;
    }

    public void createTel(String telName, String telContent){
        Map<String, Object> condition = new HashMap<String, Object>();
        condition.put("blockFlag", false);
        condition.put("telName", telName);
        condition.put("telContent", telContent);
        List<Tel> list = sqlSession.selectList("xiaolu.tel.query", condition);
        if (list.isEmpty()) {
            Tel tel = new Tel(IDGenerator.generate("TEL"), telName, telContent);
            sqlSession.insert("xiaolu.tel.insert", tel);
            System.out.println("新增一条用户记录;");
        }
    }

    @Override
    public ResultData querySummary(Map<String, Object> condition) {
        ResultData result = new ResultData();
        try {
            List<Summary> summaryList = new ArrayList<Summary>();
            List<Tel> list = sqlSession.selectList("xiaolu.tel.query", condition);
            if (list.isEmpty()) {
                result.setResponseCode(ResponseCode.RESPONSE_NULL);
            }else{
                for(int i=0;i<list.size();i++){
                    condition.clear();
                    condition.put("customerName", list.get(i).getTelName());
                    condition.put("customerTel", list.get(i).getTelContent());
                    condition.put("blockFlag", false);
                    Summary summary = new Summary(list.get(i).getTelName(), list.get(i).getTelContent());
                    List<Intermediary> intermediaryList = sqlSession.selectList("xiaolu.intermediary.query", condition);
                    if(!intermediaryList.isEmpty()){
                        summary.setIntermediaryReportTime(String.valueOf(intermediaryList.get(0).getReportTime()));
                        summary.setIntermediaryReportBuilding(intermediaryList.get(0).getReportBuilding());
                        summary.setIntermediaryIntentionLevel(intermediaryList.get(0).getIntentionLevel());
                        summary.setIntermediaryVisitTime(intermediaryList.get(0).getVisitTime());
                        summary.setIntermediaryVisitBuilding(intermediaryList.get(0).getVisitBuilding());
                        summary.setIntermediaryCustomerSituation(intermediaryList.get(0).getCustomerSituation());
                        summary.setIntermediaryDealTime(intermediaryList.get(0).getDealTime());
                        summary.setIntermediaryDealBuilding(intermediaryList.get(0).getDealBuilding());
                        summary.setIntermediaryDealRoomnum(intermediaryList.get(0).getDealRoomnum());
                    }
                    List<CallCustomer> callCustomerList = sqlSession.selectList("xiaolu.callcustomer.query", condition);
                    if(!callCustomerList.isEmpty()){
                        summary.setCallCustomerDatasourceArea(callCustomerList.get(0).getDatasourceArea());
                        summary.setCallCustomerDatasourceBuilding(callCustomerList.get(0).getDatasourceBuilding());
                        summary.setCallCustomerCallTime(String.valueOf(callCustomerList.get(0).getCallTime()));
                        summary.setCallCustomerCallSalesman(callCustomerList.get(0).getCallSalesman());
                        summary.setCallCustomerIntentionLevel(callCustomerList.get(0).getIntentionLevel());
                        summary.setCallCustomerIntentionBuilding(callCustomerList.get(0).getIntentionBuilding());
                        summary.setCallCustomerVisitTime(callCustomerList.get(0).getVisitTime());;
                        summary.setCallCustomerVisitBuilding(callCustomerList.get(0).getVisitBuilding());
                        summary.setCallCustomerCustomerSituation(callCustomerList.get(0).getCustomerSituation());
                        summary.setCallCustomerDealTime(callCustomerList.get(0).getDealTime());
                    }
                    List<Extension> extensionList = sqlSession.selectList("xiaolu.extension.query", condition);
                    if(!extensionList.isEmpty()){
                        summary.setExtensionExtensionTime(String.valueOf(extensionList.get(0).getExtensionTime()));
                        summary.setExtensionRealtyConsultant(extensionList.get(0).getRealtyConsultant());
                        summary.setExtensionVisitTime(extensionList.get(0).getVisitTime());
                        summary.setExtensionCustomerSituation(extensionList.get(0).getCustomerSituation());
                        summary.setExtensionDealTime(extensionList.get(0).getDealTime());
                        summary.setExtensionDealBuilding(extensionList.get(0).getDealRoomnum());
                        summary.setExtensionDealRoomnum(extensionList.get(0).getDealRoomnum());
                    }
                    List<IncomingCall> incomingCallList = sqlSession.selectList("xiaolu.incomingcall.query", condition);
                    if(!incomingCallList.isEmpty()){
                        summary.setIncomingCallCallTime(String.valueOf(incomingCallList.get(0).getCallTime()));
                        summary.setIncomingCallRealtyPurpose(incomingCallList.get(0).getRealtyPurpose());
                        summary.setIncomingCallDemandArea(incomingCallList.get(0).getDemandArea());
                        summary.setIncomingCallHouseType(incomingCallList.get(0).getHouseType());
                        summary.setIncomingCallResidentialZone(incomingCallList.get(0).getResidentialZone());
                        summary.setIncomingCallAcceptPrice(incomingCallList.get(0).getAcceptPrice());
                        summary.setIncomingCallVisitTime(incomingCallList.get(0).getVisitTime());
                        summary.setIncomingCallCustomerSituation(incomingCallList.get(0).getCustomerSituation());
                        summary.setIncomingCallDealTime(incomingCallList.get(0).getDealTime());
                        summary.setIncomingCallDealBuilding(incomingCallList.get(0).getDealBuilding());
                        summary.setIncomingCallDealRoomnum(incomingCallList.get(0).getDealRoomnum());
                        summary.setIncomingCallSalesman(incomingCallList.get(0).getSalesman());
                    }
                    List<Visit> visitList = sqlSession.selectList("xiaolu.visit.query", condition);
                    if(!visitList.isEmpty()){
                        summary.setVisitVisitTime(String.valueOf(visitList.get(0).getVisitTime()));
                        summary.setVisitIntentionalArea(visitList.get(0).getIntentionalArea());
                        summary.setVisitAcceptPrice(visitList.get(0).getAcceptPrice());
                        summary.setVisitResidentialZone(visitList.get(0).getResidentialZone());
                        summary.setVisitRealtyPurpose(visitList.get(0).getRealtyPurpose());
                        summary.setVisitCustomerType(visitList.get(0).getCustomerType());
                        summary.setVisitRealtyConsultant(visitList.get(0).getRealtyConsultant());
                        summary.setVisitDealTime(visitList.get(0).getDealTime());
                        summary.setVisitDealRoomnum(visitList.get(0).getDealRoomnum());
                    }
                    List<Deal> dealList = sqlSession.selectList("xiaolu.deal.query", condition);
                    if(!dealList.isEmpty()){
                        summary.setDealSubscriptionTime(String.valueOf(dealList.get(0).getSubscriptionTime()));
                        summary.setDealAccessKnown(dealList.get(0).getAccessKnown());
                        summary.setDealReferee(dealList.get(0).getReferee());
                        summary.setDealRefereeTel(dealList.get(0).getRefereeTel());
                    }
                    summaryList.add(summary);
                }
            }
            result.setData(summaryList);
        } catch (Exception e) {
            result.setResponseCode(ResponseCode.RESPONSE_ERROR);
            result.setDescription(e.getMessage());
        }
        return result;
    }

    @Override
    public ResultData queryAdmin(Map<String, Object> condition) {
        ResultData result = new ResultData();
        try {
            List<Admin> list = sqlSession.selectList("xiaolu.admin.query", condition);
            if (list.isEmpty()) {
                result.setResponseCode(ResponseCode.RESPONSE_NULL);
            }
            result.setData(list);
        } catch (Exception e) {
            result.setResponseCode(ResponseCode.RESPONSE_ERROR);
            result.setDescription(e.getMessage());
        }
        return result;
    }

    @Override
    public ResultData updateAdmin(Map<String, Object> condition) {
        ResultData result = new ResultData();
        try {
            sqlSession.update("xiaolu.admin.update", condition);
        } catch (Exception e) {
            result.setResponseCode(ResponseCode.RESPONSE_ERROR);
            result.setDescription(e.getMessage());
        }
        return result;
    }

}
