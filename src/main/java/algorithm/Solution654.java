package algorithm;

import java.util.Arrays;

/**
 * @author Milo on 2021/12/6.
 * @description 654. 最大二叉树
 */
public class Solution654 {

    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0){
            return null;
        }
        int max = nums[0];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max){
                max = nums[i];
                index = i;
            }
        }

        int[] left = Arrays.copyOfRange(nums,0,index);
        int[] right= Arrays.copyOfRange(nums,index+1,nums.length);

        return new TreeNode(max,constructMaximumBinaryTree(left),constructMaximumBinaryTree(right));

    }

    public static void main(String[] args) {
        int[] arr = {1,3,2,1,1};
        TreeNode treeNode = constructMaximumBinaryTree(arr);
        System.out.println(treeNode);
    }
}
