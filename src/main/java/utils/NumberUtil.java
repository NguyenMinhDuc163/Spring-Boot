package utils;

public class NumberUtil {

        public static boolean isNumber(String data){
            try {
                Long number = Long.parseLong(data);
            }
            catch (NumberFormatException e){
                return false;
            }
            return true;
        }
}
