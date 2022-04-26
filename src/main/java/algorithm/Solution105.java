package algorithm;

/**
 * @author Milo on 2021/11/25.
 * @description 105. 从前序与中序遍历序列构造二叉树
 */
public class Solution105 {

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
    }

    public static TreeNode build(int[] preorder, int preStart, int preEnd,
                                 int[] inorder, int inStart, int inEnd) {

        if (preStart > preEnd) {
            return null;
        }

        int rootval = preorder[preStart];
        int index = 0;
        // 寻找中序遍历根节点的位置 确定左右子树
        for (int i = 0; i <= inEnd; i++) {
            if (rootval == inorder[i]) {
                index = i;
                break;
            }
        }

        TreeNode root = new TreeNode(rootval);
        // 递归构造左右子树
        int leftSize = index - inStart;
        root.left = build(preorder, preStart + 1, preStart + leftSize, inorder, inStart, index - 1);

        root.right = build(preorder, preStart + leftSize + 1, preEnd, inorder, index + 1, inEnd);
        return root;
    }


    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        System.out.println(buildTree(preorder, inorder));
    }
}
