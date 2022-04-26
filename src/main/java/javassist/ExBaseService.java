package javassist;

import java.util.Map;

/**
 * 增强后调用类
 */
public class ExBaseService {
    public static void exPrint(Map map) {
        System.out.println("exbaseService增强的功能==需要增强的方法之前");
    }

    public static void exPrintL(Map map) {
        System.out.println("exbaseService增强的功能==需要增强的方法之后");
    }
}