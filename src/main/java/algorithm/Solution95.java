package algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Milo on 2021/11/23.
 * @description 不同的二叉搜索树二
 */
public class Solution95 {

    public static List<TreeNode> generateTrees(int n) {
       return build(1,n);
    }

    public static List<TreeNode> build(int lo , int hi){
        List<TreeNode> res = new LinkedList<>();
        // base case
        if (lo > hi) {
            res.add(null);
            return res;
        }

        for (int i = lo ; i <= hi ; i ++){
            List<TreeNode> left = build(lo,i-1);
            List<TreeNode> right = build(i+1,hi);

            for (TreeNode leftNode: left){
                for (TreeNode rightNode : right){
                    res.add(new TreeNode(i, leftNode, rightNode));
                }
            }
        }

        return res;
    }


    public static void main(String[] args) {
        List<TreeNode> treeNodes = generateTrees(3);
        System.out.println(treeNodes);
    }
}
