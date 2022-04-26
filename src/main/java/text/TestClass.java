package text;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Milo on 2022/4/6.
 * @description
 */
public class TestClass {

    // 整形数组  元素个数 1000 个   元素范围 0-1000  有重复  入参数组  去重 出参数组 12234  1234

    public static void main(String[] args) {
        int[] ints = {1, 2, 2, 3, 3, 4};
        System.out.println(Arrays.toString(remove1(ints)));

        int[] c = {1, 2, 3, 4};
        int[] a = new int[2];
        int[] b = new int[2];
        System.arraycopy(c, 0, a, 0, 2);
        System.arraycopy(c, 2, b, 0, 2);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        System.out.println(isHal());
    }

    public static int[] remove(int[] arr) {
        if (Objects.isNull(arr) || arr.length == 0) {
            return arr;
        }
        int length = arr.length;
        List<Integer> list = Lists.newArrayList();
        for (int i = 0; i < length; i++) {
            System.out.println(arr[i]);
            if (!list.contains(arr[i])) {
                list.add(arr[i]);
            }
        }

        return list.stream().mapToInt(Integer::valueOf).toArray();
    }

    public static boolean isHal() {
        ArrayList<String> objects1 = Lists.newArrayList();
        objects1.add("1");
        objects1.add("2");
        CopyOnWriteArrayList<String> objects = new CopyOnWriteArrayList<>(objects1);

        for (String s : objects) {
            objects.remove("1");
        }
        System.out.println(objects);
        return false;
    }


    public static int[] remove1(int[] arr) {

        int length = arr.length;
        int currentIndex = 0;
        int nextIndex = 1;

        // 1223341  1234*23  1234
        // [1, 2, 3, 4, 3, 4]
        for (int i = 0; i < length; i++) {
            int value1 = arr[currentIndex];

            if (nextIndex == length) {
                break;
            }
            int value2 = arr[nextIndex];

            if (value1 != value2) {
                arr[currentIndex + 1] = arr[nextIndex];
                currentIndex = currentIndex + 1;
            }


            nextIndex++;
        }

        return Arrays.copyOfRange(arr, 0, currentIndex + 1);
    }


}
