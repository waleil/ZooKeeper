package org.example.service;

/**
 * @Auther: csx
 * @Date: 2021/12/9 22:31
 * 销售分成的桥接接口
 */
public interface DistrictPercentage {
    //不同类型的汽车提出不同：car suv
    void salePercentage(String type);
}
