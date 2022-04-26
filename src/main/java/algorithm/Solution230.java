package algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Milo on 2021/12/6.
 * @description 230. 二叉搜索树中第K小的元素
 */
public class Solution230 {

    static  int  ra = 0;
    static  int  re = 0;
    public static int kthSmallest(TreeNode root, int k) {
        read(root,k);
        return re;
    }

    public static void read(TreeNode root, int k){
        if (null == root){
            return ;
        }
        read(root.left,k);
        ra ++;
        if (k == ra){
            re = root.val;
        }

       read(root.right,k);

    }

    public static void main(String[] args) {
        int i = kthSmallest(new TreeNode(3, new TreeNode(1, null, new TreeNode(2)), new TreeNode(4)),1);
        System.out.println(i);
    }

}
