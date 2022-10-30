package Filter;

import web.Request;
import web.Response;

import java.util.ArrayList;

/**
 * @Auther: csx
 * @Date: 2022/2/24 22:08
 * @Description:
 */
public class main {
    public static void main(String[] args) {
        String msg = "大家好:):,被就业，网络授课没感觉，因为看不到大家";
        Request request = new Request();
        request.setRequestStr(msg);

        Response response = new Response();
        response.setResponseStr("response");

        FilterChain f = new FilterChain();
        f.addFilter(new HTMLFilter())
                .addFilter(new MGFilter());

        f.doFilter(request, response,f);
        System.out.println(request.getRequestStr());
        System.out.println(response.getResponseStr());
    }
}
