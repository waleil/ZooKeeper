package com.huawei.webservice.config;

import com.huawei.webservice.dao.WeatherService;
import com.huawei.webservice.impl.WeatherServiceImpl;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

/**
 * @Auther: csx
 * @Date: 2022/2/13 15:22
 * @Description:
 */
@Configuration
public class SoapConfig {

    @Autowired
    private WeatherService weatherService;

    @Bean
    public ServletRegistrationBean wsServlet() {
        return new ServletRegistrationBean(new CXFServlet(), "/services/*");
    }

    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return new SpringBus();
    }

    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(springBus(), weatherService);
        endpoint.publish("/weatherService");
        return (Endpoint) endpoint;
    }
}
