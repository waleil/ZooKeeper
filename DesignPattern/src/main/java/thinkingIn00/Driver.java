package thinkingIn00;

/**
 * @Auther: csx
 * @Date: 2022/3/1 22:18
 * @Description:
 */
public class Driver {
    private String name;
    //private Car car;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }




    public void drive(Car c){
        c.go(new Address("东北"));
    }
}
