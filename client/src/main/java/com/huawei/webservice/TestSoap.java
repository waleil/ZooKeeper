package com.huawei.webservice;

import com.huawei.webservice.client.WeatherService;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;

/**
 * @Auther: csx
 * @Date: 2022/2/13 16:49
 * @Description:
 */
public class TestSoap {

    public static void main(String[] args) throws Exception {
        Service weatherServiceImplService = Service.create(new URL("http://localhost:8080/services/weatherService?wsdl"),
                new QName("http://ser.example.com", "WeatherServiceImplService"));
        WeatherService port = weatherServiceImplService.getPort(WeatherService.class);
        String weather = port.queryWeather("北京");
        System.out.println(weather);
    }
}
