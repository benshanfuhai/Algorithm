package pers.wc.leetcode;

public class T0191 {
    public static void main(String[] args) {
        // 二进制形式的数
        int n = 0b00000000000000000000000000001011;
        System.out.println(n);
        System.out.println(Integer.toBinaryString(n));
        System.out.println(hammingWeight(n));
    }

    /**
     * 位 1 的个数（汉明重量）
     *
     * @param n 无符号整数，以二进制串的形式
     * @return 返回二进制串中 1 的个数
     */
    public static int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                count++;
            }
            // 无符号右移，忽略符号位，空位都以 0 补齐
            n = n >>> 1;
        }
        return count;
    }
}
