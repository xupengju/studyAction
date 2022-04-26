package algorithm;

/**
 * @author Milo on 2021/12/6.
 * @description 翻转二叉树
 */
public class Solution226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return null;
        }

        // root 节点需要交换它的左右子节点
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        // 让左右子节点继续翻转它们的子节点
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

}
