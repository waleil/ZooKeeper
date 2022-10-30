package Filter;

import web.Request;
import web.Response;

/**
 * @Auther: csx
 * @Date: 2022/2/25 8:01
 * @Description:
 */
public interface Filter {
    void doFilter(Request request, Response response, FilterChain chain);
}
