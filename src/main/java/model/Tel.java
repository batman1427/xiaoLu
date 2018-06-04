package model;

public class Tel extends Entity {

    private String telId;

    private String telName;

    private String telContent;

    public Tel(){
        super();
    }

    public Tel(String telId, String telName, String telContent) {
        this();
        this.telId = telId;
        this.telName = telName;
        this.telContent = telContent;
    }

    public String getTelId() {
        return telId;
    }

    public void setTelId(String telId) {
        this.telId = telId;
    }

    public String getTelName() {
        return telName;
    }

    public void setTelName(String telName) {
        this.telName = telName;
    }

    public String getTelContent() {
        return telContent;
    }

    public void setTelContent(String telContent) {
        this.telContent = telContent;
    }
}
