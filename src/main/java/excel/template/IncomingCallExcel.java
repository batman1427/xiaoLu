package excel.template;

import model.IncomingCall;
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

public class IncomingCallExcel {
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
        sheet = (Sheet) workbook.createSheet("来电");
        OutputStream outputStream = new FileOutputStream(excelPath);
        workbook.write(outputStream);
        outputStream.flush();
        outputStream.close();
        Row row0 = sheet.createRow(0);
        Row row1 = sheet.createRow(1);
        sheet.addMergedRegion(new CellRangeAddress(0, 1, 0, 0));
        sheet.addMergedRegion(new CellRangeAddress(0, 1, 1, 1));
        sheet.addMergedRegion(new CellRangeAddress(0, 1, 2, 2));
        sheet.addMergedRegion(new CellRangeAddress(0, 1, 3, 3));
        sheet.addMergedRegion(new CellRangeAddress(0, 1, 4, 4));
        sheet.addMergedRegion(new CellRangeAddress(0, 1, 5, 5));
        sheet.addMergedRegion(new CellRangeAddress(0, 1, 6, 6));
        sheet.addMergedRegion(new CellRangeAddress(0, 1, 7, 7));
        sheet.addMergedRegion(new CellRangeAddress(0, 1, 8, 8));
        sheet.addMergedRegion(new CellRangeAddress(0, 1, 9, 9));
        sheet.addMergedRegion(new CellRangeAddress(0, 1, 10, 10));
        sheet.addMergedRegion(new CellRangeAddress(0, 1, 11, 11));
        sheet.addMergedRegion(new CellRangeAddress(0, 1, 16, 16));
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 13, 15));

        Cell cell1 = row0.createCell(0);
        cell1.setCellValue("序号");
        Cell cell2 = row0.createCell(1);
        cell2.setCellValue("来电日期");
        Cell cell3 = row0.createCell(2);
        cell3.setCellValue("客户姓名");
        Cell cell4 = row0.createCell(3);
        cell4.setCellValue("联系电话");
        Cell cell5 = row0.createCell(4);
        cell5.setCellValue("置业目的");
        Cell cell6 = row0.createCell(5);
        cell6.setCellValue("需求面积");
        Cell cell7 = row0.createCell(6);
        cell7.setCellValue("户型");
        Cell cell8 = row0.createCell(7);
        cell8.setCellValue("居住区域");
        Cell cell9 = row0.createCell(8);
        cell9.setCellValue("接受价位");
        Cell cell10 = row0.createCell(9);
        cell10.setCellValue("获知途径");
        Cell cell11 = row0.createCell(10);
        cell11.setCellValue("咨询内容");
        Cell cell12 = row0.createCell(11);
        cell12.setCellValue("转访日期");
        Cell cell13 = row0.createCell(12);
        cell13.setCellValue("客户情况");
        Cell cell14 = row0.createCell(13);
        cell14.setCellValue("成交情况");
        Cell cell15 = row0.createCell(16);
        cell15.setCellValue("销售员");
        Cell cell16 = row1.createCell(12);
        cell16.setCellValue("验资、认筹、认购");
        Cell cell17 = row1.createCell(13);
        cell17.setCellValue("成交日期");
        Cell cell18 = row1.createCell(14);
        cell18.setCellValue("成交楼盘");
        Cell cell19 = row1.createCell(15);
        cell19.setCellValue("成交房号");

        if(String.valueOf(condition.get("response")).equals("RESPONSE_OK")){
            List<IncomingCall> list = (List<IncomingCall>) condition.get("data");
            for(int i=0;i<list.size();i++){
                Row row = sheet.createRow(i+2);
                Cell cell = row.createCell(0);
                cell.setCellValue(i+1);
                Cell cella = row.createCell(1);
                String time = String.valueOf(list.get(i).getCallTime());
                time = time.substring(0,4)+"/"+time.substring(4,6)+"/"+time.substring(6);
                cella.setCellValue(time);
                Cell cellb = row.createCell(2);
                cellb.setCellValue(list.get(i).getCustomerName());
                Cell cellc = row.createCell(3);
                cellc.setCellValue(list.get(i).getCustomerTel());
                Cell celld = row.createCell(4);
                celld.setCellValue(list.get(i).getRealtyPurpose());
                Cell celle = row.createCell(5);
                celle.setCellValue(list.get(i).getDemandArea());
                Cell cellf = row.createCell(6);
                cellf.setCellValue(list.get(i).getHouseType());
                Cell cellg = row.createCell(7);
                cellg.setCellValue(list.get(i).getResidentialZone());
                Cell cellh = row.createCell(8);
                cellh.setCellValue(list.get(i).getAcceptPrice());
                Cell celli = row.createCell(9);
                celli.setCellValue(list.get(i).getAccessKnown());
                Cell cellj = row.createCell(10);
                cellj.setCellValue(list.get(i).getConsultContent());
                Cell cellk = row.createCell(11);
                cellk.setCellValue(list.get(i).getVisitTime());
                Cell celll = row.createCell(12);
                celll.setCellValue(list.get(i).getCustomerSituation());
                Cell cellm = row.createCell(13);
                cellm.setCellValue(list.get(i).getDealTime());
                Cell celln = row.createCell(14);
                celln.setCellValue(list.get(i).getDealBuilding());
                Cell cello = row.createCell(15);
                cello.setCellValue(list.get(i).getDealRoomnum());
                Cell cellp = row.createCell(16);
                cellp.setCellValue(list.get(i).getSalesman());
            }
        }
        OutputStream stream = new FileOutputStream(excelPath);
        workbook.write(stream);
        stream.close();

    }
}
