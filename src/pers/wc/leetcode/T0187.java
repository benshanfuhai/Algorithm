package pers.wc.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class T0187 {
    public static void main(String[] args) {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        // ["AAAAACCCCC","CCCCCAAAAA"]
        System.out.println(findRepeatedDnaSequences(s));
    }


    /**
     * 重复的DNA序列
     *
     * @param s 一段 DNA 序列，由 'A'，'C'，'G' 和 'T' 组成
     * @return 返回所有目标子串，且目标子串的长度为 10
     */
    public static List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        HashMap<String, Integer> count = new HashMap<>();
        int len = s.length();
        for (int i = 0; i < len - 10; i++) {
            String substring = s.substring(i, i + 10);
            count.put(substring, count.getOrDefault(substring, 0) + 1);
            if (count.get(substring) == 2) {
                result.add(substring);
            }
        }
        return result;
    }
}