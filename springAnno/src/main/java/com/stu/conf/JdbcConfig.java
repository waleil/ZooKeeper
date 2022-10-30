package com.stu.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import javax.jws.WebService;
import javax.sql.DataSource;


/**
 * @Auther: csx
 * @Date: 2022/2/11 21:32
 * @Description:
 */
@Component
public class JdbcConfig {
    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

    @Bean("datasource")
    @Conditional(WindowsCondition.class)  //返回false表示不注册，返回true表示注册
    public DataSource CreateDataSource(){
        //创建对象
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        // 设置属性
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        return dataSource;
    }
    @Bean("datasource")
    public DataSource CreateDataSource(@Value("@{linux.driver}")String linuxDriver,
                                       @Value("@{linux.url}")String linuxUrl,
                                       @Value("@{linux.username}")String linuxUserName,
                                       @Value("@{linux.password}")String linuxPassword){
        //创建对象
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        // 设置属性
        dataSource.setDriverClassName(linuxDriver);
        dataSource.setUrl(linuxUrl);
        dataSource.setUsername(linuxUserName);
        dataSource.setPassword(linuxPassword);

        return dataSource;
    }
}
