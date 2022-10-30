package com.huawei.webservice.impl;

import com.huawei.webservice.dao.WeatherService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.jws.WebService;
import javax.websocket.server.PathParam;

/**
 * @Auther: csx
 * @Date: 2022/2/13 15:17
 * @Description:
 */
@Component
@WebService(name = "WeatherServiceImpl",targetNamespace="http://ser.example.com")
public class WeatherServiceImpl implements WeatherService {

    @Override
    @GetMapping("/query/{cityName}/")
    public String queryWeather( @PathVariable String cityName) {
        if ("北京".equals(cityName)){
            return "晴...";
        }
        return "未知区域";
    }
}
