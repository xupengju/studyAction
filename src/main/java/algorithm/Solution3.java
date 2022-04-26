package algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Milo on 2022/3/8.
 * @description
 */
public class Solution3 {
    public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        int start = 0;

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                start = Math.max(start, map.get(c) + 1);
            }

            map.put(c, i);
            max = Math.max(max, i - start + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        lengthOfLongestSubstring("pwwkew");
    }
}
