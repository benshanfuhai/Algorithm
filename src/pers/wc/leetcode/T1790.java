package pers.wc.leetcode;

public class T1790 {
    public static void main(String[] args) {
        String s1 = "bank";
        String s2 = "kanb";
        System.out.println(areAlmostEqual(s1, s2));
    }

    /**
     * 仅执行一次字符串交换能否使两个字符串相等
     *
     * @param s1 一个字符串
     * @param s2 一个字符串
     * @return 一次字符串交换就使得两个字符串相等则返回 true，否则返回 false。
     */
    public static boolean areAlmostEqual(String s1, String s2) {
        int count = 0;
        char temp1 = 0;
        char temp2 = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
                if (count == 1) {
                    temp1 = s1.charAt(i);
                    temp2 = s2.charAt(i);
                } else if (count == 2) {
                    if (s1.charAt(i) != temp2 || s2.charAt(i) != temp1) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return count != 1;
    }
}
