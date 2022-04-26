package algorithm;

/**
 * @author Milo on 2021/11/30.
 * @description 114. 二叉树展开为链表
 */
public class Solution114 {


    public static void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.left);
        flatten(root.right);
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        root.right = left;
        TreeNode t = root;
        while (t.right!=null){
            t = t.right;
        }
        t.right = right;
    }

    public static void main(String[] args) {
        TreeNode left11 = new TreeNode(3);
        TreeNode left12 = new TreeNode(4);

        TreeNode right12 = new TreeNode(6);
        TreeNode left1 = new TreeNode(2, left11, left12);
        TreeNode right1 = new TreeNode(5, null, right12);
        TreeNode root = new TreeNode(1, left1, right1);
        flatten(root);
        System.out.println(Traverse.inorderTraversal(root));
    }
}
