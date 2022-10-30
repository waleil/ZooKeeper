package com.cui.stu.design.bridge.bnew;

/**
 * @Auther: csx
 * @Date: 2022/4/10 20:22
 * @Description:
 */
public abstract class Carb1 {
    private Engine engine;
    public Carb1(Engine engine){
        this.engine = engine;
    }
    public abstract void installEngine();

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }
}
