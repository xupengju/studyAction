package algorithm;

import java.util.Arrays;

/**
 * @author Milo on 2022/3/9.
 * @description
 */
public class QuickSort {


    public static void quickSort1(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int partition = partition(arr, left, right);
        quickSort1(arr, left, partition - 1);
        quickSort1(arr, partition + 1, right);
    }

    public static int partition(int[] arr, int left, int right) {
        int le = left;
        int p = arr[left];
        for (int i = left + 1; i <= right; i++) {
            if (arr[i] < p) {
                le++;
                swap(arr, i, le);
            }
        }

        swap(arr, left, le);

        return le;
    }


    private static void swap(int[] nums, int index1, int index2) {
        System.out.println(Arrays.toString(nums));
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
