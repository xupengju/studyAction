package design.Singleton;

/**
 * @author Milo on 2022/3/10.
 * @description
 */
public class Test {

    public static void main(String[] args) {
        Singleton singleton = SingletonEnum.INSTANCE.getIntance();
        System.out.println(singleton);
    }
}
