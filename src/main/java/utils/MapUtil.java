package utils;

import java.util.Map;

public class MapUtil {

    // ham nay tra ve doi tuong theo kieu tClass < dinh nghia la kieu du lieu >
    public static <T> T getObject(Map<String, Object> params, String key, Class<T> tClass) {
        // lay ra doi tuong theo key neu co key => khong co tra ve null
        Object obj = params.getOrDefault(key, null);
        if (obj != null) {
            // check type of obj
            if(tClass.getTypeName().equals("java.lang.Long")) {
                obj = obj != "" ? Long.parseLong(obj.toString()) : null;
            } else if (tClass.getTypeName().equals("java.lang.Integer")) {
                obj = obj != "" ? Integer.parseInt(obj.toString()) : null;
            } else if (tClass.getTypeName().equals("java.lang.String")) {
                obj = obj.toString();
            }
            // tra ra cai doi thuong theo kieu tClass
            return tClass.cast(obj);
        }
        return null;
    }
}
