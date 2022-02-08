package pers.wc.leetcode;

import java.util.HashSet;
import java.util.Set;

public class T0202 {
    public static void main(String[] args) {
        int n = 19;
        System.out.println(isHappy(n));
    }

    /**
     * 快乐数
     *
     * @param n 正整数
     * @return n 是快乐数则返回 1 ，否则返回 0。
     */
    public static boolean isHappy(int n) {
        Set<Integer> allResult = new HashSet<>();
        while (n != 1 && !allResult.contains(n)) {
            allResult.add(n);
            n = getNextNum(n);
        }
        return n == 1;
    }

    /**
     * 获取下一个数
     *
     * @param num 当前数
     * @return 返回当前数的各位平方和
     */
    public static int getNextNum(int num) {
        int nextNum = 0;
        while (num != 0) {
            int temp = num % 10;
            num /= 10;
            nextNum += temp * temp;
        }
        return nextNum;
    }
}
