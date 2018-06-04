package auxiliary;

public class test {

    public static void main(String[] args){
         // getVo("private String dealId;private String subscriptionTime;private String recognitionTime;private String propertyType;private String dealSection;private String decoration;private String buildingId;private String roomNum;private String customerName;private String wechatId;private String customerTel;private String predictedArea;private String subscriptionUnitPrice;private String subscriptionTotalPrice;private String discountDetail;private String fiveToFifteen;private String fifteenAfterDiscount;private String openingQuotationDiscount;private String discountOfContractOntime;private String actualDealUnitPrice;private String dealTotalPriceInput;private String dealTotalPriceCheck;private String amountOfPaymentFirst;private String dateOfPaymentFirst;private String amountOfPaymentSecond;private String dateOfPaymentSecond;private String amountOfPaymentThird;private String dateOfPaymentThird;private String arrangeContractDate;private String subscriptionWithoutContract;private String actualContractDate;private String loanAmount;private String transactLoanDate;private String loanBank;private String paymentMethod;private String paymentRate;private String accumulativePayment;private String unPayment;private String completePaymentDate;private String mortgageSchedule;private String salesCompany;private String staffPercentage;private String realtyConsultantSalary;private String realtyConsultant;private String abutmentPerson;private String agreementAuthenticationDate;private String address;private String cardId;private String age;private String residentialZone;private String workZone;private String occupation;private String accessKnown;private String referee;private String refereeTel;private String realtyPurpose;private String realtyTimes;private String salarySettlementSubmitTime;private String salaryGrantTime;private String salarySettlementRate;private String settleSalaryRate;private String settleSalaryMoney;private String salarySettlementSubmitTimeSecond;private String salaryGrantTimeSecond;private String salarySettlementRateSecond;private String deposit;private String predictedDeliverTime;private String signPurchaseContract;private String signPropertyContract;private String intermediaryMoney;private String oldToNew;private String customerOwnership;private String availableSignTime;private String mortgageHandle;private String remark;");
        String temp = "{Header: '客户姓名', accessor : 'customerName'},\n" +
                "                {Header: '联系方式', accessor : 'customerTel'},\n" +
                "                {Header: '中介-报备日期', accessor : 'intermediaryReportTime'},\n" +
                "                {Header: '中介-报备楼盘', accessor : 'intermediaryReportBuilding'},\n" +
                "                {Header: '中介-意向等级', accessor : 'intermediaryIntentionLevel'},\n" +
                "                {Header: '中介-到访时间', accessor : 'intermediaryVisitTime'},\n" +
                "                {Header: '中介-到访楼盘', accessor : 'intermediaryVisitBuilding'},\n" +
                "                {Header: '中介-客户情况', accessor : 'intermediaryCustomerSituation'},\n" +
                "                {Header: '中介-成交日期', accessor : 'intermediaryDealTime'},\n" +
                "                {Header: '中介-成交楼盘', accessor : 'intermediaryDealBuilding'},\n" +
                "                {Header: '中介-成交房号', accessor : 'intermediaryDealRoomnum'},\n" +
                "                {Header: 'CALL客-区域', accessor : 'callCustomerDatasourceArea'},\n" +
                "                {Header: 'CALL客-楼盘名称', accessor : 'callCustomerDatasourceBuilding'},\n" +
                "                {Header: 'CALL客-call客日期', accessor : 'callCustomerCallTime'},\n" +
                "                {Header: 'CALL客-call客人员', accessor : 'callCustomerCallSalesman'},\n" +
                "                {Header: 'CALL客-意向等级', accessor : 'callCustomerIntentionLevel'},\n" +
                "                {Header: 'CALL客-意向楼盘', accessor : 'callCustomerIntentionBuilding'},\n" +
                "                {Header: 'CALL客-转访时间', accessor : 'callCustomerVisitTime'},\n" +
                "                {Header: 'CALL客-转访楼盘', accessor : 'callCustomerVisitBuilding'},\n" +
                "                {Header: 'CALL客-客户情况', accessor : 'callCustomerCustomerSituation'},\n" +
                "                {Header: 'CALL客-成交日期', accessor : 'callCustomerDealTime'},\n" +
                "                {Header: '外拓-日期', accessor : 'extensionExtensionTime'},\n" +
                "                {Header: '外拓-置业顾问', accessor : 'extensionRealtyConsultant'},\n" +
                "                {Header: '外拓-转访日期', accessor : 'extensionVisitTime'},\n" +
                "                {Header: '外拓-客户情况', accessor : 'extensionCustomerSituation'},\n" +
                "                {Header: '外拓-成交日期', accessor : 'extensionDealTime'},\n" +
                "                {Header: '外拓-成交楼盘', accessor : 'extensionDealBuilding'},\n" +
                "                {Header: '外拓-成交房号', accessor : 'extensionDealRoomnum'},\n" +
                "                {Header: '来电-来电日期', accessor : 'incomingCallCallTime'},\n" +
                "                {Header: '来电-置业目的', accessor : 'incomingCallRealtyPurpose'},\n" +
                "                {Header: '来电-需求面积', accessor : 'incomingCallDemandArea'},\n" +
                "                {Header: '来电-户型', accessor : 'incomingCallHouseType'},\n" +
                "                {Header: '来电-居住区域', accessor : 'incomingCallResidentialZone'},\n" +
                "                {Header: '来电-接受价位', accessor : 'incomingCallAcceptPrice'},\n" +
                "                {Header: '来电-转访日期', accessor : 'incomingCallVisitTime'},\n" +
                "                {Header: '来电-客户情况', accessor : 'incomingCallCustomerSituation'},\n" +
                "                {Header: '来电-成交日期', accessor : 'incomingCallDealTime'},\n" +
                "                {Header: '来电-成交楼盘', accessor : 'incomingCallDealBuilding'},\n" +
                "                {Header: '来电-成交房号', accessor : 'incomingCallDealRoomnum'},\n" +
                "                {Header: '来电-销售员', accessor : 'incomingCallSalesman'},\n" +
                "                {Header: '来访-来访日期', accessor : 'visitVisitTime'},\n" +
                "                {Header: '来访-意向面积', accessor : 'visitIntentionalArea'},\n" +
                "                {Header: '来访-接受价位', accessor : 'visitAcceptPrice'},\n" +
                "                {Header: '来访-居住区域', accessor : 'visitResidentialZone'},\n" +
                "                {Header: '来访-置业目的', accessor : 'visitRealtyPurpose'},\n" +
                "                {Header: '来访-客户类别', accessor : 'visitCustomerType'},\n" +
                "                {Header: '来访-置业顾问', accessor : 'visitRealtyConsultant'},\n" +
                "                {Header: '来访-成交日期', accessor : 'visitDealTime'},\n" +
                "                {Header: '来访-成交房号', accessor : 'visitDealRoomnum'},\n" +
                "                {Header: '成交-认购日期', accessor : 'dealSubscriptionTime'},\n" +
                "                {Header: '成交-获知途径', accessor : 'dealAccessKnown'},\n" +
                "                {Header: '成交-推荐人', accessor : 'dealReferee'},\n" +
                "                {Header: '成交-推荐人联系电话', accessor : 'dealRefereeTel'},";
        String[] result = temp.replace("\n", "").split("Header");
        for(int i=1;i<result.length;i++){
            //result[i] = result[i].substring(3, result[i].indexOf("',"));
            result[i] = result[i].substring(result[i].indexOf("r : '")+5, result[i].indexOf("'}"));
            test_7(result[i], i);
        }
        /*for(int i=2;i<55;i++){
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
