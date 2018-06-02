package auxiliary;

public class TimeFilter {

    public static String getTime(String time){
        String result = filterFirst(time);
        return result;
    }

    private static String filterFirst(String time){
        String result = "false";
        if(time.length()<8 || !time.contains("/")){
            return filterSecond(time);
        }
        for(int i=0; i<time.length();i++){
            if(time.charAt(i) != '/' && (time.charAt(i) < '0' || time.charAt(i) > '9')){
                return filterSecond(time);
            }
        }
        if(time.charAt(4) == '/' && time.lastIndexOf("/") >5 && time.length()-1 > time.lastIndexOf("/")){
            String[] data = time.split("/");
            String year = data[0];
            String month = "";
            if(Integer.valueOf(data[1])<10){
                month = "0"+String.valueOf(Integer.valueOf(data[1]));
            }else{
                month = data[1];
            }
            String day = "";
            if(Integer.valueOf(data[2])<10){
                day = "0"+String.valueOf(Integer.valueOf(data[2]));
            }else{
                day = data[2];
            }
            result = year+month+day;
        }
        if(result.equals("false")){
           result = filterSecond(time);
        }
        return result;
    }

    private static String filterSecond(String time){
        String result = "false";
        if(time.length()<9 || !time.contains("-")){
            return result;
        }
        if(time.indexOf('-')<3 && time.lastIndexOf("-") >3 && time.length()-1 > time.lastIndexOf("-")){
            String[] data = time.split("-");
            String year = data[2];
            String month = "";
            data[1] = data[1].replace("月", "");
            if(Integer.valueOf(data[1])<10){
                month = "0"+String.valueOf(Integer.valueOf(data[1]));;
            }else{
                month = data[1];
            }
            String day = "";
            if(Integer.valueOf(data[0])<10){
                day = "0"+String.valueOf(Integer.valueOf(data[0]));;
            }else{
                day = data[0];
            }
            result = year+month+day;
        }
        if(result.equals("false")){

        }
        return result;
    }
}
