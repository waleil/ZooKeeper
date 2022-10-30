package com.cui.stu.design.flyweight;

/**
 * @Auther: csx
 * @Date: 2022/4/10 10:20
 * @Description:
 */
public class MainFlyweight {


    public static void main(String[] args) {
//        MyCharacter myCharacter1 = new MyCharacter('a');
//        MyCharacter myCharacter2 = new MyCharacter('b');
//        MyCharacter myCharacter3 = new MyCharacter('a');
//        MyCharacter myCharacter4 = new MyCharacter('d');
//        myCharacter1.display();
//        myCharacter2.display();
//        myCharacter3.display();
//        myCharacter4.display();
        MyCharacterFactory factory = new MyCharacterFactory();
        MyCharacter myCharacter1 = factory.getMyCharacter('a');
        MyCharacter myCharacter2 = factory.getMyCharacter('b');
        MyCharacter myCharacter3 = factory.getMyCharacter('a');
        MyCharacter myCharacter4 = factory.getMyCharacter('d');

        myCharacter1.display();
        myCharacter2.display();
        myCharacter3.display();
        myCharacter4.display();

        System.out.println(myCharacter1==myCharacter3);

    }
}
