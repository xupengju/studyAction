package jmh;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import javax.annotation.Nullable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * @author Milo on 2021/9/01.
 * @description
 */
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
//@BenchmarkMode(Mode.AverageTime)
//@OutputTimeUnit(TimeUnit.MICROSECONDS)
@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class GavaCacheVSCaffeine {

    private static com.google.common.cache.LoadingCache<String, String> loadingCache1;
    private static com.github.benmanes.caffeine.cache.LoadingCache<String, String> loadingCache2;

    @Benchmark
    public void testGuavaCache() {
        loadingCache1 = CacheBuilder.newBuilder().maximumSize(5).recordStats().expireAfterWrite(100, TimeUnit.SECONDS).build(new CacheLoader<String, String>() {

            @Override
            public String load(String key) throws Exception {
                return "value_" + key;
            }
        });

        for (int i = 0; i < 1000; i++) {
            try {
                loadingCache1.get(String.valueOf(ThreadLocalRandom.current().nextInt(100)));
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

    }
    @Benchmark
    public void testCaffeine() {
        loadingCache2 = Caffeine.newBuilder().maximumSize(5).expireAfterWrite(100, TimeUnit.SECONDS).build(new com.github.benmanes.caffeine.cache.CacheLoader<String, String>() {
            //同步加载数据
            @Nullable
            @Override
            public String load(@NonNull String key) throws Exception {
                return "value_" + key;
            }
        });

        for (int i = 0; i < 1000; i++) {
            loadingCache2.get(String.valueOf(ThreadLocalRandom.current().nextInt(100)));
        }

    }


    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(GavaCacheVSCaffeine.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }
}
