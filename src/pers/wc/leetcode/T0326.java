package pers.wc.leetcode;

import java.util.Scanner;

public class T0326 {
    public static void main(String[] args) {
        System.out.println("请输入一个数：");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(isPowerOfThree(n));
    }


    /**
     * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。如果是，返回 true；否则，返回 false。
     *
     * @param n 输入的整数
     * @return 该数是否为 3 的幂次方
     */
    public static boolean isPowerOfThree(int n) {
        // 只要 n 为 3 的倍数，则一直对 n 除 3
        while (n != 0 && n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }
}
