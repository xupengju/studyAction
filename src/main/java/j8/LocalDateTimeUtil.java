package j8;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

/**
 * @author Milo on 2021/7/5.
 * @description
 */
public class LocalDateTimeUtil {

    public static void main(String[] args) {
        int[] array = new int[10];
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate from = LocalDate.parse("2012-01-02", formatter);
        LocalDate now = LocalDate.parse(LocalDate.now().toString(), formatter);

        int years = now.getYear() - from.getYear();
        System.out.println(from.getYear());
        for (int i = 0; i <= years ;i++) {
            array[i] = now.getYear() - i;
        }

        System.out.println(Arrays.toString(array));
    }
}

