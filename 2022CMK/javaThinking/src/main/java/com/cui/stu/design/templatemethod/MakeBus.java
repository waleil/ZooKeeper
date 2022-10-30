package com.cui.stu.design.templatemethod;

/**
 * @Auther: csx
 * @Date: 2022/4/11 6:57
 * @Description:
 */
public class MakeBus extends MakeCar{

    @Override
    public void makeBody() {
        System.out.println("bus:组装车身");
    }

    @Override
    public void makeHead() {
        System.out.println("bus:组装车头");
    }

    @Override
    public void makeTail() {
        System.out.println("bus:组装车尾");
    }
}
