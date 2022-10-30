package com.cui.stu.design.mediator;

/**
 * @Auther: csx
 * @Date: 2022/4/10 21:58
 * @Description:
 */
public class Man extends PersonM{

    public Man(String name, int condition, Mediator mediator) {
        super(name, condition, mediator);
    }

    public void getPartner(PersonM personM){
        this.getMediator().setMan(this);
        this.getMediator().getPartner(personM);
    }
}
