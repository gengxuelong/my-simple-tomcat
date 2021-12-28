package MyTomCat;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

/**
 * @author gengxuelong
 * @Date 2021/12/29 0:34
 */
public class MyResponse {
    private final OutputStream outputStream;

    public MyResponse(OutputStream outPutStream){
        this.outputStream = outPutStream;
    }

    public void write(String str){
        StringBuilder sb = new StringBuilder();
        sb.append("HTTP/1.1 200 OK\n").append("Content-Type:text/html\n").append("\r\n").append("<html><body>").append(str).append("<body><html>");
        try {
            outputStream.write(sb.toString().getBytes());
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public OutputStream getOutputStream() {
        return outputStream;
    }
}
