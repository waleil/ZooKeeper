package com.cui.study.bootweb.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: csx
 * @Date: 2021/10/10 17:28
 * @Description:
 */
@RestController
public class ParameterTestController {
   @GetMapping("/car/{id}/owner/{username}")
    public Map<String,Object> getCar(@PathVariable("id") Integer id,
                                     @PathVariable("username") String name,
                                     @PathVariable Map<String,String> pv,
                                     @RequestHeader("User-Agent") String userAgent,
                                     @RequestHeader Map<String,String> header,
                                     @RequestParam("age") Integer age,
                                     @RequestParam("inters") List<String> inters,
                                     @RequestParam Map<String,String> Params){
     Map<String, Object> map = new HashMap<>();
//       map.put("id", id);
//       map.put("name", name);
//       map.put("pv", pv);
//       map.put("userAgent", userAgent);
//       map.put("header", header);
       map.put("age", age);
       map.put("inters", inters);
       map.put("Params", Params);
       //map.put("_ga", _ga);

       return map;
    }
    @PostMapping("/save")
    public Map postMethod(@RequestBody String content){
        Map<String, Object> map = new HashMap<>();
        map.put("content", content);
        System.out.println(content);
        return map;
    }
}
