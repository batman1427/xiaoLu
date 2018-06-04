package excel.template;

import model.Summary;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

public class SummaryExcel {
    public static void createTable(Map<String, Object> condition) throws IOException {
        Workbook workbook = null;
        String excelPath = (String)condition.get("file");
        File file = new File(excelPath);
        Sheet sheet = null;
        if (excelPath.endsWith("xls")) {
            workbook = new HSSFWorkbook();
        } else if(excelPath.endsWith("xlsx")) {
            workbook = new XSSFWorkbook();
        } else {
            System.out.println("文件格式不正确");
        }
        if(!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }
        sheet = (Sheet) workbook.createSheet("综合");
        OutputStream outputStream = new FileOutputStream(excelPath);
        workbook.write(outputStream);
        outputStream.flush();
        outputStream.close();
        Row row0 = sheet.createRow(0);

        Cell cell1 = row0.createCell(0);
        cell1.setCellValue("序号");
        Cell cell2 = row0.createCell(1);
        cell2.setCellValue("客户姓名");
        Cell cell3 = row0.createCell(2);
        cell3.setCellValue("联系方式");
        Cell cell4 = row0.createCell(3);
        cell4.setCellValue("中介-报备日期");
        Cell cell5 = row0.createCell(4);
        cell5.setCellValue("中介-报备楼盘");
        Cell cell6 = row0.createCell(5);
        cell6.setCellValue("中介-意向等级");
        Cell cell7 = row0.createCell(6);
        cell7.setCellValue("中介-到访时间");
        Cell cell8 = row0.createCell(7);
        cell8.setCellValue("中介-到访楼盘");
        Cell cell9 = row0.createCell(8);
        cell9.setCellValue("中介-客户情况");
        Cell cell10 = row0.createCell(9);
        cell10.setCellValue("中介-成交日期");
        Cell cell11 = row0.createCell(10);
        cell11.setCellValue("中介-成交楼盘");
        Cell cell12 = row0.createCell(11);
        cell12.setCellValue("中介-成交房号");
        Cell cell13 = row0.createCell(12);
        cell13.setCellValue("CALL客-区域");
        Cell cell14 = row0.createCell(13);
        cell14.setCellValue("CALL客-楼盘名称");
        Cell cell15 = row0.createCell(14);
        cell15.setCellValue("CALL客-call客日期");
        Cell cell16 = row0.createCell(15);
        cell16.setCellValue("CALL客-call客人员");
        Cell cell17 = row0.createCell(16);
        cell17.setCellValue("CALL客-意向等级");
        Cell cell18 = row0.createCell(17);
        cell18.setCellValue("CALL客-意向楼盘");
        Cell cell19 = row0.createCell(18);
        cell19.setCellValue("CALL客-转访时间");
        Cell cell20 = row0.createCell(19);
        cell20.setCellValue("CALL客-转访楼盘");
        Cell cell21 = row0.createCell(20);
        cell21.setCellValue("CALL客-客户情况");
        Cell cell22 = row0.createCell(21);
        cell22.setCellValue("CALL客-成交日期");
        Cell cell23 = row0.createCell(22);
        cell23.setCellValue("外拓-日期");
        Cell cell24 = row0.createCell(23);
        cell24.setCellValue("外拓-置业顾问");
        Cell cell25 = row0.createCell(24);
        cell25.setCellValue("外拓-转访日期");
        Cell cell26 = row0.createCell(25);
        cell26.setCellValue("外拓-客户情况");
        Cell cell27 = row0.createCell(26);
        cell27.setCellValue("外拓-成交日期");
        Cell cell28 = row0.createCell(27);
        cell28.setCellValue("外拓-成交楼盘");
        Cell cell29 = row0.createCell(28);
        cell29.setCellValue("外拓-成交房号");
        Cell cell30 = row0.createCell(29);
        cell30.setCellValue("来电-来电日期");
        Cell cell31 = row0.createCell(30);
        cell31.setCellValue("来电-置业目的");
        Cell cell32 = row0.createCell(31);
        cell32.setCellValue("来电-需求面积");
        Cell cell33 = row0.createCell(32);
        cell33.setCellValue("来电-户型");
        Cell cell34 = row0.createCell(33);
        cell34.setCellValue("来电-居住区域");
        Cell cell35 = row0.createCell(34);
        cell35.setCellValue("来电-接受价位");
        Cell cell36 = row0.createCell(35);
        cell36.setCellValue("来电-转访日期");
        Cell cell37 = row0.createCell(36);
        cell37.setCellValue("来电-客户情况");
        Cell cell38 = row0.createCell(37);
        cell38.setCellValue("来电-成交日期");
        Cell cell39 = row0.createCell(38);
        cell39.setCellValue("来电-成交楼盘");
        Cell cell40 = row0.createCell(39);
        cell40.setCellValue("来电-成交房号");
        Cell cell41 = row0.createCell(40);
        cell41.setCellValue("来电-销售员");
        Cell cell42 = row0.createCell(41);
        cell42.setCellValue("来访-来访日期");
        Cell cell43 = row0.createCell(42);
        cell43.setCellValue("来访-意向面积");
        Cell cell44 = row0.createCell(43);
        cell44.setCellValue("来访-接受价位");
        Cell cell45 = row0.createCell(44);
        cell45.setCellValue("来访-居住区域");
        Cell cell46 = row0.createCell(45);
        cell46.setCellValue("来访-置业目的");
        Cell cell47 = row0.createCell(46);
        cell47.setCellValue("来访-客户类别");
        Cell cell48 = row0.createCell(47);
        cell48.setCellValue("来访-置业顾问");
        Cell cell49 = row0.createCell(48);
        cell49.setCellValue("来访-成交日期");
        Cell cell50 = row0.createCell(49);
        cell50.setCellValue("来访-成交房号");
        Cell cell51 = row0.createCell(50);
        cell51.setCellValue("成交-认购日期");
        Cell cell52 = row0.createCell(51);
        cell52.setCellValue("成交-获知途径");
        Cell cell53 = row0.createCell(52);
        cell53.setCellValue("成交-推荐人");
        Cell cell54 = row0.createCell(53);
        cell54.setCellValue("成交-推荐人联系电话");


        if(String.valueOf(condition.get("response")).equals("RESPONSE_OK")){
            List<Summary> list = (List<Summary>) condition.get("data");
            for(int i=0;i<list.size();i++){
                Row row = sheet.createRow(i+1);
                Cell cell = row.createCell(0);
                cell.setCellValue(i+1);
                Cell cell101 = row.createCell(1);
                cell101.setCellValue(list.get(i).getCustomerName());
                Cell cell102 = row.createCell(2);
                cell102.setCellValue(list.get(i).getCustomerTel());
                Cell cell103 = row.createCell(3);
                String time = String.valueOf(list.get(i).getIntermediaryReportTime());
                if(time.length()>0) {
                    time = time.substring(0, 4) + "/" + time.substring(4, 6) + "/" + time.substring(6);
                }
                cell103.setCellValue(time);
                Cell cell104 = row.createCell(4);
                cell104.setCellValue(list.get(i).getIntermediaryReportBuilding());
                Cell cell105 = row.createCell(5);
                cell105.setCellValue(list.get(i).getIntermediaryIntentionLevel());
                Cell cell106 = row.createCell(6);
                cell106.setCellValue(list.get(i).getIntermediaryVisitTime());
                Cell cell107 = row.createCell(7);
                cell107.setCellValue(list.get(i).getIntermediaryVisitBuilding());
                Cell cell108 = row.createCell(8);
                cell108.setCellValue(list.get(i).getIntermediaryCustomerSituation());
                Cell cell109 = row.createCell(9);
                cell109.setCellValue(list.get(i).getIntermediaryDealTime());
                Cell cell110 = row.createCell(10);
                cell110.setCellValue(list.get(i).getIntermediaryDealBuilding());
                Cell cell111 = row.createCell(11);
                cell111.setCellValue(list.get(i).getIntermediaryDealRoomnum());
                Cell cell112 = row.createCell(12);
                cell112.setCellValue(list.get(i).getCallCustomerDatasourceArea());
                Cell cell113 = row.createCell(13);
                cell113.setCellValue(list.get(i).getCallCustomerDatasourceBuilding());
                Cell cell114 = row.createCell(14);
                String time1 = String.valueOf(list.get(i).getCallCustomerCallTime());
                if(time1.length()>0) {
                    time1 = time1.substring(0, 4) + "/" + time1.substring(4, 6) + "/" + time1.substring(6);
                }
                cell114.setCellValue(time1);
                Cell cell115 = row.createCell(15);
                cell115.setCellValue(list.get(i).getCallCustomerCallSalesman());
                Cell cell116 = row.createCell(16);
                cell116.setCellValue(list.get(i).getCallCustomerIntentionLevel());
                Cell cell117 = row.createCell(17);
                cell117.setCellValue(list.get(i).getCallCustomerIntentionBuilding());
                Cell cell118 = row.createCell(18);
                cell118.setCellValue(list.get(i).getCallCustomerVisitTime());
                Cell cell119 = row.createCell(19);
                cell119.setCellValue(list.get(i).getCallCustomerVisitBuilding());
                Cell cell120 = row.createCell(20);
                cell120.setCellValue(list.get(i).getCallCustomerCustomerSituation());
                Cell cell121 = row.createCell(21);
                cell121.setCellValue(list.get(i).getCallCustomerDealTime());
                Cell cell122 = row.createCell(22);
                String time2 = String.valueOf(list.get(i).getExtensionExtensionTime());
                if(time2.length()>0) {
                    time2 = time2.substring(0, 4) + "/" + time2.substring(4, 6) + "/" + time2.substring(6);
                }
                cell122.setCellValue(time2);
                Cell cell123 = row.createCell(23);
                cell123.setCellValue(list.get(i).getExtensionRealtyConsultant());
                Cell cell124 = row.createCell(24);
                cell124.setCellValue(list.get(i).getExtensionVisitTime());
                Cell cell125 = row.createCell(25);
                cell125.setCellValue(list.get(i).getExtensionCustomerSituation());
                Cell cell126 = row.createCell(26);
                cell126.setCellValue(list.get(i).getExtensionDealTime());
                Cell cell127 = row.createCell(27);
                cell127.setCellValue(list.get(i).getExtensionDealBuilding());
                Cell cell128 = row.createCell(28);
                cell128.setCellValue(list.get(i).getExtensionDealRoomnum());
                Cell cell129 = row.createCell(29);
                String time3 = String.valueOf(list.get(i).getIncomingCallCallTime());
                if(time3.length()>0) {
                    time3 = time3.substring(0, 4) + "/" + time3.substring(4, 6) + "/" + time3.substring(6);
                }
                cell129.setCellValue(time3);
                Cell cell130 = row.createCell(30);
                cell130.setCellValue(list.get(i).getIncomingCallRealtyPurpose());
                Cell cell131 = row.createCell(31);
                cell131.setCellValue(list.get(i).getIncomingCallDemandArea());
                Cell cell132 = row.createCell(32);
                cell132.setCellValue(list.get(i).getIncomingCallHouseType());
                Cell cell133 = row.createCell(33);
                cell133.setCellValue(list.get(i).getIncomingCallResidentialZone());
                Cell cell134 = row.createCell(34);
                cell134.setCellValue(list.get(i).getIncomingCallAcceptPrice());
                Cell cell135 = row.createCell(35);
                cell135.setCellValue(list.get(i).getIncomingCallVisitTime());
                Cell cell136 = row.createCell(36);
                cell136.setCellValue(list.get(i).getIncomingCallCustomerSituation());
                Cell cell137 = row.createCell(37);
                cell137.setCellValue(list.get(i).getIncomingCallDealTime());
                Cell cell138 = row.createCell(38);
                cell138.setCellValue(list.get(i).getIncomingCallDealBuilding());
                Cell cell139 = row.createCell(39);
                cell139.setCellValue(list.get(i).getIncomingCallDealRoomnum());
                Cell cell140 = row.createCell(40);
                cell140.setCellValue(list.get(i).getIncomingCallSalesman());
                Cell cell141 = row.createCell(41);
                String time4 = String.valueOf(list.get(i).getVisitVisitTime());
                if(time4.length()>0) {
                    time4 = time4.substring(0, 4) + "/" + time4.substring(4, 6) + "/" + time4.substring(6);
                }
                cell141.setCellValue(time4);
                Cell cell142 = row.createCell(42);
                cell142.setCellValue(list.get(i).getVisitIntentionalArea());
                Cell cell143 = row.createCell(43);
                cell143.setCellValue(list.get(i).getVisitAcceptPrice());
                Cell cell144 = row.createCell(44);
                cell144.setCellValue(list.get(i).getVisitResidentialZone());
                Cell cell145 = row.createCell(45);
                cell145.setCellValue(list.get(i).getVisitRealtyPurpose());
                Cell cell146 = row.createCell(46);
                cell146.setCellValue(list.get(i).getVisitCustomerType());
                Cell cell147 = row.createCell(47);
                cell147.setCellValue(list.get(i).getVisitRealtyConsultant());
                Cell cell148 = row.createCell(48);
                cell148.setCellValue(list.get(i).getVisitDealTime());
                Cell cell149 = row.createCell(49);
                cell149.setCellValue(list.get(i).getVisitDealRoomnum());
                Cell cell150 = row.createCell(50);
                String time5 = String.valueOf(list.get(i).getDealSubscriptionTime());
                if(time5.length()>0) {
                    time5 = time5.substring(0, 4) + "/" + time5.substring(4, 6) + "/" + time5.substring(6);
                }
                cell150.setCellValue(time5);
                Cell cell151 = row.createCell(51);
                cell151.setCellValue(list.get(i).getDealAccessKnown());
                Cell cell152 = row.createCell(52);
                cell152.setCellValue(list.get(i).getDealReferee());
                Cell cell153 = row.createCell(53);
                cell153.setCellValue(list.get(i).getDealRefereeTel());
            }
        }
        OutputStream stream = new FileOutputStream(excelPath);
        workbook.write(stream);
        stream.close();

    }
}
