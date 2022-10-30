package com.cui.stu.design.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: csx
 * @Date: 2022/4/10 10:24
 * @Description:
 */
public class MyCharacterFactory {
    private Map<Character,MyCharacter> pool;
    public MyCharacterFactory(){
        pool = new HashMap<Character, MyCharacter>();
    }
    public MyCharacter getMyCharacter(Character character){
        MyCharacter myCharacter = pool.get(character);
        if (myCharacter == null){
            myCharacter = new MyCharacter(character);
            pool.put(character, myCharacter);
        }
        return myCharacter;
    }
}
