package model;

public class Deal extends Entity{

    private String dealId;

    private String subscriptionTime;

    private String recognitionTime;

    private String propertyType;

    private String dealSection;

    private String decoration;

    private String buildingId;

    private String roomNum;

    private String customerName;

    private String wechatId;

    private String customerTel;

    private String predictedArea;

    private String subscriptionUnitPrice;

    private String subscriptionTotalPrice;

    private String discountDetail;

    private String fiveToFifteen;

    private String fifteenAfterDiscount;

    private String openingQuotationDiscount;

    private String discountOfContractOntime;

    private String actualDealUnitPrice;

    private String dealTotalPriceInput;

    private String dealTotalPriceCheck;

    private String amountOfPaymentFirst;

    private String dateOfPaymentFirst;

    private String amountOfPaymentSecond;

    private String dateOfPaymentSecond;

    private String amountOfPaymentThird;

    private String dateOfPaymentThird;

    private String arrangeContractDate;

    private String subscriptionWithoutContract;

    private String actualContractDate;

    private String loanAmount;

    private String transactLoanDate;

    private String loanBank;

    private String paymentMethod;

    private String paymentRate;

    private String accumulativePayment;

    private String unPayment;

    private String completePaymentDate;

    private String mortgageSchedule;

    private String salesCompany;

    private String staffPercentage;

    private String realtyConsultantSalary;

    private String realtyConsultant;

    private String abutmentPerson;

    private String agreementAuthenticationDate;

    private String address;

    private String cardId;

    private String age;

    private String residentialZone;

    private String workZone;

    private String occupation;

    private String accessKnown;

    private String referee;

    private String refereeTel;

    private String realtyPurpose;

    private String realtyTimes;

    private String salarySettlementSubmitTime;

    private String salaryGrantTime;

    private String salarySettlementRate;

    private String settleSalaryRate;

    private String settleSalaryMoney;

    private String salarySettlementSubmitTimeSecond;

    private String salaryGrantTimeSecond;

    private String salarySettlementRateSecond;

    private String deposit;

    private String predictedDeliverTime;

    private String signPurchaseContract;

    private String signPropertyContract;

    private String intermediaryMoney;

    private String oldToNew;

    private String customerOwnership;

    private String availableSignTime;

    private String mortgageHandle;

    private String remark;

    public Deal(){
        super();
    }

    public Deal(String subscriptionTime, String recognitionTime, String propertyType, String dealSection, String decoration, String buildingId, String roomNum, String customerName, String wechatId, String customerTel, String predictedArea, String subscriptionUnitPrice, String subscriptionTotalPrice, String discountDetail, String fiveToFifteen, String fifteenAfterDiscount, String openingQuotationDiscount, String discountOfContractOntime, String actualDealUnitPrice, String dealTotalPriceInput, String dealTotalPriceCheck, String amountOfPaymentFirst, String dateOfPaymentFirst, String amountOfPaymentSecond, String dateOfPaymentSecond, String amountOfPaymentThird, String dateOfPaymentThird, String arrangeContractDate, String subscriptionWithoutContract, String actualContractDate, String loanAmount, String transactLoanDate, String loanBank, String paymentMethod, String paymentRate, String accumulativePayment, String unPayment, String completePaymentDate, String mortgageSchedule, String salesCompany, String staffPercentage, String realtyConsultantSalary, String realtyConsultant, String abutmentPerson, String agreementAuthenticationDate, String address, String cardId, String age, String residentialZone, String workZone, String occupation, String accessKnown, String referee, String refereeTel, String realtyPurpose, String realtyTimes, String salarySettlementSubmitTime, String salaryGrantTime, String salarySettlementRate, String settleSalaryRate, String settleSalaryMoney, String salarySettlementSubmitTimeSecond, String salaryGrantTimeSecond, String salarySettlementRateSecond, String deposit, String predictedDeliverTime, String signPurchaseContract, String signPropertyContract, String intermediaryMoney, String oldToNew, String customerOwnership, String availableSignTime, String mortgageHandle, String remark) {
        this();
        this.subscriptionTime = subscriptionTime;
        this.recognitionTime = recognitionTime;
        this.propertyType = propertyType;
        this.dealSection = dealSection;
        this.decoration = decoration;
        this.buildingId = buildingId;
        this.roomNum = roomNum;
        this.customerName = customerName;
        this.wechatId = wechatId;
        this.customerTel = customerTel;
        this.predictedArea = predictedArea;
        this.subscriptionUnitPrice = subscriptionUnitPrice;
        this.subscriptionTotalPrice = subscriptionTotalPrice;
        this.discountDetail = discountDetail;
        this.fiveToFifteen = fiveToFifteen;
        this.fifteenAfterDiscount = fifteenAfterDiscount;
        this.openingQuotationDiscount = openingQuotationDiscount;
        this.discountOfContractOntime = discountOfContractOntime;
        this.actualDealUnitPrice = actualDealUnitPrice;
        this.dealTotalPriceInput = dealTotalPriceInput;
        this.dealTotalPriceCheck = dealTotalPriceCheck;
        this.amountOfPaymentFirst = amountOfPaymentFirst;
        this.dateOfPaymentFirst = dateOfPaymentFirst;
        this.amountOfPaymentSecond = amountOfPaymentSecond;
        this.dateOfPaymentSecond = dateOfPaymentSecond;
        this.amountOfPaymentThird = amountOfPaymentThird;
        this.dateOfPaymentThird = dateOfPaymentThird;
        this.arrangeContractDate = arrangeContractDate;
        this.subscriptionWithoutContract = subscriptionWithoutContract;
        this.actualContractDate = actualContractDate;
        this.loanAmount = loanAmount;
        this.transactLoanDate = transactLoanDate;
        this.loanBank = loanBank;
        this.paymentMethod = paymentMethod;
        this.paymentRate = paymentRate;
        this.accumulativePayment = accumulativePayment;
        this.unPayment = unPayment;
        this.completePaymentDate = completePaymentDate;
        this.mortgageSchedule = mortgageSchedule;
        this.salesCompany = salesCompany;
        this.staffPercentage = staffPercentage;
        this.realtyConsultantSalary = realtyConsultantSalary;
        this.realtyConsultant = realtyConsultant;
        this.abutmentPerson = abutmentPerson;
        this.agreementAuthenticationDate = agreementAuthenticationDate;
        this.address = address;
        this.cardId = cardId;
        this.age = age;
        this.residentialZone = residentialZone;
        this.workZone = workZone;
        this.occupation = occupation;
        this.accessKnown = accessKnown;
        this.referee = referee;
        this.refereeTel = refereeTel;
        this.realtyPurpose = realtyPurpose;
        this.realtyTimes = realtyTimes;
        this.salarySettlementSubmitTime = salarySettlementSubmitTime;
        this.salaryGrantTime = salaryGrantTime;
        this.salarySettlementRate = salarySettlementRate;
        this.settleSalaryRate = settleSalaryRate;
        this.settleSalaryMoney = settleSalaryMoney;
        this.salarySettlementSubmitTimeSecond = salarySettlementSubmitTimeSecond;
        this.salaryGrantTimeSecond = salaryGrantTimeSecond;
        this.salarySettlementRateSecond = salarySettlementRateSecond;
        this.deposit = deposit;
        this.predictedDeliverTime = predictedDeliverTime;
        this.signPurchaseContract = signPurchaseContract;
        this.signPropertyContract = signPropertyContract;
        this.intermediaryMoney = intermediaryMoney;
        this.oldToNew = oldToNew;
        this.customerOwnership = customerOwnership;
        this.availableSignTime = availableSignTime;
        this.mortgageHandle = mortgageHandle;
        this.remark = remark;
    }

    public String getDealId() {
        return dealId;
    }

    public void setDealId(String dealId) {
        this.dealId = dealId;
    }

    public String getSubscriptionTime() {
        return subscriptionTime;
    }

    public void setSubscriptionTime(String subscriptionTime) {
        this.subscriptionTime = subscriptionTime;
    }

    public String getRecognitionTime() {
        return recognitionTime;
    }

    public void setRecognitionTime(String recognitionTime) {
        this.recognitionTime = recognitionTime;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public String getDealSection() {
        return dealSection;
    }

    public void setDealSection(String dealSection) {
        this.dealSection = dealSection;
    }

    public String getDecoration() {
        return decoration;
    }

    public void setDecoration(String decoration) {
        this.decoration = decoration;
    }

    public String getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(String buildingId) {
        this.buildingId = buildingId;
    }

    public String getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(String roomNum) {
        this.roomNum = roomNum;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getWechatId() {
        return wechatId;
    }

    public void setWechatId(String wechatId) {
        this.wechatId = wechatId;
    }

    public String getCustomerTel() {
        return customerTel;
    }

    public void setCustomerTel(String customerTel) {
        this.customerTel = customerTel;
    }

    public String getPredictedArea() {
        return predictedArea;
    }

    public void setPredictedArea(String predictedArea) {
        this.predictedArea = predictedArea;
    }

    public String getSubscriptionUnitPrice() {
        return subscriptionUnitPrice;
    }

    public void setSubscriptionUnitPrice(String subscriptionUnitPrice) {
        this.subscriptionUnitPrice = subscriptionUnitPrice;
    }

    public String getSubscriptionTotalPrice() {
        return subscriptionTotalPrice;
    }

    public void setSubscriptionTotalPrice(String subscriptionTotalPrice) {
        this.subscriptionTotalPrice = subscriptionTotalPrice;
    }

    public String getDiscountDetail() {
        return discountDetail;
    }

    public void setDiscountDetail(String discountDetail) {
        this.discountDetail = discountDetail;
    }

    public String getFiveToFifteen() {
        return fiveToFifteen;
    }

    public void setFiveToFifteen(String fiveToFifteen) {
        this.fiveToFifteen = fiveToFifteen;
    }

    public String getFifteenAfterDiscount() {
        return fifteenAfterDiscount;
    }

    public void setFifteenAfterDiscount(String fifteenAfterDiscount) {
        this.fifteenAfterDiscount = fifteenAfterDiscount;
    }

    public String getOpeningQuotationDiscount() {
        return openingQuotationDiscount;
    }

    public void setOpeningQuotationDiscount(String openingQuotationDiscount) {
        this.openingQuotationDiscount = openingQuotationDiscount;
    }

    public String getDiscountOfContractOntime() {
        return discountOfContractOntime;
    }

    public void setDiscountOfContractOntime(String discountOfContractOntime) {
        this.discountOfContractOntime = discountOfContractOntime;
    }

    public String getActualDealUnitPrice() {
        return actualDealUnitPrice;
    }

    public void setActualDealUnitPrice(String actualDealUnitPrice) {
        this.actualDealUnitPrice = actualDealUnitPrice;
    }

    public String getDealTotalPriceInput() {
        return dealTotalPriceInput;
    }

    public void setDealTotalPriceInput(String dealTotalPriceInput) {
        this.dealTotalPriceInput = dealTotalPriceInput;
    }

    public String getDealTotalPriceCheck() {
        return dealTotalPriceCheck;
    }

    public void setDealTotalPriceCheck(String dealTotalPriceCheck) {
        this.dealTotalPriceCheck = dealTotalPriceCheck;
    }

    public String getAmountOfPaymentFirst() {
        return amountOfPaymentFirst;
    }

    public void setAmountOfPaymentFirst(String amountOfPaymentFirst) {
        this.amountOfPaymentFirst = amountOfPaymentFirst;
    }

    public String getDateOfPaymentFirst() {
        return dateOfPaymentFirst;
    }

    public void setDateOfPaymentFirst(String dateOfPaymentFirst) {
        this.dateOfPaymentFirst = dateOfPaymentFirst;
    }

    public String getAmountOfPaymentSecond() {
        return amountOfPaymentSecond;
    }

    public void setAmountOfPaymentSecond(String amountOfPaymentSecond) {
        this.amountOfPaymentSecond = amountOfPaymentSecond;
    }

    public String getDateOfPaymentSecond() {
        return dateOfPaymentSecond;
    }

    public void setDateOfPaymentSecond(String dateOfPaymentSecond) {
        this.dateOfPaymentSecond = dateOfPaymentSecond;
    }

    public String getAmountOfPaymentThird() {
        return amountOfPaymentThird;
    }

    public void setAmountOfPaymentThird(String amountOfPaymentThird) {
        this.amountOfPaymentThird = amountOfPaymentThird;
    }

    public String getDateOfPaymentThird() {
        return dateOfPaymentThird;
    }

    public void setDateOfPaymentThird(String dateOfPaymentThird) {
        this.dateOfPaymentThird = dateOfPaymentThird;
    }

    public String getArrangeContractDate() {
        return arrangeContractDate;
    }

    public void setArrangeContractDate(String arrangeContractDate) {
        this.arrangeContractDate = arrangeContractDate;
    }

    public String getSubscriptionWithoutContract() {
        return subscriptionWithoutContract;
    }

    public void setSubscriptionWithoutContract(String subscriptionWithoutContract) {
        this.subscriptionWithoutContract = subscriptionWithoutContract;
    }

    public String getActualContractDate() {
        return actualContractDate;
    }

    public void setActualContractDate(String actualContractDate) {
        this.actualContractDate = actualContractDate;
    }

    public String getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(String loanAmount) {
        this.loanAmount = loanAmount;
    }

    public String getTransactLoanDate() {
        return transactLoanDate;
    }

    public void setTransactLoanDate(String transactLoanDate) {
        this.transactLoanDate = transactLoanDate;
    }

    public String getLoanBank() {
        return loanBank;
    }

    public void setLoanBank(String loanBank) {
        this.loanBank = loanBank;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentRate() {
        return paymentRate;
    }

    public void setPaymentRate(String paymentRate) {
        this.paymentRate = paymentRate;
    }

    public String getAccumulativePayment() {
        return accumulativePayment;
    }

    public void setAccumulativePayment(String accumulativePayment) {
        this.accumulativePayment = accumulativePayment;
    }

    public String getUnPayment() {
        return unPayment;
    }

    public void setUnPayment(String unPayment) {
        this.unPayment = unPayment;
    }

    public String getCompletePaymentDate() {
        return completePaymentDate;
    }

    public void setCompletePaymentDate(String completePaymentDate) {
        this.completePaymentDate = completePaymentDate;
    }

    public String getMortgageSchedule() {
        return mortgageSchedule;
    }

    public void setMortgageSchedule(String mortgageSchedule) {
        this.mortgageSchedule = mortgageSchedule;
    }

    public String getSalesCompany() {
        return salesCompany;
    }

    public void setSalesCompany(String salesCompany) {
        this.salesCompany = salesCompany;
    }

    public String getStaffPercentage() {
        return staffPercentage;
    }

    public void setStaffPercentage(String staffPercentage) {
        this.staffPercentage = staffPercentage;
    }

    public String getRealtyConsultantSalary() {
        return realtyConsultantSalary;
    }

    public void setRealtyConsultantSalary(String realtyConsultantSalary) {
        this.realtyConsultantSalary = realtyConsultantSalary;
    }

    public String getRealtyConsultant() {
        return realtyConsultant;
    }

    public void setRealtyConsultant(String realtyConsultant) {
        this.realtyConsultant = realtyConsultant;
    }

    public String getAbutmentPerson() {
        return abutmentPerson;
    }

    public void setAbutmentPerson(String abutmentPerson) {
        this.abutmentPerson = abutmentPerson;
    }

    public String getAgreementAuthenticationDate() {
        return agreementAuthenticationDate;
    }

    public void setAgreementAuthenticationDate(String agreementAuthenticationDate) {
        this.agreementAuthenticationDate = agreementAuthenticationDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getResidentialZone() {
        return residentialZone;
    }

    public void setResidentialZone(String residentialZone) {
        this.residentialZone = residentialZone;
    }

    public String getWorkZone() {
        return workZone;
    }

    public void setWorkZone(String workZone) {
        this.workZone = workZone;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getAccessKnown() {
        return accessKnown;
    }

    public void setAccessKnown(String accessKnown) {
        this.accessKnown = accessKnown;
    }

    public String getReferee() {
        return referee;
    }

    public void setReferee(String referee) {
        this.referee = referee;
    }

    public String getRefereeTel() {
        return refereeTel;
    }

    public void setRefereeTel(String refereeTel) {
        this.refereeTel = refereeTel;
    }

    public String getRealtyPurpose() {
        return realtyPurpose;
    }

    public void setRealtyPurpose(String realtyPurpose) {
        this.realtyPurpose = realtyPurpose;
    }

    public String getRealtyTimes() {
        return realtyTimes;
    }

    public void setRealtyTimes(String realtyTimes) {
        this.realtyTimes = realtyTimes;
    }

    public String getSalarySettlementSubmitTime() {
        return salarySettlementSubmitTime;
    }

    public void setSalarySettlementSubmitTime(String salarySettlementSubmitTime) {
        this.salarySettlementSubmitTime = salarySettlementSubmitTime;
    }

    public String getSalaryGrantTime() {
        return salaryGrantTime;
    }

    public void setSalaryGrantTime(String salaryGrantTime) {
        this.salaryGrantTime = salaryGrantTime;
    }

    public String getSalarySettlementRate() {
        return salarySettlementRate;
    }

    public void setSalarySettlementRate(String salarySettlementRate) {
        this.salarySettlementRate = salarySettlementRate;
    }

    public String getSettleSalaryRate() {
        return settleSalaryRate;
    }

    public void setSettleSalaryRate(String settleSalaryRate) {
        this.settleSalaryRate = settleSalaryRate;
    }

    public String getSettleSalaryMoney() {
        return settleSalaryMoney;
    }

    public void setSettleSalaryMoney(String settleSalaryMoney) {
        this.settleSalaryMoney = settleSalaryMoney;
    }

    public String getSalarySettlementSubmitTimeSecond() {
        return salarySettlementSubmitTimeSecond;
    }

    public void setSalarySettlementSubmitTimeSecond(String salarySettlementSubmitTimeSecond) {
        this.salarySettlementSubmitTimeSecond = salarySettlementSubmitTimeSecond;
    }

    public String getSalaryGrantTimeSecond() {
        return salaryGrantTimeSecond;
    }

    public void setSalaryGrantTimeSecond(String salaryGrantTimeSecond) {
        this.salaryGrantTimeSecond = salaryGrantTimeSecond;
    }

    public String getSalarySettlementRateSecond() {
        return salarySettlementRateSecond;
    }

    public void setSalarySettlementRateSecond(String salarySettlementRateSecond) {
        this.salarySettlementRateSecond = salarySettlementRateSecond;
    }

    public String getDeposit() {
        return deposit;
    }

    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }

    public String getPredictedDeliverTime() {
        return predictedDeliverTime;
    }

    public void setPredictedDeliverTime(String predictedDeliverTime) {
        this.predictedDeliverTime = predictedDeliverTime;
    }

    public String getSignPurchaseContract() {
        return signPurchaseContract;
    }

    public void setSignPurchaseContract(String signPurchaseContract) {
        this.signPurchaseContract = signPurchaseContract;
    }

    public String getSignPropertyContract() {
        return signPropertyContract;
    }

    public void setSignPropertyContract(String signPropertyContract) {
        this.signPropertyContract = signPropertyContract;
    }

    public String getIntermediaryMoney() {
        return intermediaryMoney;
    }

    public void setIntermediaryMoney(String intermediaryMoney) {
        this.intermediaryMoney = intermediaryMoney;
    }

    public String getOldToNew() {
        return oldToNew;
    }

    public void setOldToNew(String oldToNew) {
        this.oldToNew = oldToNew;
    }

    public String getCustomerOwnership() {
        return customerOwnership;
    }

    public void setCustomerOwnership(String customerOwnership) {
        this.customerOwnership = customerOwnership;
    }

    public String getAvailableSignTime() {
        return availableSignTime;
    }

    public void setAvailableSignTime(String availableSignTime) {
        this.availableSignTime = availableSignTime;
    }

    public String getMortgageHandle() {
        return mortgageHandle;
    }

    public void setMortgageHandle(String mortgageHandle) {
        this.mortgageHandle = mortgageHandle;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
