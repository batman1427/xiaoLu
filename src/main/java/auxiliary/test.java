package auxiliary;

public class test {

    public static void main(String[] args){
          getVo("private String dealId;private String subscriptionTime;private String recognitionTime;private String propertyType;private String dealSection;private String decoration;private String buildingId;private String roomNum;private String customerName;private String wechatId;private String customerTel;private String predictedArea;private String subscriptionUnitPrice;private String subscriptionTotalPrice;private String discountDetail;private String fiveToFifteen;private String fifteenAfterDiscount;private String openingQuotationDiscount;private String discountOfContractOntime;private String actualDealUnitPrice;private String dealTotalPriceInput;private String dealTotalPriceCheck;private String amountOfPaymentFirst;private String dateOfPaymentFirst;private String amountOfPaymentSecond;private String dateOfPaymentSecond;private String amountOfPaymentThird;private String dateOfPaymentThird;private String arrangeContractDate;private String subscriptionWithoutContract;private String actualContractDate;private String loanAmount;private String transactLoanDate;private String loanBank;private String paymentMethod;private String paymentRate;private String accumulativePayment;private String unPayment;private String completePaymentDate;private String mortgageSchedule;private String salesCompany;private String staffPercentage;private String realtyConsultantSalary;private String realtyConsultant;private String abutmentPerson;private String agreementAuthenticationDate;private String address;private String cardId;private String age;private String residentialZone;private String workZone;private String occupation;private String accessKnown;private String referee;private String refereeTel;private String realtyPurpose;private String realtyTimes;private String salarySettlementSubmitTime;private String salaryGrantTime;private String salarySettlementRate;private String settleSalaryRate;private String settleSalaryMoney;private String salarySettlementSubmitTimeSecond;private String salaryGrantTimeSecond;private String salarySettlementRateSecond;private String deposit;private String predictedDeliverTime;private String signPurchaseContract;private String signPropertyContract;private String intermediaryMoney;private String oldToNew;private String customerOwnership;private String availableSignTime;private String mortgageHandle;private String remark;");
        /*String temp = " {Header: '认购日期', accessor : 'subscriptionTime'},\n" +
                "                {Header: '认筹日期', accessor : 'recognitionTime'},\n" +
                "                {Header: '物业类型', accessor : 'propertyType'},\n" +
                "                {Header: '地块', accessor : 'dealSection'},\n" +
                "                {Header: '是否精装', accessor : 'decoration'},\n" +
                "                {Header: '栋号', accessor : 'buildingId'},\n" +
                "                {Header: '房号', accessor : 'roomNum'},\n" +
                "                {Header: '客户姓名', accessor : 'customerName'},\n" +
                "                {Header: '微信号', accessor : 'wechatId'},\n" +
                "                {Header: '联系方式', accessor : 'customerTel'},\n" +
                "                {Header: '预测面积', accessor : 'predictedArea'},\n" +
                "                {Header: '认购单价', accessor : 'subscriptionUnitPrice'},\n" +
                "                {Header: '认购总价', accessor : 'subscriptionTotalPrice'},\n" +
                "                {Header: '折扣说明', accessor : 'discountDetail'},\n" +
                "                {Header: '5万抵15万', accessor : 'fiveToFifteen'},\n" +
                "                {Header: '折后15W价格', accessor : 'fifteenAfterDiscount'},\n" +
                "                {Header: '开盘折扣', accessor : 'openingQuotationDiscount'},\n" +
                "                {Header: '按时签约折扣', accessor : 'discountOfContractOntime'},\n" +
                "                {Header: '实际成交单价', accessor : 'actualDealUnitPrice'},\n" +
                "                {Header: '成交总价公示输入', accessor : 'dealTotalPriceInput'},\n" +
                "                {Header: '成交总价手工复核', accessor : 'dealTotalPriceCheck'},\n" +
                "                {Header: '付款金额1', accessor : 'amountOfPaymentFirst'},\n" +
                "                {Header: '付款日期1', accessor : 'dateOfPaymentFirst'},\n" +
                "                {Header: '付款金额2', accessor : 'amountOfPaymentSecond'},\n" +
                "                {Header: '付款日期2', accessor : 'dateOfPaymentSecond'},\n" +
                "                {Header: '付款金额3', accessor : 'amountOfPaymentThird'},\n" +
                "                {Header: '付款日期3', accessor : 'dateOfPaymentThird'},\n" +
                "                {Header: '约定签约日期', accessor : 'arrangeContractDate'},\n" +
                "                {Header: '认购未签约情况', accessor : 'subscriptionWithoutContract'},\n" +
                "                {Header: '实际签约日期', accessor : 'actualContractDate'},\n" +
                "                {Header: '贷款金额', accessor : 'loanAmount'},\n" +
                "                {Header: '办理贷款日期', accessor : 'transactLoanDate'},\n" +
                "                {Header: '贷款银行', accessor : 'loanBank'},\n" +
                "                {Header: '付款方式', accessor : 'paymentMethod'},\n" +
                "                {Header: '到款比例', accessor : 'paymentRate'},\n" +
                "                {Header: '累积到款', accessor : 'accumulativePayment'},\n" +
                "                {Header: '未到款金额', accessor : 'unPayment'},\n" +
                "                {Header: '清款日期', accessor : 'completePaymentDate'},\n" +
                "                {Header: '按揭进度情况', accessor : 'mortgageSchedule'},\n" +
                "                {Header: '销售公司', accessor : 'salesCompany'},\n" +
                "                {Header: '员工提点', accessor : 'staffPercentage'},\n" +
                "                {Header: '置业顾问佣金', accessor : 'realtyConsultantSalary'},\n" +
                "                {Header: '置业顾问', accessor : 'realtyConsultant'},\n" +
                "                {Header: '现对接人', accessor : 'abutmentPerson'},\n" +
                "                {Header: '合同鉴证日期', accessor : 'agreementAuthenticationDate'},\n" +
                "                {Header: '家庭住址', accessor : 'address'},\n" +
                "                {Header: '身份证号码', accessor : 'cardId'},\n" +
                "                {Header: '年龄', accessor : 'age'},\n" +
                "                {Header: '居住区域', accessor : 'residentialZone'},\n" +
                "                {Header: '工作区域', accessor : 'workZone'},\n" +
                "                {Header: '职业', accessor : 'occupation'},\n" +
                "                {Header: '获知途径', accessor : 'accessKnown'},\n" +
                "                {Header: '推荐人', accessor : 'referee'},\n" +
                "                {Header: '推荐人联系电话', accessor : 'refereeTel'},\n" +
                "                {Header: '置业目的', accessor : 'realtyPurpose'},\n" +
                "                {Header: '置业次数', accessor : 'realtyTimes'},\n" +
                "                {Header: '佣金结算单递交时间', accessor : 'salarySettlementSubmitTime'},\n" +
                "                {Header: '佣金发放时间', accessor : 'salaryGrantTime'},\n" +
                "                {Header: '佣金结算比例', accessor : 'salarySettlementRate'},\n" +
                "                {Header: '结佣提点', accessor : 'settleSalaryRate'},\n" +
                "                {Header: '结佣金额', accessor : 'settleSalaryMoney'},\n" +
                "                {Header: '佣金结算单递交时间二', accessor : 'salarySettlementSubmitTimeSecond'},\n" +
                "                {Header: '佣金发放时间二', accessor : 'salaryGrantTimeSecond'},\n" +
                "                {Header: '佣金结算比例二', accessor : 'salarySettlementRateSecond'},\n" +
                "                {Header: '保证金', accessor : 'deposit'},\n" +
                "                {Header: '预计交付时间', accessor : 'predictedDeliverTime'},\n" +
                "                {Header: '是否签购房合同', accessor : 'signPurchaseContract'},\n" +
                "                {Header: '是否签物业合同', accessor : 'signPropertyContract'},\n" +
                "                {Header: '中介交款金额', accessor : 'intermediaryMoney'},\n" +
                "                {Header: '老带新(积分)', accessor : 'oldToNew'},\n" +
                "                {Header: '客户权属', accessor : 'customerOwnership'},\n" +
                "                {Header: '能来签约时间', accessor : 'availableSignTime'},\n" +
                "                {Header: '按揭办理', accessor : 'mortgageHandle'},\n" +
                "                {Header: '备注', accessor : 'remark'}";
        String[] result = temp.replace("\n", "").split("Header");
        for(int i=1;i<result.length;i++){
            result[i] = result[i].substring(3, result[i].indexOf("',"));
        }
        for(int i=2;i<76;i++){
            System.out.println("Cell cell"+i+" = row0.createCell("+(i-1)+");");
            System.out.println("cell"+i+".setCellValue(\""+result[i-1]+"\");");
        }*/

    }

    public static void getVo(String str){
        String[] result = str.split(";");
        for(int i=0; i<result.length;i++){
            result[i] = result[i].substring(15);
            test_7(result[i], i);
        }
    }

    public static void test_1(String str){
        System.out.println("<result property=\""+str+"\" column=\""+test_2(str)+"\"></result>");
    }

    public static String test_2(String str){
        String result = "";
        for(int i=0;i<str.length();i++){
            if(str.charAt(i) <97){
                result =result+"_";
                char temp = (char) (str.charAt(i)+32);
                result+= temp;
            }else{
                result+=str.charAt(i);
            }
        }
        return result;
    }

    public static void test_3(String str){
        System.out.print(str+": e."+str+", ");
    }

    public static void test_4(String str){
        System.out.print("#{"+str+"}, ");
    }

    public static void test_5(String str){
        System.out.println("`"+test_2(str)+"` VARCHAR(40),");
    }

    public static void test_6(String str, int i){
        System.out.println("String "+str+" = getCellValueFormula(row.getCell("+i+"), formulaEvaluator);");
    }

    public static void test_7(String str, int i){
          System.out.println("Cell cell"+(i+100)+" = row.createCell("+(i)+");");
          System.out.println("cell"+(i+100)+".setCellValue(list.get(i).get"+str.substring(0,1).toUpperCase()+str.substring(1)+"());");
    }
}
