package pers.wc.leetcode;

import java.util.*;

public class T0438 {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        // [0,6]
        System.out.println(findAnagrams_1(s, p));
        System.out.println(findAnagrams_2(s, p));
    }

    /**
     * 找到字符串中所有字母异位词，异位词：指由相同字母重排列形成的字符串（包括相同的字符串）。
     *
     * @param s 字符串
     * @param p 目标串（异位词）
     * @return 返回子串的起始索引
     */
    public static List<Integer> findAnagrams_1(String s, String p) {
        char[] chp = p.toCharArray();
        Arrays.sort(chp);
        int lenS = s.length();
        int lenP = p.length();
        int cur = 0;
        List<Integer> res = new ArrayList<>();
        while (cur <= lenS - lenP) {
            String subS = s.substring(cur, cur + lenP);
            char[] tempCh = subS.toCharArray();
            Arrays.sort(tempCh);
            int diff = 0;
            for (int i = 0; i < chp.length; i++) {
                if (chp[i] != tempCh[i]) {
                    diff++;
                }
            }
            if (diff == 0) {
                res.add(cur);
            }
            cur++;
        }
        return res;
    }


    // 异位表示成两个字符串中的每个字符出现的频数相同
    public static List<Integer> findAnagrams_2(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int lenS = s.length();
        int lenP = p.length();
        int[] countP = new int[26];
        // 统计目标串中各字符出现的频数
        for (int i = 0; i < lenP; i++) {
            countP[p.charAt(i) - 'a']++;
        }
        // 窗口左右边界
        int left = 0;
        int right = 0;
        int[] window = new int[26];
        while (right < lenS) {
            window[s.charAt(right) - 'a']++;
            while (right - left + 1 == lenP) {
                if (Arrays.equals(window, countP)) {
                    res.add(left);
                }
                window[s.charAt(left) - 'a']--;
                left++;
            }
            right++;
        }
        return res;
    }
}
