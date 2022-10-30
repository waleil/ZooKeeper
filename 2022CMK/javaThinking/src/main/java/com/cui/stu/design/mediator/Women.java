package com.cui.stu.design.mediator;

/**
 * @Auther: csx
 * @Date: 2022/4/10 21:58
 * @Description:
 */
public class Women extends PersonM{

    public Women(String name, int condition, Mediator mediator) {
        super(name, condition, mediator);
    }

    public void getPartner(PersonM personM){
        this.getMediator().setWomen(this);
        this.getMediator().getPartner(personM);
    }
}
