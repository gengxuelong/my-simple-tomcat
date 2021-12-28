package MyTomCat;

import java.util.HashMap;

/**
 * @author gengxuelong
 * @Date 2021/12/29 0:35
 */
public class MyMapping {
    private static final HashMap<String,String> mapping = new HashMap<>();
    static{
        mapping.put("/myTomCat","MyTomCat.MyServlet");
        mapping.put("/myTomCat2","MyTomCat.MyServlet2");
    }

    public static HashMap<String, String> getMapping() {
        return mapping;
    }
}
