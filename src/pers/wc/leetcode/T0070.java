package pers.wc.leetcode;

public class T0070 {
    public static void main(String[] args) {
        int n = 45;
        System.out.println(climbStars(n));
    }

    /**
     * 爬楼梯 https://leetcode.cn/problems/climbing-stairs/
     * <p>
     * 每次只能爬1阶或2阶
     *
     * @param n 爬到楼顶需要的阶数
     * @return 爬到楼顶的方法数
     */
    public static int climbStars(int n) {
        if (n < 2) {
            return 1;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            // 第i层的爬法等于第i-1层和第i-2层的爬法之和
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }
}
