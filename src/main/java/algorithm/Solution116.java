package algorithm;



import java.util.ArrayList;
import java.util.List;

/**
 * @author Milo on 2021/12/6.
 * @description 116. 填充每个节点的下一个右侧节点指针
 */
public class Solution116 {

    public Node connect(Node root) {
        if (root == null) return null;
        connectTwoNode(root.left, root.right);
        return root;
    }


    // 辅助函数
    void connectTwoNode(Node node1, Node node2) {
        if (node1 == null || node2 == null) {
            return;
        }

        // 将传入的两个节点连接
        node1.next = node2;

        // 连接相同父节点的两个子节点
        connectTwoNode(node1.left, node1.right);
        connectTwoNode(node2.left, node2.right);
        // 连接跨越父节点的两个子节点
        connectTwoNode(node1.right, node2.left);
    }



    public static void bfs(int level, TreeNode treeNode, List<List<Integer>> res) {
        if (res.size() < level) {
            res.add(new ArrayList<Integer>());
        }
        res.get(level - 1).add(treeNode.val);

        if (treeNode.left != null) {
            bfs(level + 1, treeNode.left, res);
        }

        if (treeNode.right != null) {
            bfs(level + 1, treeNode.right, res);
        }
    }


    public static void main(String[] args) {

    }

}



