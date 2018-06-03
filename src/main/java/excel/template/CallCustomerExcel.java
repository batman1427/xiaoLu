package excel.template;

import model.CallCustomer;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

public class CallCustomerExcel {
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
        sheet = (Sheet) workbook.createSheet("CALL客表");
        OutputStream outputStream = new FileOutputStream(excelPath);
        workbook.write(outputStream);
        outputStream.flush();
        outputStream.close();
        Row row0 = sheet.createRow(0);
        Row row1 = sheet.createRow(1);
        sheet.addMergedRegion(new CellRangeAddress(0, 1, 0, 0));
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 1, 3));
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 9, 10));
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 11, 12));
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 14, 16));
        sheet.addMergedRegion(new CellRangeAddress(0, 1, 4, 4));
        sheet.addMergedRegion(new CellRangeAddress(0, 1, 5, 5));
        sheet.addMergedRegion(new CellRangeAddress(0, 1, 6, 6));
        sheet.addMergedRegion(new CellRangeAddress(0, 1, 7, 7));
        sheet.addMergedRegion(new CellRangeAddress(0, 1, 8, 8));
        sheet.addMergedRegion(new CellRangeAddress(0, 1, 17, 17));

        Cell cell1 = row0.createCell(0);
        cell1.setCellValue("序号");
        Cell cell2 = row0.createCell(1);
        cell2.setCellValue("数据来源");
        Cell cell3 = row0.createCell(4);
        cell3.setCellValue("客户姓名");
        Cell cell4 = row0.createCell(5);
        cell4.setCellValue("客户电话");
        Cell cell5 = row0.createCell(6);
        cell5.setCellValue("call客日期");
        Cell cell6 = row0.createCell(7);
        cell6.setCellValue("call客人员");
        Cell cell7 = row0.createCell(8);
        cell7.setCellValue("反馈情况");
        Cell cell8 = row0.createCell(9);
        cell8.setCellValue("意向登记");
        Cell cell9 = row0.createCell(11);
        cell9.setCellValue("转访");
        Cell cell10 = row0.createCell(13);
        cell10.setCellValue("客户情况");
        Cell cell11 = row0.createCell(14);
        cell11.setCellValue("成交");
        Cell cell12 = row0.createCell(17);
        cell12.setCellValue("备注");
        Cell cell13 = row1.createCell(1);
        cell13.setCellValue("区域");
        Cell cell14 = row1.createCell(2);
        cell14.setCellValue("楼盘名称");
        Cell cell15 = row1.createCell(3);
        cell15.setCellValue("来电-来访-业主");
        Cell cell16 = row1.createCell(9);
        cell16.setCellValue("意向等级(abc)");
        Cell cell17 = row1.createCell(10);
        cell17.setCellValue("意向楼盘");
        Cell cell18 = row1.createCell(11);
        cell18.setCellValue("转访时间");
        Cell cell19 = row1.createCell(12);
        cell19.setCellValue("转访楼盘");
        Cell cell20 = row1.createCell(13);
        cell20.setCellValue("验资、认筹、认购");
        Cell cell21 = row1.createCell(14);
        cell21.setCellValue("成交日期");
        Cell cell22 = row1.createCell(15);
        cell22.setCellValue("成交楼盘");
        Cell cell23 = row1.createCell(16);
        cell23.setCellValue("成交房号");

        if(String.valueOf(condition.get("response")).equals("RESPONSE_OK")){
            List<CallCustomer> list = (List<CallCustomer>) condition.get("data");
            for(int i=0;i<list.size();i++){
                Row row = sheet.createRow(i+2);
                Cell cell = row.createCell(0);
                cell.setCellValue(i+1);
                Cell cella = row.createCell(1);
                cella.setCellValue(list.get(i).getDatasourceArea());
                Cell cellb = row.createCell(2);
                cellb.setCellValue(list.get(i).getDatasourceBuilding());
                Cell cellc = row.createCell(3);
                cellc.setCellValue(list.get(i).getDatasourceType());
                Cell celld = row.createCell(4);
                celld.setCellValue(list.get(i).getCustomerName());
                Cell celle = row.createCell(5);
                celle.setCellValue(list.get(i).getCustomerTel());
                Cell cellf = row.createCell(6);
                String time = String.valueOf(list.get(i).getCallTime());
                time = time.substring(0,4)+"/"+time.substring(4,6)+"/"+time.substring(6);
                cellf.setCellValue(time);
                Cell cellg = row.createCell(7);
                cellg.setCellValue(list.get(i).getCallSalesman());
                Cell cellh = row.createCell(8);
                cellh.setCellValue(list.get(i).getFeedback());
                Cell celli = row.createCell(9);
                celli.setCellValue(list.get(i).getIntentionLevel());
                Cell cellj = row.createCell(10);
                cellj.setCellValue(list.get(i).getIntentionBuilding());
                Cell cellk = row.createCell(11);
                cellk.setCellValue(list.get(i).getVisitTime());
                Cell celll = row.createCell(12);
                celll.setCellValue(list.get(i).getVisitBuilding());
                Cell cellm = row.createCell(13);
                cellm.setCellValue(list.get(i).getCustomerSituation());
                Cell celln = row.createCell(14);
                celln.setCellValue(list.get(i).getDealTime());
                Cell cello = row.createCell(15);
                cello.setCellValue(list.get(i).getDealBuilding());
                Cell cellp = row.createCell(16);
                cellp.setCellValue(list.get(i).getDealRoomnum());
                Cell cellq = row.createCell(17);
                cellq.setCellValue(list.get(i).getRemark());
            }
        }
        OutputStream stream = new FileOutputStream(excelPath);
        workbook.write(stream);
        stream.close();

    }}
