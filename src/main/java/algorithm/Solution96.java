package algorithm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Milo on 2021/11/23.
 * @description 不同的二叉搜索树
 */
public class Solution96 {

    static Map<String,Integer> maps = new HashMap<>();

    public static int numTrees(int n) {
        return count(1,n);
    }

    public static int count(int lo , int hi){
        if (lo > hi){
            return 1;
        }

        int sum = 0;
        for (int i = lo; i <= hi; i++){

            if (maps.containsKey(lo +"_"+hi)) {
                return maps.get(lo +"_"+hi);
            }

            int left = count(lo,i-1);
            int right = count(i+1,hi);

            sum += left * right;
        }
        maps.put(lo +"_"+hi,sum);
        return sum;
    }


    public static void main(String[] args) {
        System.out.println(numTrees(18));
    }
}
