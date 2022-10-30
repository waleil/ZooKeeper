package org.example;

import org.example.service.DistrictPerformance;
import org.example.service.DistrictPercentage;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Auther: csx
 * @Date: 2021/12/9 22:55
 * @Description:
 */
public class SpringFilterTest {
    public static void main(String[] args) {
        //1.创建容器
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext("org.example");
        //2.获取对象
        DistrictPercentage districtPercentage = ac.getBean("districtPercentage", DistrictPercentage.class);
        //3.执行方法
        districtPercentage.salePercentage("suv");

        //获取对象
        DistrictPerformance districtPerformance = ac.getBean("districtPerformance",DistrictPerformance.class);
        //执行方法
        districtPerformance.calcPerformance("suv");

    }
}
