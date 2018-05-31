package auxiliary;

public class test {

    public static void main(String[] args){
          getVo("private String dealId;private String subscriptionTime;private String recognitionTime;private String propertyType;private String dealSection;private String decoration;private String buildingId;private String roomNum;private String customerName;private String wechatId;private String customerTel;private String predictedArea;private String subscriptionUnitPrice;private String subscriptionTotalPrice;private String discountDetail;private String fiveToFifteen;private String fifteenAfterDiscount;private String openingQuotationDiscount;private String discountOfContractOntime;private String actualDealUnitPrice;private String dealTotalPriceInput;private String dealTotalPriceCheck;private String amountOfPaymentFirst;private String dateOfPaymentFirst;private String amountOfPaymentSecond;private String dateOfPaymentSecond;private String amountOfPaymentThird;private String dateOfPaymentThird;private String arrangeContractDate;private String subscriptionWithoutContract;private String actualContractDate;private String loanAmount;private String transactLoanDate;private String loanBank;private String paymentMethod;private String paymentRate;private String accumulativePayment;private String unPayment;private String completePaymentDate;private String mortgageSchedule;private String salesCompany;private String staffPercentage;private String realtyConsultantSalary;private String realtyConsultant;private String abutmentPerson;private String agreementAuthenticationDate;private String address;private String cardId;private String age;private String residentialZone;private String workZone;private String occupation;private String accessKnown;private String referee;private String refereeTel;private String realtyPurpose;private String realtyTimes;private String salarySettlementSubmitTime;private String salaryGrantTime;private String salarySettlementRate;private String settleSalaryRate;private String settleSalaryMoney;private String salarySettlementSubmitTimeSecond;private String salaryGrantTimeSecond;private String salarySettlementRateSecond;private String deposit;private String predictedDeliverTime;private String signPurchaseContract;private String signPropertyContract;private String intermediaryMoney;private String oldToNew;private String customerOwnership;private String availableSignTime;private String mortgageHandle;private String remark;");
    }

    public static void getVo(String str){
        String[] result = str.split(";");
        for(int i=0; i<result.length;i++){
            result[i] = result[i].substring(15);
            test_3(result[i]);
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
        System.out.print(str+", ");
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
}
