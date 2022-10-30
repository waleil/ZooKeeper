package com.huawei.strategy;

/**
 * @Auther: csx
 * @Date: 2022/3/9 21:21
 * @Description:
 */
public class Cat implements Comparabl{
    private int height;

    public Comparat getComparat() {
        return comparat;
    }

    public void setComparat(Comparat comparat) {
        this.comparat = comparat;
    }

    private Comparat comparat = new CatHeightComparator();

    @Override
    public String toString() {
        return "Cat{" +
                "height=" + height +
                ", weitgh=" + weitgh +
                '}';
    }

    public Cat(int height, int weitgh) {
        this.height = height;
        this.weitgh = weitgh;
    }

    private int weitgh;

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeitgh() {
        return weitgh;
    }

    public void setWeitgh(int weitgh) {
        this.weitgh = weitgh;
    }


    @Override
    public int compareto(Object o) {
        return comparat.compare(this, o);
    }
}
