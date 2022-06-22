package pers.wc.leetcode;

import java.util.Arrays;

public class T1662 {
    public static void main(String[] args) {
        String[] word1 = {"ab", "c"};
        String[] word2 = {"a", "bc"};
        // {"ab", "c"}  {"a", "bc"} true
        System.out.println(arrayStringsAreEqual(word1, word2));
    }

    /**
     * 检测两个字符串数组是否相等，数组表示的字符串是由数组中的所有元素按顺序连接形成的字符串。
     *
     * @param word1 字符串数组
     * @param word2 字符串数组
     * @return 若两个数组表示的字符串相同，则返回 true，否则返回 false。
     */
    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        return Arrays.toString(word1).replaceAll(", ", "").equals(Arrays.toString(word2).replaceAll(", ", ""));
    }
}
