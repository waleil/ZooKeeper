package com.huawei.bridge;

/**
 * @Auther: csx
 * @Date: 2022/3/18 21:16
 * @Description:
 */
public class Boy {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void pursue(MM mm){
      // Gift g = new WarmGift(new Flower());
        Gift g = new WildGift(new Ring());
    }

    public void give(Gift g,MM mm){

    }
}
