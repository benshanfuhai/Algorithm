package pers.wc.leetcode;

import java.util.HashMap;

public class T0003 {
    public static void main(String[] args) {
        // String s = "abcabcbb";
        // String s = "pwwkew";
        // String s = "a";
        String s = "abba";
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
        // Key: s中的字符; Value: 字符的下标，在移动left的时候起作用
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            // 如果map中存在字符，则移动left到该字符的右边
            if (map.containsKey(s.charAt(right))) {
                // 取max,因为left可能已经移到了较大的位置，如果之后再遇到了index较小的相同的字符，需要移动到此时最大的left值，如abba
                left = Math.max(left, map.get(s.charAt(right)) + 1);
            }
            map.put(s.charAt(right), right);
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}
