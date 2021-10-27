package pers.wc.leetcode;

import java.util.HashMap;

public class T0003 {
    public static void main(String[] args) {
        // String s = "abcabcbb";
        String s = "pwwkew";
        // String s = "a";
        // 3
        System.out.println(lengthOfLongestSubstring(s));
    }


    /**
     * 无重复字符的最长子串
     *
     * @param s 字符串
     * @return 不含有重复字符的 最长子串 的长度
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;

        }
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            if (map.containsKey(s.charAt(right))) {
                left = Math.max(left, map.get(s.charAt(right)) + 1);
            }
            map.put(s.charAt(right), right);
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}
