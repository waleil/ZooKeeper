package org.example.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * @Auther: csx
 * @Date: 2021/12/2 22:39
 * @Description:
 */
public class JdbcConfig {
    @Value("${jdbc.driver}")
    private String driver;
    private String url;
    private String username;
    private String password;

    @Bean
    public JdbcTemplate creatJdbcTemplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
    @Bean
    public DataSource creatDataSource(){
        //创建spring的内置数据源
        DriverManagerDataSource datasource = new DriverManagerDataSource();
        datasource.setDriverClassName(driver);
        datasource.setUrl(url);
        datasource.setUsername(username);
        datasource.setPassword(password);
        return datasource;
    }
}
