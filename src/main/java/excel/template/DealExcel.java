package excel.template;

import model.Deal;
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

public class DealExcel {
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
        sheet = (Sheet) workbook.createSheet("成交");
        OutputStream outputStream = new FileOutputStream(excelPath);
        workbook.write(outputStream);
        outputStream.flush();
        outputStream.close();
        Row row0 = sheet.createRow(0);

        Cell cell1 = row0.createCell(0);
        cell1.setCellValue("序号");
        Cell cell2 = row0.createCell(1);
        cell2.setCellValue("认购日期");
        Cell cell3 = row0.createCell(2);
        cell3.setCellValue("认筹日期");
        Cell cell4 = row0.createCell(3);
        cell4.setCellValue("物业类型");
        Cell cell5 = row0.createCell(4);
        cell5.setCellValue("地块");
        Cell cell6 = row0.createCell(5);
        cell6.setCellValue("是否精装");
        Cell cell7 = row0.createCell(6);
        cell7.setCellValue("栋号");
        Cell cell8 = row0.createCell(7);
        cell8.setCellValue("房号");
        Cell cell9 = row0.createCell(8);
        cell9.setCellValue("客户姓名");
        Cell cell10 = row0.createCell(9);
        cell10.setCellValue("微信号");
        Cell cell11 = row0.createCell(10);
        cell11.setCellValue("联系方式");
        Cell cell12 = row0.createCell(11);
        cell12.setCellValue("预测面积");
        Cell cell13 = row0.createCell(12);
        cell13.setCellValue("认购单价");
        Cell cell14 = row0.createCell(13);
        cell14.setCellValue("认购总价");
        Cell cell15 = row0.createCell(14);
        cell15.setCellValue("折扣说明");
        Cell cell16 = row0.createCell(15);
        cell16.setCellValue("5万抵15万");
        Cell cell17 = row0.createCell(16);
        cell17.setCellValue("折后15W价格");
        Cell cell18 = row0.createCell(17);
        cell18.setCellValue("开盘折扣");
        Cell cell19 = row0.createCell(18);
        cell19.setCellValue("按时签约折扣");
        Cell cell20 = row0.createCell(19);
        cell20.setCellValue("实际成交单价");
        Cell cell21 = row0.createCell(20);
        cell21.setCellValue("成交总价公示输入");
        Cell cell22 = row0.createCell(21);
        cell22.setCellValue("成交总价手工复核");
        Cell cell23 = row0.createCell(22);
        cell23.setCellValue("付款金额1");
        Cell cell24 = row0.createCell(23);
        cell24.setCellValue("付款日期1");
        Cell cell25 = row0.createCell(24);
        cell25.setCellValue("付款金额2");
        Cell cell26 = row0.createCell(25);
        cell26.setCellValue("付款日期2");
        Cell cell27 = row0.createCell(26);
        cell27.setCellValue("付款金额3");
        Cell cell28 = row0.createCell(27);
        cell28.setCellValue("付款日期3");
        Cell cell29 = row0.createCell(28);
        cell29.setCellValue("约定签约日期");
        Cell cell30 = row0.createCell(29);
        cell30.setCellValue("认购未签约情况");
        Cell cell31 = row0.createCell(30);
        cell31.setCellValue("实际签约日期");
        Cell cell32 = row0.createCell(31);
        cell32.setCellValue("贷款金额");
        Cell cell33 = row0.createCell(32);
        cell33.setCellValue("办理贷款日期");
        Cell cell34 = row0.createCell(33);
        cell34.setCellValue("贷款银行");
        Cell cell35 = row0.createCell(34);
        cell35.setCellValue("付款方式");
        Cell cell36 = row0.createCell(35);
        cell36.setCellValue("到款比例");
        Cell cell37 = row0.createCell(36);
        cell37.setCellValue("累积到款");
        Cell cell38 = row0.createCell(37);
        cell38.setCellValue("未到款金额");
        Cell cell39 = row0.createCell(38);
        cell39.setCellValue("清款日期");
        Cell cell40 = row0.createCell(39);
        cell40.setCellValue("按揭进度情况");
        Cell cell41 = row0.createCell(40);
        cell41.setCellValue("销售公司");
        Cell cell42 = row0.createCell(41);
        cell42.setCellValue("员工提点");
        Cell cell43 = row0.createCell(42);
        cell43.setCellValue("置业顾问佣金");
        Cell cell44 = row0.createCell(43);
        cell44.setCellValue("置业顾问");
        Cell cell45 = row0.createCell(44);
        cell45.setCellValue("现对接人");
        Cell cell46 = row0.createCell(45);
        cell46.setCellValue("合同鉴证日期");
        Cell cell47 = row0.createCell(46);
        cell47.setCellValue("家庭住址");
        Cell cell48 = row0.createCell(47);
        cell48.setCellValue("身份证号码");
        Cell cell49 = row0.createCell(48);
        cell49.setCellValue("年龄");
        Cell cell50 = row0.createCell(49);
        cell50.setCellValue("居住区域");
        Cell cell51 = row0.createCell(50);
        cell51.setCellValue("工作区域");
        Cell cell52 = row0.createCell(51);
        cell52.setCellValue("职业");
        Cell cell53 = row0.createCell(52);
        cell53.setCellValue("获知途径");
        Cell cell54 = row0.createCell(53);
        cell54.setCellValue("推荐人");
        Cell cell55 = row0.createCell(54);
        cell55.setCellValue("推荐人联系电话");
        Cell cell56 = row0.createCell(55);
        cell56.setCellValue("置业目的");
        Cell cell57 = row0.createCell(56);
        cell57.setCellValue("置业次数");
        Cell cell58 = row0.createCell(57);
        cell58.setCellValue("佣金结算单递交时间");
        Cell cell59 = row0.createCell(58);
        cell59.setCellValue("佣金发放时间");
        Cell cell60 = row0.createCell(59);
        cell60.setCellValue("佣金结算比例");
        Cell cell61 = row0.createCell(60);
        cell61.setCellValue("结佣提点");
        Cell cell62 = row0.createCell(61);
        cell62.setCellValue("结佣金额");
        Cell cell63 = row0.createCell(62);
        cell63.setCellValue("佣金结算单递交时间二");
        Cell cell64 = row0.createCell(63);
        cell64.setCellValue("佣金发放时间二");
        Cell cell65 = row0.createCell(64);
        cell65.setCellValue("佣金结算比例二");
        Cell cell66 = row0.createCell(65);
        cell66.setCellValue("保证金");
        Cell cell67 = row0.createCell(66);
        cell67.setCellValue("预计交付时间");
        Cell cell68 = row0.createCell(67);
        cell68.setCellValue("是否签购房合同");
        Cell cell69 = row0.createCell(68);
        cell69.setCellValue("是否签物业合同");
        Cell cell70 = row0.createCell(69);
        cell70.setCellValue("中介交款金额");
        Cell cell71 = row0.createCell(70);
        cell71.setCellValue("老带新(积分)");
        Cell cell72 = row0.createCell(71);
        cell72.setCellValue("客户权属");
        Cell cell73 = row0.createCell(72);
        cell73.setCellValue("能来签约时间");
        Cell cell74 = row0.createCell(73);
        cell74.setCellValue("按揭办理");
        Cell cell75 = row0.createCell(74);
        cell75.setCellValue("备注");


        if(String.valueOf(condition.get("response")).equals("RESPONSE_OK")){
            List<Deal> list = (List<Deal>) condition.get("data");
            for(int i=0;i<list.size();i++){
                Row row = sheet.createRow(i+1);
                Cell cell = row.createCell(0);
                cell.setCellValue(i+1);
                Cell cella = row.createCell(1);
                String time = String.valueOf(list.get(i).getSubscriptionTime());
                time = time.substring(0,4)+"/"+time.substring(4,6)+"/"+time.substring(6);
                cella.setCellValue(time);
                Cell cell102 = row.createCell(2);
                cell102.setCellValue(list.get(i).getRecognitionTime());
                Cell cell103 = row.createCell(3);
                cell103.setCellValue(list.get(i).getPropertyType());
                Cell cell104 = row.createCell(4);
                cell104.setCellValue(list.get(i).getDealSection());
                Cell cell105 = row.createCell(5);
                cell105.setCellValue(list.get(i).getDecoration());
                Cell cell106 = row.createCell(6);
                cell106.setCellValue(list.get(i).getBuildingId());
                Cell cell107 = row.createCell(7);
                cell107.setCellValue(list.get(i).getRoomNum());
                Cell cell108 = row.createCell(8);
                cell108.setCellValue(list.get(i).getCustomerName());
                Cell cell109 = row.createCell(9);
                cell109.setCellValue(list.get(i).getWechatId());
                Cell cell110 = row.createCell(10);
                cell110.setCellValue(list.get(i).getCustomerTel());
                Cell cell111 = row.createCell(11);
                cell111.setCellValue(list.get(i).getPredictedArea());
                Cell cell112 = row.createCell(12);
                cell112.setCellValue(list.get(i).getSubscriptionUnitPrice());
                Cell cell113 = row.createCell(13);
                cell113.setCellValue(list.get(i).getSubscriptionTotalPrice());
                Cell cell114 = row.createCell(14);
                cell114.setCellValue(list.get(i).getDiscountDetail());
                Cell cell115 = row.createCell(15);
                cell115.setCellValue(list.get(i).getFiveToFifteen());
                Cell cell116 = row.createCell(16);
                cell116.setCellValue(list.get(i).getFifteenAfterDiscount());
                Cell cell117 = row.createCell(17);
                cell117.setCellValue(list.get(i).getOpeningQuotationDiscount());
                Cell cell118 = row.createCell(18);
                cell118.setCellValue(list.get(i).getDiscountOfContractOntime());
                Cell cell119 = row.createCell(19);
                cell119.setCellValue(list.get(i).getActualDealUnitPrice());
                Cell cell120 = row.createCell(20);
                cell120.setCellValue(list.get(i).getDealTotalPriceInput());
                Cell cell121 = row.createCell(21);
                cell121.setCellValue(list.get(i).getDealTotalPriceCheck());
                Cell cell122 = row.createCell(22);
                cell122.setCellValue(list.get(i).getAmountOfPaymentFirst());
                Cell cell123 = row.createCell(23);
                cell123.setCellValue(list.get(i).getDateOfPaymentFirst());
                Cell cell124 = row.createCell(24);
                cell124.setCellValue(list.get(i).getAmountOfPaymentSecond());
                Cell cell125 = row.createCell(25);
                cell125.setCellValue(list.get(i).getDateOfPaymentSecond());
                Cell cell126 = row.createCell(26);
                cell126.setCellValue(list.get(i).getAmountOfPaymentThird());
                Cell cell127 = row.createCell(27);
                cell127.setCellValue(list.get(i).getDateOfPaymentThird());
                Cell cell128 = row.createCell(28);
                cell128.setCellValue(list.get(i).getArrangeContractDate());
                Cell cell129 = row.createCell(29);
                cell129.setCellValue(list.get(i).getSubscriptionWithoutContract());
                Cell cell130 = row.createCell(30);
                cell130.setCellValue(list.get(i).getActualContractDate());
                Cell cell131 = row.createCell(31);
                cell131.setCellValue(list.get(i).getLoanAmount());
                Cell cell132 = row.createCell(32);
                cell132.setCellValue(list.get(i).getTransactLoanDate());
                Cell cell133 = row.createCell(33);
                cell133.setCellValue(list.get(i).getLoanBank());
                Cell cell134 = row.createCell(34);
                cell134.setCellValue(list.get(i).getPaymentMethod());
                Cell cell135 = row.createCell(35);
                cell135.setCellValue(list.get(i).getPaymentRate());
                Cell cell136 = row.createCell(36);
                cell136.setCellValue(list.get(i).getAccumulativePayment());
                Cell cell137 = row.createCell(37);
                cell137.setCellValue(list.get(i).getUnPayment());
                Cell cell138 = row.createCell(38);
                cell138.setCellValue(list.get(i).getCompletePaymentDate());
                Cell cell139 = row.createCell(39);
                cell139.setCellValue(list.get(i).getMortgageSchedule());
                Cell cell140 = row.createCell(40);
                cell140.setCellValue(list.get(i).getSalesCompany());
                Cell cell141 = row.createCell(41);
                cell141.setCellValue(list.get(i).getStaffPercentage());
                Cell cell142 = row.createCell(42);
                cell142.setCellValue(list.get(i).getRealtyConsultantSalary());
                Cell cell143 = row.createCell(43);
                cell143.setCellValue(list.get(i).getRealtyConsultant());
                Cell cell144 = row.createCell(44);
                cell144.setCellValue(list.get(i).getAbutmentPerson());
                Cell cell145 = row.createCell(45);
                cell145.setCellValue(list.get(i).getAgreementAuthenticationDate());
                Cell cell146 = row.createCell(46);
                cell146.setCellValue(list.get(i).getAddress());
                Cell cell147 = row.createCell(47);
                cell147.setCellValue(list.get(i).getCardId());
                Cell cell148 = row.createCell(48);
                cell148.setCellValue(list.get(i).getAge());
                Cell cell149 = row.createCell(49);
                cell149.setCellValue(list.get(i).getResidentialZone());
                Cell cell150 = row.createCell(50);
                cell150.setCellValue(list.get(i).getWorkZone());
                Cell cell151 = row.createCell(51);
                cell151.setCellValue(list.get(i).getOccupation());
                Cell cell152 = row.createCell(52);
                cell152.setCellValue(list.get(i).getAccessKnown());
                Cell cell153 = row.createCell(53);
                cell153.setCellValue(list.get(i).getReferee());
                Cell cell154 = row.createCell(54);
                cell154.setCellValue(list.get(i).getRefereeTel());
                Cell cell155 = row.createCell(55);
                cell155.setCellValue(list.get(i).getRealtyPurpose());
                Cell cell156 = row.createCell(56);
                cell156.setCellValue(list.get(i).getRealtyTimes());
                Cell cell157 = row.createCell(57);
                cell157.setCellValue(list.get(i).getSalarySettlementSubmitTime());
                Cell cell158 = row.createCell(58);
                cell158.setCellValue(list.get(i).getSalaryGrantTime());
                Cell cell159 = row.createCell(59);
                cell159.setCellValue(list.get(i).getSalarySettlementRate());
                Cell cell160 = row.createCell(60);
                cell160.setCellValue(list.get(i).getSettleSalaryRate());
                Cell cell161 = row.createCell(61);
                cell161.setCellValue(list.get(i).getSettleSalaryMoney());
                Cell cell162 = row.createCell(62);
                cell162.setCellValue(list.get(i).getSalarySettlementSubmitTimeSecond());
                Cell cell163 = row.createCell(63);
                cell163.setCellValue(list.get(i).getSalaryGrantTimeSecond());
                Cell cell164 = row.createCell(64);
                cell164.setCellValue(list.get(i).getSalarySettlementRateSecond());
                Cell cell165 = row.createCell(65);
                cell165.setCellValue(list.get(i).getDeposit());
                Cell cell166 = row.createCell(66);
                cell166.setCellValue(list.get(i).getPredictedDeliverTime());
                Cell cell167 = row.createCell(67);
                cell167.setCellValue(list.get(i).getSignPurchaseContract());
                Cell cell168 = row.createCell(68);
                cell168.setCellValue(list.get(i).getSignPropertyContract());
                Cell cell169 = row.createCell(69);
                cell169.setCellValue(list.get(i).getIntermediaryMoney());
                Cell cell170 = row.createCell(70);
                cell170.setCellValue(list.get(i).getOldToNew());
                Cell cell171 = row.createCell(71);
                cell171.setCellValue(list.get(i).getCustomerOwnership());
                Cell cell172 = row.createCell(72);
                cell172.setCellValue(list.get(i).getAvailableSignTime());
                Cell cell173 = row.createCell(73);
                cell173.setCellValue(list.get(i).getMortgageHandle());
                Cell cell174 = row.createCell(74);
                cell174.setCellValue(list.get(i).getRemark());
            }
        }
        OutputStream stream = new FileOutputStream(excelPath);
        workbook.write(stream);
        stream.close();

    }
}
