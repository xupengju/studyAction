package javassist;

import java.util.Map;

/**
 * 增强前调用类
 */
public class BaseService {
    public void basePrint(Map map) {
        System.out.println("basePrint" + map.toString());
    }
}