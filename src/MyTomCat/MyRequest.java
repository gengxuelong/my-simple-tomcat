package MyTomCat;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author gengxuelong
 * @Date 2021/12/29 0:33
 */
public class MyRequest {
    private String requestMethod;
    private String requestUrl;
    public MyRequest(InputStream inputStream){
        byte[] buffer = new byte[1024];
        int len = 0;
        try {
            len = inputStream.read(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String str = null;
        if(len >0){
            str = new String(buffer,0,len);
            String requestRow = str.split("\n")[0];//请求行
            String[] params = requestRow.split(" ");
            requestMethod = params[0];
            requestUrl = params[1];
        }
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }
}
