package j8;

import com.google.common.collect.Maps;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author Milo on 2022/3/15.
 * @description
 */
public class ComputeIfAbsentTest {
    private static final int DEFAULT_CAPACITY = 16;
    public static void main(String[] args) {
        // 创建一个 HashMap
        HashMap<String, Integer> prices = new HashMap<>();

        // 往HashMap中添加映射项
        prices.put("Shoes", 200);
        prices.put("Bag", 300);
        prices.put("Pant", 150);
        prices.put("Shirt", 111);
        System.out.println("HashMap: " + prices);

        // 计算 Shirt 的值
        int shirtPrice = prices.computeIfAbsent("Shirt", key -> 280);
        System.out.println("Price of Shirt: " + shirtPrice);

        // 输出更新后的HashMap
        System.out.println("Updated HashMap: " + prices);
        // 创建一个 HashMap

        ConcurrentHashMap<String, Integer> concurrentMap = new ConcurrentHashMap<>(DEFAULT_CAPACITY);

        // 往HashMap中添加映射项
        concurrentMap.put("Shoes", 200);
        concurrentMap.put("Bag", 300);
        concurrentMap.put("Pant", 150);
        concurrentMap.put("Shirt", 111);
        System.out.println("HashMap: " + prices);

        // 计算 Shirt 的值
        int shirtPriceC = prices.computeIfAbsent("Shirt", key -> 280);
        System.out.println("Price of Shirt: " + shirtPriceC);

        // 输出更新后的HashMap
        System.out.println("Updated HashMap: " + concurrentMap);
    }
}
