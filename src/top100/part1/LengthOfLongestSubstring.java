package top100.part1;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @Description: 3-无重复字符的最长子串（滑动窗口）
 * @Author: Fang Xiaojun
 * @Date: 2023/2/17
 * @Version: V1.0
 */
public class LengthOfLongestSubstring {

    // 暴力模拟+剪枝
    public static int lengthOfLongestSubstring1(String s) {
        if (s.length() == 0) return 0;
        int len = s.length();
        int res = 1;
        for (int i = 0; i < len && len-i > res; ++i) {
            HashSet<Character> set = new HashSet<>();
            set.add(s.charAt(i));
            int j = i + 1;
            while (j < len && !set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
            }
            res = Math.max(j-i, res);
        }
        return res;
    }

    // 滑动窗口
    public static int lengthOfLongestSubstring2(String s) {
        if (s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0, j = 0; j < s.length(); ++j) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(i, map.get(s.charAt(j))+1);
            }
            map.put(s.charAt(j), j);
            res = Math.max(res, j-i+1);
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "aab";
        System.out.println(lengthOfLongestSubstring2(s));
    }

}
