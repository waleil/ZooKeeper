package org.example.config;

import org.example.typefilter.DistrictTypeFilter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * @Auther: csx
 * @Date: 2021/12/9 22:53
 * @Description:
 */
@Configuration
@ComponentScan(value = "org.example",
        excludeFilters = @ComponentScan.Filter(type = FilterType.CUSTOM,classes = DistrictTypeFilter.class))
public class SpringconfigurationD {
}
