package pers.wc.leetcode;

import java.util.ArrayList;
import java.util.List;

public class T1281 {
    public static void main(String[] args) {
        int n = 234;
        System.out.println(subtractProductAndSum(n));
    }

    /**
     * 整数的各位积和之差
     *
     * @param n 一个整数
     * @return 返回该整数 各个数字之积 与 各个数字之和 的差。
     */
    public static int subtractProductAndSum(int n) {
        int multiNums = 1;
        int sumNums = 0;
        while (n != 0) {
            int temp = n % 10;
            multiNums *= temp;
            sumNums += temp;
            n /= 10;
        }
        return multiNums - sumNums;
    }
}
