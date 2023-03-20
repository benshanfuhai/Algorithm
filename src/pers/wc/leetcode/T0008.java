package pers.wc.leetcode;

public class T0008 {
    public static void main(String[] args) {
        String s = "-2147483647";
        System.out.println(myAtoi(s));
    }

    /**
     * 字符串转换整数 https://leetcode.cn/problems/string-to-integer-atoi/
     * <p>
     * 将一个给定字符串转换为一个32位有符号整数
     *
     * @param s 给定字符串
     * @return 一个32位有符号整数
     */
    public static int myAtoi(String s) {
        s = s.trim();
        int len = s.length();
        StringBuilder stringBuilder = new StringBuilder();
        boolean sign = true;
        boolean pre = true;
        for (int i = 0; i < len; i++) {
            boolean tempSign = true;
            char ch = s.charAt(i);
            if (isDigit(ch)) {
                stringBuilder.append(ch);
                pre = true;
            } else {
                if (ch == '+' && pre && i == 0) {
                    pre = false;
                    tempSign = true;
                } else if (ch == '-' && pre && i == 0) {
                    pre = false;
                    tempSign = false;
                } else {
                    break;
                }
            }
            sign &= tempSign;
        }
        if (stringBuilder.length() == 0) {
            return 0;
        }
        String resStr = stringBuilder.toString();
        long res = 0;
        for (int i = 0; i < resStr.length(); i++) {
            // 防止溢出
            res = res * 10 + (resStr.charAt(i) - '0');
            if (sign && res > Integer.MAX_VALUE) {
                res = Integer.MAX_VALUE;
                break;
            }
            if (!sign && res > Integer.MAX_VALUE + 1L) {
                res = Integer.MAX_VALUE + 1L;
            }
        }
        return sign ? (int) res : -(int) res;
    }

    /**
     * 判断是否是数字
     *
     * @param c 字符
     * @return 给定字符是否为数字
     */
    public static boolean isDigit(char c) {
        return c > 47 && c < 58;
    }
}
