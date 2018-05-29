package dao.impl;

import auxiliary.*;
import dao.BaseDao;
import dao.XiaoLuDao;
import model.Intermediary;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
            if(sheet.getRow(i).getCell(0).toString().trim().length()>0){
                Row row = sheet.getRow(i);
                String reportTime = row.getCell(1).toString().trim();
                String tempTel = row.getCell(5).toString().trim();
                reportTime = TimeFilter.getTime(reportTime);
                ArrayList<String> customerTel = TelFilter.getTel(tempTel);
                String customerSource = row.getCell(2).toString().trim();
                String reportBuilding = row.getCell(3).toString().trim();
                String customerName = row.getCell(4).toString().trim();
                String intentionLevel = row.getCell(6).toString().trim();
                String visitTime = row.getCell(7).toString().trim();
                String visitBuilding = row.getCell(8).toString().trim();
                String customerSituation = row.getCell(9).toString().trim();
                String dealTime = row.getCell(10).toString().trim();
                String dealBuilding = row.getCell(11).toString().trim();
                String dealRoomnum = row.getCell(12).toString().trim();
                String remark = row.getCell(13).toString().trim();
                if(customerTel.size() == 0){
                    ErrorLog errorLog = new ErrorLog(sheet.getSheetName(), i-1, "客户电话为空");
                    errorLogList.add(errorLog);
                    continue;
                }
                for(int k=0;k<customerTel.size();k++){
                    condition.clear();
                    condition.put("blockFlag", false);
                    Intermediary intermediary = new Intermediary(reportTime, customerSource, reportBuilding, customerName, customerTel.get(k), intentionLevel, visitTime, visitBuilding, customerSituation, dealTime, dealBuilding, dealRoomnum, remark);
                    intermediary.setIntermediaryId(IDGenerator.generate("ITM"));
                    if(reportTime.equals("false")){
                        ErrorLog errorLog = new ErrorLog(sheet.getSheetName(), i-1, "报备时间为空");
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

            }else{
                break;
            }
        }
        result.setData(errorLogList);
        return result;
    }

    @Override
    public ResultData createCallCustomer(Map<String, Object> condition) {
        ResultData result = new ResultData();
        List<ErrorLog> errorLogList = new ArrayList<ErrorLog>();
        Sheet sheet = (Sheet) condition.get("sheet");
        for(int i=2;i<sheet.getPhysicalNumberOfRows();i++) {
            if (sheet.getRow(i) != null && sheet.getRow(i).getFirstCellNum()==0 && sheet.getRow(i).getCell(0).toString().trim().length() > 0) {
                Row row = sheet.getRow(i);
                System.out.println(row.getCell(5).toString().trim());
                System.out.println(row.getCell(6).toString().trim());
            }else{
                break;
            }
        }
        result.setData(errorLogList);
        return result;
    }

    @Override
    public ResultData createExtension(Map<String, Object> condition) {
        return null;
    }

    @Override
    public ResultData createIncomingCall(Map<String, Object> condition) {
        return null;
    }

    @Override
    public ResultData createVisit(Map<String, Object> condition) {
        return null;
    }

    @Override
    public ResultData handleUnknown(Map<String, Object> condition) {
        return null;
    }

}
