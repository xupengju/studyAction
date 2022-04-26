package caffeine;

import com.github.benmanes.caffeine.cache.*;
import org.checkerframework.checker.nullness.qual.NonNull;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/**
 * @author Milo on 2021/9/13.
 * @description
 */
public class CaffeineTest {

    public static void main(String[] args) {

        AsyncLoadingCache<String, String> asyncLoadingCache = Caffeine.newBuilder()

                                                                      .maximumSize(1000)

                                                                      .buildAsync(key -> slowMethod(key));

        CompletableFuture<String> g = asyncLoadingCache.get("test");

        try {
            String value = g.get();
            System.out.println(value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

    static String slowMethod(String key) throws Exception {

        Thread.sleep(5000);

        return key + ".result";

    }

    private static LoadingCache<String, String> cache = Caffeine.newBuilder()
                                                                //最大个数限制
                                                                .maximumSize(256L)
                                                                //初始化容量
                                                                .initialCapacity(1)
                                                                //访问后过期（包括读和写）
                                                                .expireAfterAccess(2, TimeUnit.DAYS)
                                                                //写后过期
                                                                .expireAfterWrite(2, TimeUnit.HOURS)
                                                                //写后自动异步刷新
                                                                .refreshAfterWrite(1, TimeUnit.HOURS)
                                                                //记录下缓存的一些统计数据，例如命中率等
                                                                .recordStats()
                                                                //cache对缓存写的通知回调
                                                                .writer(new CacheWriter<Object, Object>() {
                                                                    @Override
                                                                    public void write(@NonNull Object key, @NonNull Object value) {
                                                                        System.out.println("key={}, CacheWriter write" + key);
                                                                    }

                                                                    @Override
                                                                    public void delete(@NonNull Object key, @Nullable Object value, @NonNull RemovalCause cause) {
                                                                        System.out.println("key={}" + key + " cause={}" + cause + " CacheWriter delete");
                                                                    }
                                                                })
                                                                //使用CacheLoader创建一个LoadingCache
                                                                .build(new CacheLoader<String, String>() {
                                                                    //同步加载数据
                                                                    @Nullable
                                                                    @Override
                                                                    public String load(@NonNull String key) throws Exception {
                                                                        return "value_" + key;
                                                                    }

                                                                    //异步加载数据
                                                                    @Nullable
                                                                    @Override
                                                                    public String reload(@NonNull String key, @NonNull String oldValue) throws Exception {
                                                                        return "value_" + key;
                                                                    }
                                                                });

    /**
     * 手动加载
     *
     * @param key
     * @return
     */
    public Object manulOperator(String key) {
        Cache<String, Object> cache = Caffeine.newBuilder()
                                              .expireAfterWrite(1, TimeUnit.SECONDS)
                                              .expireAfterAccess(1, TimeUnit.SECONDS)
                                              .maximumSize(10)
                                              .build();
        //如果一个key不存在，那么会进入指定的函数生成value
        Object value = cache.get(key, t -> setValue(key).apply(key));
        cache.put("hello", value);

        //判断是否存在如果不存返回null
        Object ifPresent = cache.getIfPresent(key);
        //移除一个key
        cache.invalidate(key);
        return value;
    }

    public Function<String, Object> setValue(String key) {
        return t -> key + "value";
    }

    /**
     * 同步加载
     *
     * @param key
     * @return
     */
    public Object syncOperator(String key) {
        LoadingCache<String, Object> cache = Caffeine.newBuilder()
                                                     .maximumSize(100)
                                                     .expireAfterWrite(1, TimeUnit.MINUTES)
                                                     .build(k -> setValue(key).apply(key));
        return cache.get(key);
    }

    /**
     * 异步加载
     *
     * @param key
     * @return
     */
    public Object asyncOperator(String key) {
        AsyncLoadingCache<String, Object> cache = Caffeine.newBuilder()
                                                          .maximumSize(100)
                                                          .expireAfterWrite(1, TimeUnit.MINUTES)
                                                          .buildAsync(k -> setAsyncValue(key).get());

        return cache.get(key);
    }

    public CompletableFuture<Object> setAsyncValue(String key) {
        return CompletableFuture.supplyAsync(() -> key + "value");
    }
}
