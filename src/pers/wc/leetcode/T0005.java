package pers.wc.leetcode;

public class T0005 {
    public static void main(String[] args) {
        String s = "a";
        System.out.println(longestPalindrome(s));
    }

    /**
     * 最长回文子串
     *
     * @param s 给定字符串   babad
     * @return 给定字符串中的最长回文子串    bab/aba
     */
    public static String longestPalindrome(String s) {
        int len = s.length();
        int longest = 0;
        String resStr = "";
        for (int i = 0; i < len; i++) {
            for (int j = len - 1; j >= i; j--) {
                if (j - i + 1 <= longest) {
                    break;
                }
                String tempStr = s.substring(i, j + 1);
                if (isPalindrome(tempStr) && (j - i + 1) > longest) {
                    longest = j - i + 1;
                    resStr = tempStr;
                }
            }
        }
        return resStr;
    }

    /**
     * 判断给定字符串是否会文
     *
     * @param s 给定字符串
     * @return 是否回文
     */
    public static boolean isPalindrome(String s) {
        int len = s.length();
        boolean res = true;
        int begin = 0;
        int end = len - 1;
        while (res && begin <= end) {
            if (s.charAt(begin) != s.charAt(end)) {
                res = false;
            }
            begin++;
            end--;
        }
        return res;
    }
}
