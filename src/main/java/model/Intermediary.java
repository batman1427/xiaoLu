package model;

public class Intermediary extends Entity {

    private String intermediaryId;

    private String reportTime;

    private String customerSource;

    private String reportBuilding;

    private String customerName;

    private String customerTel;

    private String intentionLevel;

    private String visitTime;

    private String visitBuilding;

    private String customerSituation;

    private String dealTime;

    private String dealBuilding;

    private String dealRoomnum;

    private String remark;

    public Intermediary(){
        super();
    }

    public Intermediary(String reportTime, String customerSource, String reportBuilding, String customerName, String customerTel, String intentionLevel, String visitTime, String visitBuilding, String customerSituation, String dealTime, String dealBuilding, String dealRoomnum, String remark) {
        this();
        this.reportTime = reportTime;
        this.customerSource = customerSource;
        this.reportBuilding = reportBuilding;
        this.customerName = customerName;
        this.customerTel = customerTel;
        this.intentionLevel = intentionLevel;
        this.visitTime = visitTime;
        this.visitBuilding = visitBuilding;
        this.customerSituation = customerSituation;
        this.dealTime = dealTime;
        this.dealBuilding = dealBuilding;
        this.dealRoomnum = dealRoomnum;
        this.remark = remark;
    }

    public String getIntermediaryId() {
        return intermediaryId;
    }

    public void setIntermediaryId(String intermediaryId) {
        this.intermediaryId = intermediaryId;
    }

    public String getReportTime() {
        return reportTime;
    }

    public void setReportTime(String reportTime) {
        this.reportTime = reportTime;
    }

    public String getCustomerSource() {
        return customerSource;
    }

    public void setCustomerSource(String customerSource) {
        this.customerSource = customerSource;
    }

    public String getReportBuilding() {
        return reportBuilding;
    }

    public void setReportBuilding(String reportBuilding) {
        this.reportBuilding = reportBuilding;
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

    public String getIntentionLevel() {
        return intentionLevel;
    }

    public void setIntentionLevel(String intentionLevel) {
        this.intentionLevel = intentionLevel;
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
