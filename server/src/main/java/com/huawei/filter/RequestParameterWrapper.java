//package com.huawei.filter;
//
///**
// * @Auther: csx
// * @Date: 2022/2/10 21:48
// * @Description:
// */
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletRequestWrapper;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * 请求参数修改
// */
//public class RequestParameterWrapper extends HttpServletRequestWrapper {
//
//    private Map<String, String[]> params = new HashMap<>();
//
//    RequestParameterWrapper(HttpServletRequest request) {
//        super(request);
//        //将现有parameter传递给params
//        this.params.putAll(request.getParameterMap());
//    }
//
//
//    void addParameters(Map<String, Object> extraParams) {
//        for (Map.Entry<String, Object> entry : extraParams.entrySet()) {
//            addParameter(entry.getKey(), entry.getValue());
//        }
//    }
//
//    /**
//     * 重写getParameter，代表参数从当前类中的map获取
//     *
//     * @param name
//     * @return
//     */
//    @Override
//    public String getParameter(String name) {
//        String[] values = params.get(name);
//        if (values == null || values.length == 0) {
//            return null;
//        }
//        return values[0];
//    }
//
//    /**
//     * 同上
//     *
//     * @param name
//     * @return
//     */
//    @Override
//    public String[] getParameterValues(String name) {
//        return params.get(name);
//    }
//
//    /**
//     * 添加参数
//     *
//     * @param name
//     * @param value
//     */
//    private void addParameter(String name, Object value) {
//        if (value != null) {
//            // System.out.println(value);
//            if (value instanceof String[]) {
//                params.put(name, (String[]) value);
//            } else if (value instanceof String) {
//                params.put(name, new String[]{(String) value});
//            } else {
//                params.put(name, new String[]{String.valueOf(value)});
//            }
//        }
//    }
//}
