package j8.supplier;

import java.util.function.Supplier;

/**
 * @author Milo on 2021/11/2.
 * @description
 */
public class Lazy<T> implements Supplier<T> {

    private T value;

    private final Supplier<? extends T> supplier;

    public Lazy(Supplier<? extends T> supplier) {
        this.supplier = supplier;
    }

    public static <T> Lazy<T> of(Supplier<? extends T> supplier) {
        return new Lazy<T>(supplier);
    }

    @Override
    public T get() {
        System.out.println("value" + value);
        if (value == null) {
            T newValue = supplier.get();

            if (newValue == null) {
                throw new IllegalStateException("Lazy value can not be null!");
            }

            value = newValue;
        }

        return value;
    }
}
