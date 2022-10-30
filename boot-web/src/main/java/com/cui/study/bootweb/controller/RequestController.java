package com.cui.study.bootweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: csx
 * @Date: 2021/10/10 18:24
 * @Description:
 */
@Controller
public class RequestController {
    @GetMapping("/goto")
    public String goToPage(HttpServletRequest request){
        request.setAttribute("msg", "成功了");
        request.setAttribute("code", 200);
        return "forward:/success";
    }

    @ResponseBody
    @GetMapping("/success")
    public Map<String, Object> success(@RequestAttribute("msg") String msg,
                                       @RequestAttribute("code") Integer code,
                                       HttpServletRequest request){
        Object msg1 = request.getAttribute("msg");
        Map<String, Object> map = new HashMap<>();

        map.put("reqethod_msg", msg1);
        map.put("annotation_msg", msg);
        return map;
    }
}
