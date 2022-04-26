package algorithm;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Milo on 2021/12/6.
 * @description 652. 寻找重复的子树
 */
public class Solution652 {

    static HashMap<String, Integer> map = new HashMap<>();
    static List<TreeNode> nodes = new ArrayList<>();

    public static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return nodes;
    }

    private static String traverse(TreeNode root) {
        if (root == null) {
            return "#";
        }
        String left = traverse(root.left);
        String right = traverse(root.right);

        String zz = left + "," + right + "," + root.val;


        Integer orDefault = map.getOrDefault(zz, 0);
        if (orDefault == 1) {
            nodes.add(root);
        }

        map.put(zz, orDefault + 1);
        return zz;
    }

    public static void main(String[] args) {

    }
}
