package org.example.service.south;

import org.example.config.District;
import org.example.service.DistrictPerformance;
import org.springframework.stereotype.Service;

/**
 * @Auther: csx
 * @Date: 2021/12/9 22:47
 * 西南区绩效的具体实现
 */
@Service()
@District("south")
public class southDistrictPerformance implements DistrictPerformance {
    @Override
    public void calcPerformance(String type) {
        if ("suv".equalsIgnoreCase(type)){
            System.out.println("西南区"+type+"绩效1");
        }else if ("car".equalsIgnoreCase(type)){
            System.out.println("西南区"+type+"绩效3");
        }
    }
}
