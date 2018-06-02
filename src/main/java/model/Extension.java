package model;


public class Extension extends Entity {

    private String extensionId;

    private int extensionTime;

    private String extensionLocation;

    private String customerName;

    private String customerTel;

    private String realtyConsultant;

    private String visitTime;

    private String customerSituation;

    private String dealTime;

    private String dealBuilding;

    private String dealRoomnum;

    private String remark;

    public Extension(){
        super();
    }

    public Extension(int extensionTime, String extensionLocation, String customerName, String customerTel, String realtyConsultant, String visitTime, String customerSituation, String dealTime, String dealBuilding, String dealRoomnum, String remark) {
        this();
        this.extensionTime = extensionTime;
        this.extensionLocation = extensionLocation;
        this.customerName = customerName;
        this.customerTel = customerTel;
        this.realtyConsultant = realtyConsultant;
        this.visitTime = visitTime;
        this.customerSituation = customerSituation;
        this.dealTime = dealTime;
        this.dealBuilding = dealBuilding;
        this.dealRoomnum = dealRoomnum;
        this.remark = remark;
    }

    public String getExtensionId() {
        return extensionId;
    }

    public void setExtensionId(String extensionId) {
        this.extensionId = extensionId;
    }

    public int getExtensionTime() {
        return extensionTime;
    }

    public void setExtensionTime(int extensionTime) {
        this.extensionTime = extensionTime;
    }

    public String getExtensionLocation() {
        return extensionLocation;
    }

    public void setExtensionLocation(String extensionLocation) {
        this.extensionLocation = extensionLocation;
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

    public String getRealtyConsultant() {
        return realtyConsultant;
    }

    public void setRealtyConsultant(String realtyConsultant) {
        this.realtyConsultant = realtyConsultant;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
