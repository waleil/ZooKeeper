package Filter;

import web.Request;
import web.Response;

/**
 * @Auther: csx
 * @Date: 2022/2/25 8:02
 * @Description:
 */
public class HTMLFilter implements Filter{


    public void doFilter(Request request, Response response,FilterChain chain) {
        request.setRequestStr(request.getRequestStr().replace(":","")
                .replace(")", "")+"====HTMLFilter()");
        chain.doFilter(request, response, chain);
        response.setResponseStr(response.getResponseStr()+"====HTMLFilter()");
    }
}
