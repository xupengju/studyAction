package j8;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Milo on 2021/6/29.
 * @description
 */
public class FunctionTest {


    public static void main(String[] args) {
        //① 使用consumer接口实现方法
        Consumer<String> consumer = new Consumer<String>() {

            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };


        Stream<String> stream = Stream.of("cc", "aa");
        stream.forEach(consumer);


        stream = Stream.of("aaa", "bbb", "ddd", "ccc", "fff");
        Consumer<String> consumer1 = System.out::println;
        stream.forEach(consumer1);


        Supplier<Integer> supplier = new Supplier<Integer>() {

            @Override
            public Integer get() {
                return new Random().nextInt();
            }
        };

        System.out.println(supplier.get());

        supplier = () -> new Random().nextInt(10);

        System.out.println(supplier.get());

        Supplier<Double> supplier2 = new Supplier<Double>() {

            @Override
            public Double get() {
                return Math.random();
            }
        };
        System.out.println(supplier2);
        supplier2 = Math::random;
        System.out.println(supplier2.get());


        Stream<String> stringStream = Stream.of("1", "2", "3");
        Optional<Integer> first = stringStream.map(Integer::valueOf).filter(i -> i > 4).findFirst();

        System.out.println(first.orElse(7));
        System.out.println(first.orElseGet(supplier));


        IntSupplier intSupplier = new IntSupplier() {

            @Override
            public int getAsInt() {
                return new Random().nextInt();
            }
        };

        System.out.println(first.orElse(intSupplier.getAsInt()));


        Predicate<Integer> predicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer o) {
                return o > 5;
            }
        };

        System.out.println(predicate.test(1));
        Stream<Integer> stream2 = Stream.of(1, 23, 3, 4, 5, 56, 6, 6);

        List<Integer> list = stream2.filter(predicate).collect(Collectors.toList());

        System.out.println(list);

        Function<String ,Integer> function = new Function<String ,Integer>() {
            @Override
            public Integer apply(String string) {
                return string.length();
            }
        };

        Stream<String> stringStream1 = Stream.of("123", "123333", "33333333");
        Stream<Integer> integerStream = stringStream1.map(function);
        integerStream.forEach(System.out::print);

    }


}
