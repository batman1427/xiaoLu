package model;

public class Visit extends Entity {

    private String visitId;

    private int visitTime;

    private String customerName;

    private String customerTel;

    private String visitedTimes;

    private String intentionalArea;

    private String acceptPrice;

    private String realtyTimes;

    private String age;

    private String residentialZone;

    private String workZone;

    private String occupation;

    private String accessKnown;

    private String realtyPurpose;

    private String realtyType;

    private String concerns;

    private String customerDescription;

    private String latestState;

    private String customerType;

    private String realtyConsultant;

    private String dealTime;

    private String dealRoomnum;

    public Visit(){
        super();
    }

    public Visit(int visitTime, String customerName, String customerTel, String visitedTimes, String intentionalArea, String acceptPrice, String realtyTimes, String age, String residentialZone, String workZone, String occupation, String accessKnown, String realtyPurpose, String realtyType, String concerns, String customerDescription, String latestState, String customerType, String realtyConsultant, String dealTime, String dealRoomnum) {
        this();
        this.visitTime = visitTime;
        this.customerName = customerName;
        this.customerTel = customerTel;
        this.visitedTimes = visitedTimes;
        this.intentionalArea = intentionalArea;
        this.acceptPrice = acceptPrice;
        this.realtyTimes = realtyTimes;
        this.age = age;
        this.residentialZone = residentialZone;
        this.workZone = workZone;
        this.occupation = occupation;
        this.accessKnown = accessKnown;
        this.realtyPurpose = realtyPurpose;
        this.realtyType = realtyType;
        this.concerns = concerns;
        this.customerDescription = customerDescription;
        this.latestState = latestState;
        this.customerType = customerType;
        this.realtyConsultant = realtyConsultant;
        this.dealTime = dealTime;
        this.dealRoomnum = dealRoomnum;
    }

    public String getVisitId() {
        return visitId;
    }

    public void setVisitId(String visitId) {
        this.visitId = visitId;
    }

    public int getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(int visitTime) {
        this.visitTime = visitTime;
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

    public String getVisitedTimes() {
        return visitedTimes;
    }

    public void setVisitedTimes(String visitedTimes) {
        this.visitedTimes = visitedTimes;
    }

    public String getIntentionalArea() {
        return intentionalArea;
    }

    public void setIntentionalArea(String intentionalArea) {
        this.intentionalArea = intentionalArea;
    }

    public String getAcceptPrice() {
        return acceptPrice;
    }

    public void setAcceptPrice(String acceptPrice) {
        this.acceptPrice = acceptPrice;
    }

    public String getRealtyTimes() {
        return realtyTimes;
    }

    public void setRealtyTimes(String realtyTimes) {
        this.realtyTimes = realtyTimes;
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

    public String getRealtyPurpose() {
        return realtyPurpose;
    }

    public void setRealtyPurpose(String realtyPurpose) {
        this.realtyPurpose = realtyPurpose;
    }

    public String getRealtyType() {
        return realtyType;
    }

    public void setRealtyType(String realtyType) {
        this.realtyType = realtyType;
    }

    public String getConcerns() {
        return concerns;
    }

    public void setConcerns(String concerns) {
        this.concerns = concerns;
    }

    public String getCustomerDescription() {
        return customerDescription;
    }

    public void setCustomerDescription(String customerDescription) {
        this.customerDescription = customerDescription;
    }

    public String getLatestState() {
        return latestState;
    }

    public void setLatestState(String latestState) {
        this.latestState = latestState;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getRealtyConsultant() {
        return realtyConsultant;
    }

    public void setRealtyConsultant(String realtyConsultant) {
        this.realtyConsultant = realtyConsultant;
    }

    public String getDealTime() {
        return dealTime;
    }

    public void setDealTime(String dealTime) {
        this.dealTime = dealTime;
    }

    public String getDealRoomnum() {
        return dealRoomnum;
    }

    public void setDealRoomnum(String dealRoomnum) {
        this.dealRoomnum = dealRoomnum;
    }
}
