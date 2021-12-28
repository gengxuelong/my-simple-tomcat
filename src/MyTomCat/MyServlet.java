package MyTomCat;

/**
 * @author gengxuelong
 * @Date 2021/12/29 0:35
 */
public class MyServlet extends MyHttpServlet{

    @Override
    public void doGet(MyRequest request, MyResponse response) {
        response.write("get the message here is the service for gengxuelong");
    }

    @Override
    public void doPost(MyRequest request, MyResponse response) {
        response.write("post到的信息：这是耿雪龙的服务器");
    }
}
