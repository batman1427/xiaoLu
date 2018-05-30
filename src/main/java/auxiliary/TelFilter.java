package auxiliary;

import java.util.ArrayList;

public class TelFilter {

    public static ArrayList<String> getTel(String tel){
        ArrayList<String> result = filterFirst(tel);
        return result;
    }

    private static ArrayList<String> filterFirst(String tel){
        tel = tel.replace("-", "");
        ArrayList<String> result = new ArrayList<String>();
        if(tel.length()<16 && tel.contains("E10")){
           String temp = tel.replace(".", "");
           temp = temp.replace("E10", "0000000000");
           result.add(temp.substring(0,11));
           return result;
        }
        if(tel.length()>20){
            String temp = "";
            for(int i=0;i<tel.length();i++){
                if(tel.charAt(i)>=48 && tel.charAt(i)<=57){
                    temp += tel.charAt(i);
                }
            }
            if(temp.length()%11 == 0 && temp.length() >10){
                int num = temp.length()/11;
                for(int i=0;i<num;i++){
                    result.add(temp.substring(i*11,i*11+11));
                }
                return result;
            }
        }
        return result;
    }
}
