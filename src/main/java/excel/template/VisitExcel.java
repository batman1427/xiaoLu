package excel.template;

import model.Visit;
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

public class VisitExcel {
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
        sheet = (Sheet) workbook.createSheet("来访");
        OutputStream outputStream = new FileOutputStream(excelPath);
        workbook.write(outputStream);
        outputStream.flush();
        outputStream.close();
        Row row0 = sheet.createRow(0);

        Cell cell1 = row0.createCell(0);
        cell1.setCellValue("来访日期");
        Cell cell2 = row0.createCell(1);
        cell2.setCellValue("姓名");
        Cell cell3 = row0.createCell(2);
        cell3.setCellValue("电话");
        Cell cell4 = row0.createCell(3);
        cell4.setCellValue("来访次数");
        Cell cell5 = row0.createCell(4);
        cell5.setCellValue("意向面积");
        Cell cell6 = row0.createCell(5);
        cell6.setCellValue("接受价位");
        Cell cell7 = row0.createCell(6);
        cell7.setCellValue("置业次数");
        Cell cell8 = row0.createCell(7);
        cell8.setCellValue("年龄");
        Cell cell9 = row0.createCell(8);
        cell9.setCellValue("居住区域");
        Cell cell10 = row0.createCell(9);
        cell10.setCellValue("工作区域");
        Cell cell11 = row0.createCell(10);
        cell11.setCellValue("职业信息");
        Cell cell12 = row0.createCell(11);
        cell12.setCellValue("认知途径");
        Cell cell13 = row0.createCell(12);
        cell13.setCellValue("置业目的");
        Cell cell14 = row0.createCell(13);
        cell14.setCellValue("职业类型");
        Cell cell15 = row0.createCell(14);
        cell15.setCellValue("关注点");
        Cell cell16 = row0.createCell(15);
        cell16.setCellValue("客户描述");
        Cell cell17 = row0.createCell(16);
        cell17.setCellValue("最新动态");
        Cell cell18 = row0.createCell(17);
        cell18.setCellValue("客户类别");
        Cell cell19 = row0.createCell(18);
        cell19.setCellValue("置业顾问");
        Cell cell20 = row0.createCell(19);
        cell20.setCellValue("成交日期");
        Cell cell21 = row0.createCell(20);
        cell21.setCellValue("成交房号");

        if(String.valueOf(condition.get("response")).equals("RESPONSE_OK")){
            List<Visit> list = (List<Visit>) condition.get("data");
            for(int i=0;i<list.size();i++){
                Row row = sheet.createRow(i+1);
                Cell cell = row.createCell(0);
                String time = String.valueOf(list.get(i).getVisitTime());
                time = time.substring(0,4)+"/"+time.substring(4,6)+"/"+time.substring(6);
                cell.setCellValue(time);
                Cell cella = row.createCell(1);
                cella.setCellValue(list.get(i).getCustomerName());
                Cell cellb = row.createCell(2);
                cellb.setCellValue(list.get(i).getCustomerTel());
                Cell cellc = row.createCell(3);
                cellc.setCellValue(list.get(i).getVisitedTimes());
                Cell celld = row.createCell(4);
                celld.setCellValue(list.get(i).getIntentionalArea());
                Cell celle = row.createCell(5);
                celle.setCellValue(list.get(i).getAcceptPrice());
                Cell cellf = row.createCell(6);
                cellf.setCellValue(list.get(i).getRealtyTimes());
                Cell cellg = row.createCell(7);
                cellg.setCellValue(list.get(i).getAge());
                Cell cellh = row.createCell(8);
                cellh.setCellValue(list.get(i).getResidentialZone());
                Cell celli = row.createCell(9);
                celli.setCellValue(list.get(i).getWorkZone());
                Cell cellj = row.createCell(10);
                cellj.setCellValue(list.get(i).getOccupation());
                Cell cellk = row.createCell(11);
                cellk.setCellValue(list.get(i).getAccessKnown());
                Cell celll = row.createCell(12);
                celll.setCellValue(list.get(i).getRealtyPurpose());
                Cell cellm = row.createCell(13);
                cellm.setCellValue(list.get(i).getRealtyType());
                Cell celln = row.createCell(14);
                celln.setCellValue(list.get(i).getConcerns());
                Cell cello = row.createCell(15);
                cello.setCellValue(list.get(i).getCustomerDescription());
                Cell cellp = row.createCell(16);
                cellp.setCellValue(list.get(i).getLatestState());
                Cell cellq = row.createCell(17);
                cellq.setCellValue(list.get(i).getCustomerType());
                Cell cellr = row.createCell(18);
                cellr.setCellValue(list.get(i).getRealtyConsultant());
                Cell cells = row.createCell(19);
                cells.setCellValue(list.get(i).getDealTime());
                Cell cellt = row.createCell(20);
                cellt.setCellValue(list.get(i).getDealRoomnum());

            }
        }
        OutputStream stream = new FileOutputStream(excelPath);
        workbook.write(stream);
        stream.close();

    }
}
