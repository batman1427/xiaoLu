package model;

public class IncomingCall extends Entity{

    private String incomingCallId;

    private String callTime;

    private String customerName;

    private String customerTel;

    private String realtyPurpose;

    private String demandArea;

    private String houseType;

    private String residentialZone;

    private String acceptPrice;

    private String accessKnown;

    private String consultContent;

    private String visitTime;

    private String customerSituation;

    private String dealTime;

    private String dealBuilding;

    private String dealRoomnum;

    private String salesman;

    public IncomingCall(){
        super();
    }

    public IncomingCall(String callTime, String customerName, String customerTel, String realtyPurpose, String demandArea, String houseType, String residentialZone, String acceptPrice, String accessKnown, String consultContent, String visitTime, String customerSituation, String dealTime, String dealBuilding, String dealRoomnum, String salesman) {
        this();
        this.callTime = callTime;
        this.customerName = customerName;
        this.customerTel = customerTel;
        this.realtyPurpose = realtyPurpose;
        this.demandArea = demandArea;
        this.houseType = houseType;
        this.residentialZone = residentialZone;
        this.acceptPrice = acceptPrice;
        this.accessKnown = accessKnown;
        this.consultContent = consultContent;
        this.visitTime = visitTime;
        this.customerSituation = customerSituation;
        this.dealTime = dealTime;
        this.dealBuilding = dealBuilding;
        this.dealRoomnum = dealRoomnum;
        this.salesman = salesman;
    }

    public String getIncomingCallId() {
        return incomingCallId;
    }

    public void setIncomingCallId(String incomingCallId) {
        this.incomingCallId = incomingCallId;
    }

    public String getCallTime() {
        return callTime;
    }

    public void setCallTime(String callTime) {
        this.callTime = callTime;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerTel() {
        return customerTel;
    }

    public void setCustomerTel(String customerTel) {
        this.customerTel = customerTel;
    }

    public String getRealtyPurpose() {
        return realtyPurpose;
    }

    public void setRealtyPurpose(String realtyPurpose) {
        this.realtyPurpose = realtyPurpose;
    }

    public String getDemandArea() {
        return demandArea;
    }

    public void setDemandArea(String demandArea) {
        this.demandArea = demandArea;
    }

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    public String getResidentialZone() {
        return residentialZone;
    }

    public void setResidentialZone(String residentialZone) {
        this.residentialZone = residentialZone;
    }

    public String getAcceptPrice() {
        return acceptPrice;
    }

    public void setAcceptPrice(String acceptPrice) {
        this.acceptPrice = acceptPrice;
    }

    public String getAccessKnown() {
        return accessKnown;
    }

    public void setAccessKnown(String accessKnown) {
        this.accessKnown = accessKnown;
    }

    public String getConsultContent() {
        return consultContent;
    }

    public void setConsultContent(String consultContent) {
        this.consultContent = consultContent;
    }

    public String getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(String visitTime) {
        this.visitTime = visitTime;
    }

    public String getCustomerSituation() {
        return customerSituation;
    }

    public void setCustomerSituation(String customerSituation) {
        this.customerSituation = customerSituation;
    }

    public String getDealTime() {
        return dealTime;
    }

    public void setDealTime(String dealTime) {
        this.dealTime = dealTime;
    }

    public String getDealBuilding() {
        return dealBuilding;
    }

    public void setDealBuilding(String dealBuilding) {
        this.dealBuilding = dealBuilding;
    }

    public String getDealRoomnum() {
        return dealRoomnum;
    }

    public void setDealRoomnum(String dealRoomnum) {
        this.dealRoomnum = dealRoomnum;
    }

    public String getSalesman() {
        return salesman;
    }

    public void setSalesman(String salesman) {
        this.salesman = salesman;
    }
}
