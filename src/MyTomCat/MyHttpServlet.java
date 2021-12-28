package MyTomCat;

/**
 * @author gengxuelong
 * @Date 2021/12/29 0:36
 */
public abstract class MyHttpServlet {
    public static final String METHOD_GET = "GET";
    public static final String METHOD_POST = "POST";
    public abstract void doGet(MyRequest request,MyResponse response);
    public abstract void doPost(MyRequest request,MyResponse response);
    public void service(MyRequest request, MyResponse response){
        if(METHOD_GET.equals(request.getRequestMethod())){
            doGet(request,response);
        }else if(METHOD_POST.equals(request.getRequestMethod())){
            doPost(request,response);
        }
    }
}
