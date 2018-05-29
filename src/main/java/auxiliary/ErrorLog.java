package auxiliary;

public class ErrorLog {

    private String sheetName;

    private int row;

    private String description;

    public ErrorLog(){

    }

    public ErrorLog(String sheetName, int row, String description){
        this.sheetName = sheetName;
        this.row = row;
        this.description = description;
    }

    public String getSheetName() {
        return sheetName;
    }

    public void setSheetName(String sheetName) {
        this.sheetName = sheetName;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toString(){
        return this.sheetName+": 第"+row+"行插入失败，错误内容为--"+description+";";
    }
}
