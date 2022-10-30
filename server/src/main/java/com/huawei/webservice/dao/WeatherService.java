package com.huawei.webservice.dao;

import javax.jws.WebService;

/**
 * @Auther: csx
 * @Date: 2022/2/13 15:14
 * @Description:
 */
@WebService(targetNamespace="http://ser.example.com")
public interface WeatherService {
    public String queryWeather(String cityName);
}
