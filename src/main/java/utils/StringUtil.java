package utils;

public class StringUtil {

    public static boolean checkString(String data){
        if(data == null || data.isEmpty()){
            return false;
        }
        return true;
    }
}
