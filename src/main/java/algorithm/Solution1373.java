package algorithm;

/**
 * 1373. 二叉搜索子树的最大键值和
 * @author Milo on 2021/12/14.
 * @description
 */
public class Solution1373 {

//    int maxSum = 0;
//
//
//    traverse(root);
//    return maxSum;
//    public int maxSumBST(TreeNode root) {
//
//
//        traverse(root);
//        return maxSum;
//
//
//
//    }
//
//    private void traverse(TreeNode root) {
//        if (root == null) {
//            return;
//        }
//        /******* 前序遍历位置 *******/
//        // 判断左右子树是不是 BST
//        if (!isBST(root.left) || !isBST(root.right)) {
//            goto next;
//        }
//
//        // 计算左子树的最大值和右子树的最小值
//        int leftMax = findMax(root.left);
//        int rightMin = findMin(root.right);
//        // 判断以 root 节点为根的树是不是 BST
//        if (root.val <= leftMax || root.val >= rightMin) {
//            goto next;
//        }
//
//        // 如果条件都符合，计算当前 BST 的节点之和
//        int leftSum = findSum(root.left);
//        int rightSum = findSum(root.right);
//        int rootSum = leftSum + rightSum + root.val;
//
//
//        // 计算 BST 节点的最大和
//        this.maxSum = Math.max(maxSum, rootSum);
//
//        maxSumBST(root.left);
//        maxSumBST(root.right);
//    }
//
//
//    /* 计算以 root 为根的二叉树的最大值 */
//    int findMax(TreeNode root) {}
//
//    /* 计算以 root 为根的二叉树的最小值 */
//    int findMin(TreeNode root) {}
//
//    /* 计算以 root 为根的二叉树的节点和 */
//    int findSum(TreeNode root) {}
//
//    /* 判断以 root 为根的二叉树是否是 BST */
//    boolean isBST(TreeNode root) {}
}
