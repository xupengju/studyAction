package algorithm;

import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author Milo on 2021/11/26.
 * @description 111. 二叉树的最小深度
 */
public class Solution111 {


    public static int minDepth(TreeNode root) {

        Set<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> q = new LinkedBlockingDeque<>();
        if (root == null) {
            return 0;
        }
        q.offer(root);
        visited.add(root);
        // 记录扩散的步数
        int step = 1;
        while (q.size() > 0) {
            int sz = q.size();

            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.poll();
                if (cur == null){
                    continue;
                }
                if (cur.right == null && cur.left == null) {
                    return step;
                }

                TreeNode left = cur.left;
                TreeNode right = cur.right;

                if (left!= null &&!visited.contains(left)) {
                    q.offer(left);
                    visited.add(left);
                }

                if (right!= null &&!visited.contains(right)) {
                    q.offer(right);
                    visited.add(right);
                }

            }
            step = step + 1;

        }
        return step;
    }


    public static void main(String[] args) {
        //TreeNode treeNode = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        TreeNode treeNode = new TreeNode(2, null, new TreeNode(3, null,new TreeNode(4, null,new TreeNode(5, null,null))));
        // [2,null,3,null,4,null,5,null,6]
        System.out.println(minDepth(treeNode));

    }
}
