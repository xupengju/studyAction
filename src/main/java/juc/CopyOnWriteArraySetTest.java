package juc;

import java.util.Set;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Milo on 2021/9/27.
 * @description
 */
public class CopyOnWriteArraySetTest {
    public static void main(String[] args) {
        Set<String> set = new CopyOnWriteArraySet<>();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(12,12,2L,TimeUnit.SECONDS,new ArrayBlockingQueue(20000),new ThreadPoolExecutor.AbortPolicy());

        int times = 10000;
        AtomicInteger flag = new AtomicInteger(0);
        for(int i = 0; i < times; i ++){
            threadPoolExecutor.execute(()->{
                set.add("a" + flag.getAndAdd(1));
            });
        }
        threadPoolExecutor.shutdown();
        try {
            threadPoolExecutor.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(set.size());
    }
}
