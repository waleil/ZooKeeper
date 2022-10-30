package com.cui.stu.design.mediator;

/**
 * @Auther: csx
 * @Date: 2022/4/10 21:46
 * @Description:
 */
public abstract class PersonM {
    private String name;
    private int condition;
    private Mediator mediator;

    public Mediator getMediator() {
        return mediator;
    }

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public PersonM(String name, int condition,Mediator mediator){
        super();
        this.name = name;
        this.condition = condition;
        this.mediator = mediator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }
    public abstract void getPartner(PersonM personM);
}
