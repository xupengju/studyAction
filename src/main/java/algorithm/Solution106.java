package algorithm;

/**
 * @author Milo on 2021/11/26.
 * @description 106. 从中序与后序遍历序列构造二叉树
 */
public class Solution106 {

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public static TreeNode build(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (postStart > postEnd) {
            return null;
        }

        int  index = 0;
        int rootVal = postorder[postEnd];
        for (int i = inStart ; i <= inEnd;i++){
            if (inorder[i] == rootVal){
                index = i;
                break;
            }
        }

        TreeNode root = new TreeNode(rootVal);
        int leftSize = index - inStart;
        root.left = build(inorder,inStart,index-1,postorder,postStart,postStart + leftSize -1);
        root.right = build(inorder,index+1,inEnd,postorder,postStart + leftSize,postEnd -1);
        return root;
    }

    /**
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * @param args
     */
    public static void main(String[] args) {
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3}; // 左右根

        System.out.println(buildTree(inorder, postorder));
    }
}
