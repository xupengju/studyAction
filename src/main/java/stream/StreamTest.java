package stream;

import com.google.common.base.Splitter;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Milo on 2021/7/28.
 * @description
 */
public class StreamTest {


    public static void main(String[] args) {


        List<Integer> list = Arrays.asList(7, 6, 9, 3, 8, 2, 1);

        // 遍历输出符合条件的元素
        list.stream().filter(x -> x > 6).forEach(System.out::println);
        // 匹配第一个
        Optional<Integer> findFirst = list.stream().filter(x -> x > 6).findFirst();
        // 匹配任意（适用于并行流）
        Optional<Integer> findAny = list.parallelStream().filter(x -> x > 1).findAny();
        // 是否包含符合特定条件的元素
        boolean anyMatch = list.stream().anyMatch(x -> x < 6);
        System.out.println("匹配第一个值：" + findFirst.orElse(0));
        System.out.println("匹配任意一个值：" + findAny.orElseGet(() -> new Random().nextInt(10)));
        System.out.println("是否存在大于6的值：" + anyMatch);

        List<Integer> list2 = Arrays.asList(6, 7, 3, 8, 1, 2, 9);
        Stream<Integer> stream = list2.stream();
        stream.filter(x -> x > 7).forEach(System.out::println);


        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Tom", 8900, 12, "male", "New York"));
        personList.add(new Person("Jack", 7000, 22, "male", "Washington"));
        personList.add(new Person("Lily", 7800, 45, "female", "Washington"));
        personList.add(new Person("Anni", 8200, 64, "female", "New York"));
        personList.add(new Person("Owen", 9500, 43, "male", "New York"));
        personList.add(new Person("Alisa", 7900, 50, "female", "New York"));


        String collect = personList.stream().filter(x -> x.getSalary() > 8000).map(Person::getName).collect(Collectors.joining(",", "[", "]"));
        System.out.println(collect);

        Optional<Person> max = personList.stream().max(Comparator.comparing(Person::getSalary));
        System.out.println(max.get().getName());

        Optional<String> max1 = personList.stream().map(Person::getName).max(Comparator.comparing(String::length));
        System.out.println(max1.get());


        long count = personList.stream().filter(x -> x.getSalary() > 8000).count();
        System.out.println(count);

        // 英文字符串数组的元素全部改为大写。整数数组每个元素+3
        String[] strArr = {"abcd", "bcdd", "defde", "fTr"};
        List<String> collect1 = Arrays.stream(strArr).map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(collect1);

        List<Integer> intList = Arrays.asList(1, 3, 5, 7, 9, 11);
        List<Integer> collect2 = intList.stream().map(x -> x + 3).collect(Collectors.toList());
        System.out.println(collect2);

        // 将员工的薪资全部增加1000。
        personList.forEach(x -> x.setSalary(x.getSalary() + 1000));

        System.out.println(personList);

        //将两个字符数组合并成一个新的字符数组。

        List<String> lis2t = Arrays.asList("m,k,l,a", "1,3,5,7");

        List<Iterable<String>> collect3 = lis2t.stream().flatMap(s -> {
            Iterable<String> split = Splitter.on(",").omitEmptyStrings().trimResults().split(s);
            return Stream.of(split);
        }).collect(Collectors.toList());

        List<String> collect4 = lis2t.stream().flatMap(s -> {
            String[] split = s.split(",");
            StringUtils.isNotBlank("s");
            return Arrays.stream(split).filter(StringUtils::isNotBlank);
        }).collect(Collectors.toList());
        System.out.println(collect4);


        // 归约(reduce)
        List<Integer> list3 = Arrays.asList(1, 3, 2, 8, 11, 4);
        // 求和方式1
        Optional<Integer> sum = list3.stream().reduce((x, y) -> x + y);
        // 求和方式2
        Optional<Integer> sum2 = list3.stream().reduce(Integer::sum);
        // 求和方式3
        Integer sum3 = list3.stream().reduce(0, Integer::sum);

        // 求乘积
        Optional<Integer> product = list3.stream().reduce((x, y) -> x * y);

        // 求最大值方式1
        Optional<Integer> max2 = list3.stream().reduce((x, y) -> x > y ? x : y);
        // 求最大值写法2
        Integer max3 = list3.stream().reduce(1, Integer::max);

        System.out.println("list求和：" + sum.get() + "," + sum2.get() + "," + sum3);
        System.out.println("list求积：" + product.get());
        System.out.println("list求和：" + max2.get() + "," + max3);

        // 求所有员工的工资之和和最高工资。
        Optional<Integer> reduce = personList.stream().map(Person::getSalary).reduce(Integer::sum);
        Integer reduce1 = personList.stream().reduce(0, (maxSalary, p) -> p.getSalary() > maxSalary ? p.getSalary() : maxSalary, Integer::max);
        System.out.println(reduce.get());
        System.out.println(reduce1);

        List<Integer> list4 = Arrays.asList(1, 6, 3, 4, 6, 7, 9, 6, 20);
        List<Integer> listNew = list4.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
        Set<Integer> set = list.stream().filter(x -> x % 2 == 0).collect(Collectors.toSet());

        List<Person> personList2 = new ArrayList<Person>();
        personList2.add(new Person("Tom", 8900, 23, "male", "New York"));
        personList2.add(new Person("Jack", 7000, 25, "male", "Washington"));
        personList2.add(new Person("Lily", 7800, 21, "female", "Washington"));
        personList2.add(new Person("Anni", 8200, 24, "female", "New York"));

        Map<?, Person> map = personList2.stream().filter(p -> p.getSalary() > 8000)
                                       .collect(Collectors.toMap(Person::getName, p -> p));
        System.out.println("toList:" + listNew);
        System.out.println("toSet:" + set);
        System.out.println("toMap:" + map);

        // 统计(count/averaging)
//        计数：count
//        平均值：averagingInt、averagingLong、averagingDouble
//        最值：maxBy、minBy
//        求和：summingInt、summingLong、summingDouble
//        统计以上所有：summarizingInt、summarizingLong、summarizingDouble

        // 求总数
        Long count2 = personList.stream().collect(Collectors.counting());
        // 求平均工资
        Double average = personList.stream().collect(Collectors.averagingDouble(Person::getSalary));
        // 求最高工资
        Optional<Integer> max5 = personList.stream().map(Person::getSalary).collect(Collectors.maxBy(Integer::compare));
        // 求工资之和
        Integer sum5 = personList.stream().collect(Collectors.summingInt(Person::getSalary));
        // 一次性统计所有信息
        DoubleSummaryStatistics collect5 = personList.stream().collect(Collectors.summarizingDouble(Person::getSalary));

        System.out.println("员工总数：" + count2);
        System.out.println("员工平均工资：" + average);
        System.out.println("员工工资总和：" + sum5);
        System.out.println("员工工资所有统计：" + collect5);


        // 分组(partitioningBy/groupingBy)
        // 将员工按薪资是否高于8000分为两部分；将员工按性别和地区分组
        Map<Boolean, List<Person>> collect6 = personList2.stream().collect(Collectors.partitioningBy(x -> x.getSalary() > 8000));
        System.out.println(collect6);
        System.out.println(collect6.get(true));

        Map<String, Map<String, List<Person>>> collect7 = personList2.stream().collect(Collectors.groupingBy(x -> x.getSex(), Collectors.groupingBy(x -> x.getArea())));
        System.out.println(collect7.get("male").get("New York"));

        // 接合(joining)
        String names = personList.stream().map(p -> p.getName()).collect(Collectors.joining(","));
        System.out.println("所有员工的姓名：" + names);
        List<String> list5 = Arrays.asList("A", "B", "C");
        String string = list5.stream().collect(Collectors.joining("-"));
        System.out.println("拼接后的字符串：" + string);

        // 归约(reducing) Collectors类提供的reducing方法，相比于stream本身的reduce方法，增加了对自定义归约的支持。
        Integer sum4 = personList.stream().collect(Collectors.reducing(0, Person::getSalary, (i, j) -> (i + j - 5000)));
        System.out.println("员工扣税薪资总和：" + sum4);
        // stream的reduce
        Optional<Integer> sum25 = personList.stream().map(Person::getSalary).reduce(Integer::sum);
        System.out.println("员工薪资总和：" + sum25.get());

        //  排序(sorted)
        // 按工资升序排序（自然排序）
        List<String> newList = personList.stream().sorted(Comparator.comparing(Person::getSalary)).map(Person::getName)
                                         .collect(Collectors.toList());
        // 按工资倒序排序
        List<String> newList2 = personList.stream().sorted(Comparator.comparing(Person::getSalary).reversed())
                                          .map(Person::getName).collect(Collectors.toList());
        // 先按工资再按年龄升序排序
        List<String> newList3 = personList.stream()
                                          .sorted(Comparator.comparing(Person::getSalary).thenComparing(Person::getAge)).map(Person::getName)
                                          .collect(Collectors.toList());
        // 先按工资再按年龄自定义排序（降序）
        List<String> newList4 = personList.stream().sorted((p1, p2) -> {
            if (p1.getSalary() == p2.getSalary()) {
                return p2.getAge() - p1.getAge();
            } else {
                return p2.getSalary() - p1.getSalary();
            }
        }).map(Person::getName).collect(Collectors.toList());

        System.out.println("按工资升序排序：" + newList);
        System.out.println("按工资降序排序：" + newList2);
        System.out.println("先按工资再按年龄升序排序：" + newList3);
        System.out.println("先按工资再按年龄自定义降序排序：" + newList4);

        // 流也可以进行合并、去重、限制、跳过等操作。
        String[] arr1 = { "a", "b", "c", "d" };
        String[] arr2 = { "d", "e", "f", "g" };

        Stream<String> stream1 = Stream.of(arr1);
        Stream<String> stream2 = Stream.of(arr2);
        // concat:合并两个流 distinct：去重
        List<String> newList1 = Stream.concat(stream1, stream2).distinct().collect(Collectors.toList());
        // limit：限制从流中获得前n个数据
        List<Integer> collect52 = Stream.iterate(1, x -> x + 2).limit(10).collect(Collectors.toList());
        // skip：跳过前n个数据
        List<Integer> collect23 = Stream.iterate(1, x -> x + 2).skip(1).limit(5).collect(Collectors.toList());

        System.out.println("流合并：" + newList1);
        System.out.println("limit：" + collect52);
        System.out.println("skip：" + collect23);
    }

    static class Person {
        private String name;  // 姓名
        private int salary; // 薪资
        private int age; // 年龄
        private String sex; //性别
        private String area;  // 地区

        // 构造方法
        public Person(String name, int salary, int age, String sex, String area) {
            this.name = name;
            this.salary = salary;
            this.age = age;
            this.sex = sex;
            this.area = area;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getSalary() {
            return salary;
        }

        public void setSalary(int salary) {
            this.salary = salary;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", salary=" + salary +
                    ", age=" + age +
                    ", sex='" + sex + '\'' +
                    ", area='" + area + '\'' +
                    '}';
        }
    }
}



