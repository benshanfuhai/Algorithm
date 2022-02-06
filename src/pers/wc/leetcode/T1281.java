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
        if (n == 0) {
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        while (n != 0) {
            int temp = n % 10;
            list.add(temp);
            n /= 10;
        }
        int sumNums = 0;
        int multiNums = 1;
        for (int num : list) {
            sumNums += num;
        }
        if (list.contains(0)) {
            return -sumNums;
        } else {
            for (int num : list) {
                multiNums *= num;
            }
            return multiNums - sumNums;
        }
    }
}
