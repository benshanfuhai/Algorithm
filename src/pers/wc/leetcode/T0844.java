package pers.wc.leetcode;

import java.util.Stack;

public class T0844 {
    public static void main(String[] args) {
        String s = "ab#c";
        String t = "ad#c";
        System.out.println(backspaceCompare_1(s, t));
        System.out.println(backspaceCompare_2(s, t));
    }

    /**
     * 比较含退格的字符串
     *
     * @param s 字符串 s，# 表示退格字符
     * @param t 字符串 t，# 表示退格字符
     * @return 退格后两字符串是否相等
     */
    public static boolean backspaceCompare_1(String s, String t) {
        return compareByStack(s).equals(compareByStack(t));
    }

    public static boolean backspaceCompare_2(String s, String t) {
        return compareByString(s).equals(compareByString(t));
    }


    /**
     * 将元素放入栈中，最后进行比较
     *
     * @param str 字符串
     * @return 退格后的字符串栈
     */
    public static Stack<Character> compareByStack(String str) {
        Stack<Character> res = new Stack<>();
        int len = str.length();
        for (int i = 0; i < len; i++) {
            char cur = str.charAt(i);
            if (cur == '#') {
                if (!res.isEmpty()) {
                    res.pop();
                }
            } else {
                res.push(cur);
            }
        }
        return res;
    }

    /**
     * 使用 StringBuffer 重构字符串
     *
     * @param str 字符串
     * @return 重构后的字符串
     */
    public static String compareByString(String str) {
        StringBuilder resStringBuffer = new StringBuilder();
        int len = str.length();
        for (int i = 0; i < len; i++) {
            char cur = str.charAt(i);
            if (cur == '#') {
                if (resStringBuffer.length() > 0) {
                    resStringBuffer.deleteCharAt(resStringBuffer.length() - 1);
                }
            } else {
                resStringBuffer.append(cur);
            }
        }
        return resStringBuffer.toString();
    }
}