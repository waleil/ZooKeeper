package observer;

/**
 * @Auther: csx
 * @Date: 2022/3/27 19:32
 * @Description:
 */
public class Main4 {
}

class Child4 {
    private boolean cry = false;
    private Dad dad = new Dad();
    private Mum mum = new Mum();
    private Dog dog = new Dog();

    public boolean isCry() {
        return cry;
    }

    public void wakeUp() {
        cry = true;
        dad.feed();
        dog.wang();
        mum.hug();
    }
}

class Dad4 {
    public void feed() {
        System.out.println("dad feeding...");
    }
}

class Mum {
    public void hug() {
        System.out.println("mum hugging.....");
    }
}

class Dog {
    public void wang() {
        System.out.println("dog wang ...");
    }
}