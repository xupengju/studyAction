package algorithm;

/**
 * @author Milo on 2021/12/6.
 * @description 222. 完全二叉树的节点个数
 */
public class Solution222 {

    public static int countNodes(TreeNode root) {
        if (null == root){
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public static void main(String[] args) {
        int i = countNodes(new TreeNode(1, new TreeNode(2, null, new TreeNode(3)), new TreeNode(3)));
        System.out.println(i);
    }
}
