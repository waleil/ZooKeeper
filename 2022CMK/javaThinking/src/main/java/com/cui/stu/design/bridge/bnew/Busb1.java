package com.cui.stu.design.bridge.bnew;

/**
 * @Auther: csx
 * @Date: 2022/4/10 20:23
 * @Description:
 */
public class Busb1 extends Carb1 {

    public Busb1(Engine engine) {
        super(engine);
    }

    @Override
    public void installEngine() {
        System.out.println("Carb1");
        this.getEngine().installEngine();
    }
}
