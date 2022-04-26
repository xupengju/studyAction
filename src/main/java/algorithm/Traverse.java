package algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Milo on 2021/10/19.
 * @description
 */
public class Traverse {
    private static List<Integer> result = new ArrayList();

    // 递归遍历二叉树
    public static List<Integer> inorderTraversal(TreeNode root) {

        if (root != null) {
            result.add(root.val);
            inorderTraversal(root.left);
            inorderTraversal(root.right);
        }
        return result;
    }

    // 栈 先入后出 中序遍历
    public static List<Integer> inorderTraversalByStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();

        while (root != null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            result.add(root.val);
            root = root.right;
        }
        return result;
    }

    public static List<Integer> beforeOrderTraversalByStack(TreeNode root) {

        if (root == null){
            return result;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();

        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode pop = stack.pop();
            result.add(pop.val);

            if (pop.right != null)
                stack.push(pop.right);

            if (pop.left != null)
                stack.push(pop.left);


        }
        return result;
    }

    public static List<Integer> afterOrderTraversalByStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();

        while (root != null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            result.add(root.val);
            root = root.right;
        }
        return result;
    }

    //[5,4,6,null,null,3,7]
    public static void main(String[] args) {
        TreeNode left11 = new TreeNode(8);
        TreeNode left12 = new TreeNode(9);

        TreeNode right11 = new TreeNode(3);
        TreeNode right12 = new TreeNode(7);
        TreeNode left1 = new TreeNode(4, left11, left12);
        TreeNode right1 = new TreeNode(6, right11, right12);
        TreeNode root = new TreeNode(5, left1, right1);
        inorderTraversal(root);
        System.out.println(result);
    }
}
