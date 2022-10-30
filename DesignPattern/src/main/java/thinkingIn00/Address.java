package thinkingIn00;

/**
 * @Auther: csx
 * @Date: 2022/3/1 22:20
 * @Description:
 */
public class Address {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public Address(String name) {
        this.name = name;
    }
}
