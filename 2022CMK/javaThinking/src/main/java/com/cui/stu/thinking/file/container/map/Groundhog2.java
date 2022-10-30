package com.cui.stu.thinking.file.container.map;

/**
 * @Auther: csx
 * @Date: 2022/4/8 20:37
 * @Description:
 */
public class Groundhog2 extends Groundhog{
    public Groundhog2(int n) {
        super(n);
    }

    public int hashCode() {
        return number;
    }

    public boolean equals(Object o) {
        return o instanceof Groundhog2 && (number == ((Groundhog2) o).number);
    }

}
