package Filter;

import web.Request;
import web.Response;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: csx
 * @Date: 2022/2/25 19:26
 * @Description:
 */
public class FilterChain implements Filter{
    List<Filter> filters = new ArrayList<Filter>();
    int index = 0;

    public FilterChain addFilter(Filter f){
        this.filters.add(f);
        return this;
    }

    public void doFilter(Request request, Response response,FilterChain chain) {
        if (index==filters.size()) return;
        Filter f = filters.get(index);
        index++;
        f.doFilter(request,response,chain);
    }
}
