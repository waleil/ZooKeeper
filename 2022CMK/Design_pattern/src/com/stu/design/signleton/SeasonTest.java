package com.stu.design.signleton;

/**
 * @Auther: csx
 * @Date: 2022/3/20 17:47
 * @Description:
 */
public class SeasonTest {
    public static void main(String[] args) {
        System.out.println(Season.SPRING);
    }
}
//自定义枚举类
class Season{

    //申明Season对象的属性
    private final String seasonName;

    private final String seasonDesc;
    //1.私有化类的构造器,并给对象属性赋值
    private Season(String seasonName,String seasonDesc){
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }
    //3.提供当前枚举类的多个对象
    public static final Season SPRING = new Season("春天", "春暖花开");
    public static final Season SUMMER = new Season("夏天", "夏日炎炎");
    public static final Season AUTUMN = new Season("秋天", "秋高气爽");
    public static final Season WINTER = new Season("冬天", "冰天雪地");

    //4.获取枚举类对象的属性
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }
   //提供toString

    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }
}
