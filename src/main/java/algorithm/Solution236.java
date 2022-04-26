package algorithm;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Milo on 2021/12/14.
 * @description 236. 二叉树的最近公共祖先
 */
public class Solution236 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // 两种情况的 base case
        if (root == null) return null;
        if (root == p || root == q) return root;


        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 情况 1 如果p和q都在以root为根的树中，那么left和right一定分别是p和q（从 base case 看出来的）。
        if (left != null && right != null) {
            return root;
        }
        // 情况 2 如果p和q都不在以root为根的树中，直接返回null。
        if (left == null && right == null) {
            return null;
        }
        // 情况 3 如果p和q只有一个存在于root为根的树中，函数返回该节点。
        return left == null ? right : left;
    }


    static TreeNode re ;
    public static void findMe(TreeNode root, int p){

        if (root == null){
            return ;
        }

        if (root.val == p){
             re = root;
        }
        System.out.println(root.val +" " + p);
        findMe(root.left, p);
        findMe(root.right, p);
    }


    public static void main(String[] args) {
        TreeNode left11 = new TreeNode(3);
        TreeNode left12 = new TreeNode(4);

        TreeNode right12 = new TreeNode(6);
        TreeNode left1 = new TreeNode(2, left11, left12);
        TreeNode right1 = new TreeNode(5, null, right12);
        TreeNode root = new TreeNode(1, left1, right1);

        findMe(root, 2);
        System.out.println(re);
    }
}
