package auxiliary;

public class test {

    public static void main(String[] args){
         // getVo("private String dealId;private String subscriptionTime;private String recognitionTime;private String propertyType;private String dealSection;private String decoration;private String buildingId;private String roomNum;private String customerName;private String wechatId;private String customerTel;private String predictedArea;private String subscriptionUnitPrice;private String subscriptionTotalPrice;private String discountDetail;private String fiveToFifteen;private String fifteenAfterDiscount;private String openingQuotationDiscount;private String discountOfContractOntime;private String actualDealUnitPrice;private String dealTotalPriceInput;private String dealTotalPriceCheck;private String amountOfPaymentFirst;private String dateOfPaymentFirst;private String amountOfPaymentSecond;private String dateOfPaymentSecond;private String amountOfPaymentThird;private String dateOfPaymentThird;private String arrangeContractDate;private String subscriptionWithoutContract;private String actualContractDate;private String loanAmount;private String transactLoanDate;private String loanBank;private String paymentMethod;private String paymentRate;private String accumulativePayment;private String unPayment;private String completePaymentDate;private String mortgageSchedule;private String salesCompany;private String staffPercentage;private String realtyConsultantSalary;private String realtyConsultant;private String abutmentPerson;private String agreementAuthenticationDate;private String address;private String cardId;private String age;private String residentialZone;private String workZone;private String occupation;private String accessKnown;private String referee;private String refereeTel;private String realtyPurpose;private String realtyTimes;private String salarySettlementSubmitTime;private String salaryGrantTime;private String salarySettlementRate;private String settleSalaryRate;private String settleSalaryMoney;private String salarySettlementSubmitTimeSecond;private String salaryGrantTimeSecond;private String salarySettlementRateSecond;private String deposit;private String predictedDeliverTime;private String signPurchaseContract;private String signPropertyContract;private String intermediaryMoney;private String oldToNew;private String customerOwnership;private String availableSignTime;private String mortgageHandle;private String remark;");
        String temp = "    private String dealSubscriptionTime;\n" +
                "\n" +
                "    private String dealAccessKnown;\n" +
                "\n" +
                "    private String dealReferee;\n" +
                "\n" +
                "    private String dealRefereeTel;\n";
        String[] result = temp.replace("\n", "").split(";");
        for(int i=0;i<result.length;i++){
            //result[i] = result[i].substring(3, result[i].indexOf("',"));
            result[i] = result[i].substring(19);
            test_5(result[i]);
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
            test_5(result[i]);
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
        //System.out.println("`"+test_2(str)+"` VARCHAR(40),");
        //System.out.println(str);
        String a = str.substring(4);
        String b = str.substring(0);
        a = a.substring(0,1).toLowerCase()+a.substring(1);
        //System.out.println("<if test=\""+a+" != null\">");
        //System.out.println("        "+b+" = #{"+a+"},");
        //System.out.println("</if>");
        System.out.println("condition.put(\""+a+"\", "+b+");");
    }

    public static void test_6(String str, int i){
        System.out.println("String "+str+" = row.getCell("+i+") == null ? \"\" : row.getCell("+i+").toString().trim();");
    }

    public static void test_7(String str, int i){
          System.out.println("Cell cell"+(i+100)+" = row.createCell("+(i)+");");
          System.out.println("cell"+(i+100)+".setCellValue(list.get(i).get"+str.substring(0,1).toUpperCase()+str.substring(1)+"());");
    }
}
