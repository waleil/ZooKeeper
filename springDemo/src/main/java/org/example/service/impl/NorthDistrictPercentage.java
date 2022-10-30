package org.example.service.impl;

import org.example.config.District;
import org.example.service.DistrictPercentage;
import org.springframework.stereotype.Service;

/**
 * @Auther: csx
 * @Date: 2021/12/9 22:35
 * 华北区销售分成具体实现
 */
@Service()
@District("north")
public class NorthDistrictPercentage implements DistrictPercentage {
    @Override
    public void salePercentage(String type) {

        if ("suv".equalsIgnoreCase(type)){
            System.out.println("华北区"+type+"提出1%");
        }else if ("car".equalsIgnoreCase(type)){
            System.out.println("华北区"+type+"提成5%");
        }

    }
}
