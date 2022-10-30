package Filter;

import web.Request;
import web.Response;

/**
 * @Auther: csx
 * @Date: 2022/2/25 8:04
 * @Description:
 */
public class MGFilter implements Filter{

    public void doFilter(Request request, Response response,FilterChain chain) {
        request.setRequestStr(request.getRequestStr().replace("被就业", "就业")+"====MGFilter()");
        chain.doFilter(request, response, chain);
        response.setResponseStr(response.getResponseStr()+"====MGFilter()");
    }
}
