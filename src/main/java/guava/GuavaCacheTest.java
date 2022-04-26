package guava;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * @author Milo on 2021/9/26.
 * @description
 */
public class GuavaCacheTest {


    private static LoadingCache<Integer,String> loadingCache;


    private static CacheLoader cacheLoader= new CacheLoader(){
        @Nullable
        @Override
        public String load(@NonNull Object key) throws Exception {
            return String.valueOf(ThreadLocalRandom.current().nextInt(10));
        }
    };

    public static void main(String[] args) {
        loadingCache = CacheBuilder.newBuilder().maximumSize(100).recordStats().expireAfterWrite(10L, TimeUnit.SECONDS).build(cacheLoader);


        loadingCache.put(1,"one");
        loadingCache.put(2,"two");


        try {
            System.out.println(loadingCache.get(3));
            System.out.println(loadingCache.get(1));
            System.out.println(loadingCache.asMap());
            System.out.println(loadingCache.stats());

            System.out.println(loadingCache.get(3));
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
