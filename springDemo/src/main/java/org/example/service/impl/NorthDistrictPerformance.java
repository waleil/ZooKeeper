package org.example.service.impl;

import org.example.config.District;
import org.example.service.DistrictPerformance;
import org.springframework.stereotype.Service;

/**
 * @Auther: csx
 * @Date: 2021/12/9 22:41
 * 华北区绩效计算的具体实现
 */
@Service()
@District("north")
public class NorthDistrictPerformance implements DistrictPerformance {
    @Override
    public void calcPerformance(String type) {
        if ("suv".equalsIgnoreCase(type)){
            System.out.println("华北区"+type+"绩效3");
        }else if ("car".equalsIgnoreCase(type)){
            System.out.println("华北区"+type+"绩效5");
        }
    }
}
