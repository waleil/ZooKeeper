package com.huawei;

import com.huawei.webservice.impl.WeatherServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import javax.xml.ws.Endpoint;

/**
 * @Auther: csx
 * @Date: 2022/1/15 12:11
 * @Description:
 */
@SpringBootApplication
public class ServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }
}
