package org.example.service.south;

import org.example.config.District;
import org.example.service.DistrictPercentage;
import org.springframework.stereotype.Service;

/**
 * @Auther: csx
 * @Date: 2021/12/9 22:45
 * 西南区销售分成实现
 */
@Service()
@District("south")
public class southDistrictPercentage implements DistrictPercentage {
    @Override
    public void salePercentage(String type) {
        if ("suv".equalsIgnoreCase(type)){
            System.out.println("西南区"+type+"提出1.5%");
        }else if ("car".equalsIgnoreCase(type)){
            System.out.println("西南区"+type+"提成3%");
        }
    }
}
