package com.cui.stu.design.mediator;

import java.util.regex.Pattern;

/**
 * @Auther: csx
 * @Date: 2022/4/10 21:55
 * @Description:
 */
public class Mediator {

    private Man man;

    private Women women;


    public void setMan(Man man) {
        this.man = man;
    }

    public void setWomen(Women women) {
        this.women = women;
    }

    public void getPartner(PersonM personM){

        //将搭档设置上
        if (personM instanceof Man){
            this.setMan((Man) personM);
        }else {
            this.setWomen((Women)personM);
        }
        //判断条件
        if (man==null || women==null) {
            System.out.println("汗，我不是同性恋");
        } else {
            if (man.getCondition() == women.getCondition()){
                System.out.println(man.getName()+"和"+women.getName() + "绝配");
            }else {
                System.out.println(man.getName()+"和"+women.getName() + "不相配");
            }
        }
    }
}
