package guava;

import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.cache.*;
import com.google.common.collect.*;
import org.checkerframework.checker.units.qual.K;

import java.util.*;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

/**
 * @author Milo on 2021/7/27.
 * @description
 */
public class GuavaTest {

    public static void main(String[] args) {

        // feikongpanduan();

        // yuqizhipanduan();

        // shifouyuejie();

        // bukebianjihe();

        // jihegongchang();

        // 交差并集
        // jiaobingchaji();

        // 统计
        // tongji();

        // 字符拼接
        //zifupinjie();


        Splitter split = Splitter.on('_').trimResults().omitEmptyStrings();
        List<String> list1 = split.splitToList("1_2_3_");
        System.out.println(list1.size());
        System.out.println(list1.get(1));
        HashSet<String> objects1 = Sets.newHashSet();
        objects1.add("1");
        HashSet<String> objects2 = Sets.newHashSet();
        objects1.add("1");
        HashSet<String> objects3 = Sets.newHashSet();
        objects1.add("2");
        HashSet<String> objects4 = Sets.newHashSet();
        objects1.add("3");
        Sets.SetView<String> union1 = Sets.union(objects1, objects2);
        Sets.SetView<String> union2 = Sets.union(objects1, objects2);
        System.out.println(Sets.union(union1,union2));


        CacheLoader cacheLoader = new CacheLoader<String, Animal>() {
            // 如果找不到元素，会调用这里
            @Override
            public Animal load(String s) {
                return null;
            }
        };
        LoadingCache<String, Animal> loadingCache = CacheBuilder.newBuilder()
                                                                .maximumSize(1000)
                                                                .expireAfterWrite(3, TimeUnit.SECONDS)
                                                                .removalListener(new MyRemovalListener())
                                                                .build(cacheLoader); //
        loadingCache.put("狗", new Animal("旺财", 1));
        loadingCache.put("猫", new Animal("汤姆", 3));
        loadingCache.put("狼", new Animal("灰太狼", 4));

        loadingCache.invalidate("猫"); // 手动失效

        Animal animal = null;
        try {
            animal = loadingCache.get("狼");
            System.out.println(animal);
            Thread.sleep(4 * 1000);
            // 狼已经自动过去，获取为 null 值报错
            System.out.println(loadingCache.get("狼"));
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }




    }

    /**
     * 缓存移除监听器
     */
    static class MyRemovalListener implements RemovalListener<String, Animal> {

        @Override
        public void onRemoval(RemovalNotification<String, Animal> notification) {
            String reason = String.format("key=%s,value=%s,reason=%s", notification.getKey(), notification.getValue(), notification.getCause());
            System.out.println(reason);
        }
    }

    static class Animal {
        private String name;
        private Integer age;

        public Animal(String name, Integer age) {
            this.name = name;
            this.age = age;
        }
    }

    private static void zifupinjie() {
        // JDK 方式一
        ArrayList<String> list = Lists.newArrayList("a", "b", "c", null);
        String join = String.join(",", list);
        System.out.println(join); // a,b,c,null
        // JDK 方式二
        String result = list.stream().filter(Objects::nonNull).collect(Collectors.joining(","));
        System.out.println(result); // a,b,c,null
        // JDK 方式三
        StringJoiner stringJoiner = new StringJoiner(",");
        list.forEach(stringJoiner::add);
        System.out.println(stringJoiner.toString()); // a,b,c,null


        String join1 = Joiner.on(",").skipNulls().join(list);
        System.out.println(join1);

        String join2 = Joiner.on(",").useForNull("空值").join("旺财", "汤姆", "杰瑞", null);
        System.out.println(join2); // 旺财,汤姆,杰瑞,空值


        String str = ",a,,b,";
        String[] splitArr = str.split(",");
        Arrays.stream(splitArr).forEach(System.out::println);
        System.out.println("------");

        Iterable<String> split = Splitter.on(",").trimResults().omitEmptyStrings().split(str);
        split.forEach(System.out::println);
    }

    /**
     * 统计
     */
    private static void tongji() {
        // Java 统计相同元素出现的次数。
        List<String> words = Lists.newArrayList("a", "b", "c", "d", "a", "c");
        Map<String, Integer> countMap = new HashMap<String, Integer>();
        for (String word : words) {
            Integer count = countMap.get(word);
            count = (count == null) ? 1 : ++count;
            countMap.put(word, count);
        }
        countMap.forEach((k, v) -> System.out.println(k + ":" + v));
        /**
         * result:
         * a:2
         * b:1
         * c:2
         * d:1
         */
        HashMultiset<String> strings = HashMultiset.create(words);

        strings.elementSet().forEach(s -> {
            System.out.println(s+":"+ strings.count(s));
        });

        // 一对多，value 是 List 的 Map 集合。
        HashMap<String, Set<String>> animalMap = new HashMap<>();
        HashSet<String> dogSet = new HashSet<>();
        dogSet.add("旺财");
        dogSet.add("大黄");
        animalMap.put("狗", dogSet);
        HashSet<String> catSet = new HashSet<>();
        catSet.add("加菲");
        catSet.add("汤姆");
        animalMap.put("猫", catSet);
        System.out.println(animalMap.get("猫")); // [加菲, 汤姆]

        HashMultimap<String, String> hashMultimap = HashMultimap.create();
        hashMultimap.put("狗","旺财");
        hashMultimap.put("狗","大黄");
        hashMultimap.put("猫","加菲");
        hashMultimap.put("猫","汤姆");

        Set<String> set = hashMultimap.get("猫");
        System.out.println(set);

    }

    /**
     * 交集  并集  差集
     */
    private static void jiaobingchaji() {
        Set<String> newHashSet1 = Sets.newHashSet("a", "a", "b", "c");
        Set<String> newHashSet2 = Sets.newHashSet("b", "b", "c", "d");

        // 交集
        Sets.SetView<String> intersectionSet = Sets.intersection(newHashSet1, newHashSet2);
        System.out.println(intersectionSet); // [b, c]

        // 并集
        Sets.SetView<String> unionSet = Sets.union(newHashSet1, newHashSet2);
        System.out.println(unionSet); // [a, b, c, d]

        // newHashSet1 中存在，newHashSet2 中不存在
        Sets.SetView<String> setView = Sets.difference(newHashSet1, newHashSet2);
        System.out.println(setView); // [a]
    }

    /**
     * 集合操作工厂
     */
    private static void jihegongchang() {
        // 创建一个 ArrayList 集合
        List<String> list1 = Lists.newArrayList();
        // 创建一个 ArrayList 集合，同时塞入3个数据
        List<String> list2 = Lists.newArrayList("a", "b", "c");
        // 创建一个 ArrayList 集合，容量初始化为10
        List<String> list3 = Lists.newArrayListWithCapacity(10);

        LinkedList<String> linkedList1 = Lists.newLinkedList();
        CopyOnWriteArrayList<String> cowArrayList = Lists.newCopyOnWriteArrayList();

        HashMap<Object, Object> hashMap = Maps.newHashMap();
        ConcurrentMap<Object, Object> concurrentMap = Maps.newConcurrentMap();
        TreeMap<Comparable, Object> treeMap = Maps.newTreeMap();

        HashSet<Object> hashSet = Sets.newHashSet();
        HashSet<String> newHashSet = Sets.newHashSet("a", "a", "b", "c");
    }


    /**
     * 不可变的集合 不能删除、不能修改、不能增加元素的集合
     *
     * 线程安全，因为不能修改任何元素，可以随意多线程使用且没有并发问题。
     * 可以无忧的提供给第三方使用，反正修改不了。
     * 减少内存占用，因为不能改变，所以内部实现可以最大程度节约内存占用。
     * 可以用作常量集合。
     */

    private static void bukebianjihe() {
        ImmutableSet.Builder<String> builder = ImmutableSet.builder();
        builder.add("a");
        builder.add("b");
        builder.add("c");
        builder.add("d");

        System.out.println(builder.build().toString());

        ImmutableSet<String> of = ImmutableSet.of("a", "b", "c");
        of.forEach(System.out::println);

        // 创建方式3：从其他集合中拷贝创建
        ArrayList<String> arrayList = new ArrayList();
        arrayList.add("www.wdbyte.com");
        arrayList.add("https");
        ImmutableSet<String> immutableSet3 = ImmutableSet.copyOf(arrayList);

        immutableSet3.forEach(System.out::println);

//        boolean a = immutableSet3.add("a");
//        System.out.println(a);
//        immutableSet3.forEach(System.out::print);


        /**注意事项
         * 使用 Guava 创建的不可变集合是拒绝 null 值的，因为在 Google 内部调查中，95% 的情况下都不需要放入 null 值。 使用 JDK 提供的不可变集合创建成功后，原集合添加元素会体现在不可变集合中，而 Guava 的不可变集合不会有这个问题。
         */

        List<String> arrayList2 = new ArrayList<>();
        arrayList2.add("a");
        arrayList2.add("b");
        List<String> jdkList = Collections.unmodifiableList(arrayList2);
        ImmutableList<String> immutableList = ImmutableList.copyOf(arrayList2);
        arrayList2.add("ccc");
        jdkList.forEach(System.out::println);// result: a b ccc
        System.out.println("-------");
        immutableList.forEach(System.out::println);// result: a b

        //3. 如果不可变集合的元素是引用对象，那么引用对象的属性是可以更改的。
    }

    /**
     * 是否越界
     */
    private static void shifouyuejie() {
        List<String> list = Lists.newArrayList("a", "b", "c", "d");
        // 开始校验
        int index = Preconditions.checkElementIndex(5, list.size());
    }

    /**
     * 预期值判断
     */
    private static void yuqizhipanduan() {
        String param = "www.wdbyte.com2";
        String wdbyte = "www.wdbyte.com";
        Preconditions.checkArgument(wdbyte.equals(param), "[%s] 404 NOT FOUND", param);
        // java.lang.IllegalArgumentException: [www.wdbyte.com2] 404 NOT FOUND
    }

    /**
     * 非空判断
     */
    private static void feikongpanduan() {
        String param = "未读代码";
        String name = Preconditions.checkNotNull(param);
        // 未读代码
        System.out.println(name);
        String param2 = null;
        // NullPointerException
//        String name2 = Preconditions.checkNotNull(param2);
//        System.out.println(name2);

        String param3 = null;
        String name3 = Preconditions.checkNotNull(param3,"param2 is null");

        System.out.println(name3);
    }
}
