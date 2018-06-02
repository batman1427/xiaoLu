package model;


public class CallCustomer extends Entity {

    private String callCustomerId;

    private String datasourceArea;

    private String datasourceBuilding;

    private String datasourceType;

    private String customerName;

    private String customerTel;

    private int callTime;

    private String callSalesman;

    private String feedback;

    private String intentionLevel;

    private String intentionBuilding;

    private String visitTime;

    private String visitBuilding;

    private String customerSituation;

    private String dealTime;

    private String dealBuilding;

    private String dealRoomnum;

    private String remark;

    public CallCustomer(){
        super();
    }

    public CallCustomer(String datasourceArea, String datasourceBuilding, String datasourceType, String customerName, String customerTel, int callTime, String callSalesman, String feedback, String intentionLevel, String intentionBuilding, String visitTime, String visitBuilding, String customerSituation, String dealTime, String dealBuilding, String dealRoomnum, String remark) {
        this();
        this.datasourceArea = datasourceArea;
        this.datasourceBuilding = datasourceBuilding;
        this.datasourceType = datasourceType;
        this.customerName = customerName;
        this.customerTel = customerTel;
        this.callTime = callTime;
        this.callSalesman = callSalesman;
        this.feedback = feedback;
        this.intentionLevel = intentionLevel;
        this.intentionBuilding = intentionBuilding;
        this.visitTime = visitTime;
        this.visitBuilding = visitBuilding;
        this.customerSituation = customerSituation;
        this.dealTime = dealTime;
        this.dealBuilding = dealBuilding;
        this.dealRoomnum = dealRoomnum;
        this.remark = remark;
    }

    public String getCallCustomerId() {
        return callCustomerId;
    }

    public void setCallCustomerId(String callCustomerId) {
        this.callCustomerId = callCustomerId;
    }

    public String getDatasourceArea() {
        return datasourceArea;
    }

    public void setDatasourceArea(String datasourceArea) {
        this.datasourceArea = datasourceArea;
    }

    public String getDatasourceBuilding() {
        return datasourceBuilding;
    }

    public void setDatasourceBuilding(String datasourceBuilding) {
        this.datasourceBuilding = datasourceBuilding;
    }

    public String getDatasourceType() {
        return datasourceType;
    }

    public void setDatasourceType(String datasourceType) {
        this.datasourceType = datasourceType;
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

    public int getCallTime() {
        return callTime;
    }

    public void setCallTime(int callTime) {
        this.callTime = callTime;
    }

    public String getCallSalesman() {
        return callSalesman;
    }

    public void setCallSalesman(String callSalesman) {
        this.callSalesman = callSalesman;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getIntentionLevel() {
        return intentionLevel;
    }

    public void setIntentionLevel(String intentionLevel) {
        this.intentionLevel = intentionLevel;
    }

    public String getIntentionBuilding() {
        return intentionBuilding;
    }

    public void setIntentionBuilding(String intentionBuilding) {
        this.intentionBuilding = intentionBuilding;
    }

    public String getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(String visitTime) {
        this.visitTime = visitTime;
    }

    public String getVisitBuilding() {
        return visitBuilding;
    }

    public void setVisitBuilding(String visitBuilding) {
        this.visitBuilding = visitBuilding;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
