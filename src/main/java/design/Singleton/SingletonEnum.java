package design.Singleton;

/**
 * @author Milo on 2022/3/10.
 * @description
 */
public enum  SingletonEnum {
    INSTANCE;

    private Singleton singleton ;

    SingletonEnum() {
        this.singleton = new Singleton();
    }

    public Singleton getIntance(){
        return singleton;
    }
}
