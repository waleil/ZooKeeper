package com.stu.design.signleton;

/**
 * @Auther: csx
 * @Date: 2022/3/20 18:10
 * @Description:
 */
public class SeasonTest1 {
    public static void main(String[] args) {
        System.out.println(Season1.SPRING.toString());

        //values方法
        Season1[] values = Season1.values();
        for(Season1 value:values){
            System.out.println(value);
        }
        //更加提供的名称查找枚举类
        Season1 summer = Season1.valueOf("SUMMER");
        System.out.println(summer.getSeasonName());
        summer.show();
    }
}
interface Info{
    void show();
}
enum Season1 implements Info{
    SPRING("春天", "春暖花开"),

    SUMMER("夏天","夏日炎炎"),

    AUTUMN("秋天","秋高气爽"),

    WINTER("冬天","冰天雪地");

    //申明Season对象的属性
    private final String seasonName;

    private final String seasonDesc;

    private Season1(String seasonName,String seasonDesc){
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    @Override
    public void show() {
        System.out.println("这是一个接口类");
    }
}
