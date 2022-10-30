package com.cui.stu.design.memento;

/**
 * @Auther: csx
 * @Date: 2022/4/11 7:11
 * @Description:
 */
public class PersonMe {

    private String name;

    private String sex;

    private int age;

    public PersonMe(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public PersonMe() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public void display(){
        System.out.println(name+"-----"+sex+"-----"+age);
    }

    public Memento createMemento(){
        return new Memento(name,sex,age);
    }

    public void setMemento(Memento memento){
        this.name= memento.getName();
        this.age = memento.getAge();
        this.sex=memento.getSex();
    }
}
