package algorithm;

/**
 * @author Milo on 2021/11/24.
 * @description 验证二叉搜索树
 */
public class Solution98 {


//    public static boolean isValidBST(TreeNode root) {
//        if (root == null) {
//            return true;
//        }
//
//        if (root.left != null && root.left.val >= root.val) {
//            return false;
//        }
//
//        if (root.right != null && root.right.val <= root.val) {
//            return false;
//        }
//
//        Boolean left = isValidBST(root.left);
//
//        Boolean right = isValidBST(root.right);
//
//        return left && right;
//
//    }
    // 出现问题的原因在于，对于每一个节点 root，代码值检查了它的左右孩子节点是否符合左小右大的原则；但是根据 BST 的定义，root 的整个左子树都要小于 root.val，整个右子树都要大于 root.val。

    public static boolean isValidBST(TreeNode root) {
       return isValidBST(root,null,null);

    }

    public  static boolean isValidBST(TreeNode root,TreeNode min ,TreeNode max){
        if (root == null) {
            return true;
        }

        if (min != null && min.val > root.val){
            return false;
        }

        if (max != null && max.val < root.val){
            return false;
        }

        Boolean left = isValidBST(root.left,min,root);

        Boolean right = isValidBST(root.right,root,max);

        return left && right;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(0, new TreeNode(-1), null);
        System.out.println(isValidBST(treeNode));
    }
}
