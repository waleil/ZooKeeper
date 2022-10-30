package com.cui.stu.design.memento;

import com.cui.stu.design.mediator.PersonM;

/**
 * @Auther: csx
 * @Date: 2022/4/11 7:12
 * @Description:
 */
public class MainMemento {
    public static void main(String[] args) {
        PersonMe per = new PersonMe("zhang", "男", 20);

//        PersonMe backup = new PersonMe();
//
//        backup.setAge(per.getAge());
//        backup.setName(per.getName());
//        backup.setSex(per.getSex());

        Memento memento = per.createMemento();
        per.display();

        per.setName("li");
        per.display();

        per.setMemento(memento);
        per.display();
    }
}
