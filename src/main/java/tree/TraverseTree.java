package tree;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Milo on 2021/10/18.
 * @description
 */
public class TraverseTree {

    // 前序遍历二叉树
    public static void preTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.getData());
        if (root.getLeft() != null)
            preTraverse(root.getLeft());
        if (root.getRight() != null)
            preTraverse(root.getRight());
    }


    // 中序遍历二叉树
    public static void midTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.getLeft() != null)
            midTraverse(root.getLeft());
        System.out.println(root.getData());
        if (root.getRight() != null)
            midTraverse(root.getRight());
    }

    // 后续遍历二叉树
    public static void afterTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.getLeft() != null)
            afterTraverse(root.getLeft());
        if (root.getRight() != null)
            afterTraverse(root.getRight());
        System.out.println(root.getData());
    }

    // 层级遍历二叉树
    public static void levelTraverse(TreeNode root, int level, List<List<String>> res) {
        System.out.println(res);
        if (res.size() < level) {
            res.add(new ArrayList<String>());
        }

        res.get(level - 1).add((String) root.getData());
        if (root.getLeft() != null) {
            levelTraverse(root.getLeft(), level + 1, res);
        }

        if (root.getRight() != null) {
            levelTraverse(root.getRight(), level + 1, res);
        }
    }

    // 非递归遍历二叉树
    public static void stackTraverse(TreeNode root) {

    }

    // 高度

    // 节点数


    public static void main(String[] args) {
        TreeNode<String> root = new TreeNode<>();
        TreeNode<String> left11 = new TreeNode<>();
        TreeNode<String> left12 = new TreeNode<>();
        TreeNode<String> left1 = new TreeNode<>();
        TreeNode<String> right11 = new TreeNode<>();
        TreeNode<String> right12 = new TreeNode<>();
        TreeNode<String> right1 = new TreeNode<>();

        root.setData("1");
        left1.setData("2");
        right1.setData("3");
        left11.setData("4");
        left12.setData("5");
        right11.setData("6");
        right12.setData("7");
        root.setLeft(left1);
        left1.setLeft(left11);
        left1.setRight(left12);

        root.setRight(right1);
        right1.setLeft(right11);
        right1.setRight(right12);


        //afterTraverse(root);
        List<List<String>> res = Lists.newArrayList();
        levelTraverse(root, 1, res);
        System.out.println(res);
    }
}

class TreeNode<T> {
    private TreeNode left;

    private T data;

    private TreeNode right;

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "left=" + left +
                ", data=" + data +
                ", right=" + right +
                '}';
    }
}
