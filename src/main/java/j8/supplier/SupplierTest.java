package j8.supplier;

import java.util.function.Supplier;

/**
 * @author Milo on 2021/11/2.
 * @description
 */
public class SupplierTest {

    public static void main(String[] args) {
        Supplier<Integer> supplier = () -> 10 + 1;
        //System.out.println(supplier.get() + 1);

        Lazy< Integer> a = Lazy.of(() -> 10 + 1);
        int b = a.get() + 1;
        // get 不会再重新计算, 直接用缓存的值
        int c = a.get();

        System.out.println(b);
        System.out.println(c);
    }
}
