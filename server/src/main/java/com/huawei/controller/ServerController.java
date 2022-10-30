package com.huawei.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: csx
 * @Date: 2022/1/15 12:15
 * @Description:
 */
@RestController
@RequestMapping("/server")
public class ServerController {
    @RequestMapping("/hello")
    public String getUrlInfo(){
        return "***********request https success**************";
    }
}
