package iterator;

/**
 * @Auther: csx
 * @Date: 2022/3/2 20:54
 * @Description:
 */
public class ArrayList {
    Object[] objects = new Object[10];
    int index = 0;
    public void add( Object o){

         objects[index] = o;
         index++;

    }

}
