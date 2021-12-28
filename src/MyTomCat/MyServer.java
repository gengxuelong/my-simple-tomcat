package MyTomCat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author gengxuelong
 * @Date 2021/12/29 0:36
 */
public class MyServer {

    public static void startServer(int post){
        ServerSocket serverSocket = null ;
        Socket socket = null;
        try {
             serverSocket = new ServerSocket(post);
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true){
            try {
                assert serverSocket != null;
                socket = serverSocket.accept();
                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();
                MyRequest request = new MyRequest(inputStream);
                MyResponse response = new MyResponse(outputStream);
                String clazz = MyMapping.getMapping().get(request.getRequestUrl());
                if(clazz != null){
                    Class<MyHttpServlet> myServletClass = (Class<MyHttpServlet>)Class.forName(clazz);
                    MyHttpServlet myServlet = myServletClass.newInstance();
                    myServlet.service(request,response);
                }
            } catch (IOException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        startServer(10086);
    }
}
