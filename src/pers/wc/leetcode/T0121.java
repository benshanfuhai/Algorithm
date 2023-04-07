package pers.wc.leetcode;

public class T0121 {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4, 9};
        System.out.println(maxProfit_1(prices));
        System.out.println(maxProfit_2(prices));
    }

    /**
     * 买卖股票的最佳时机
     * <p>
     * 给定一个数组 prices，只能选择某一天买入这个股票，并在未来某一天卖出这个股票，求出能获得的最大利润
     *
     * @param prices 数组，第 i 个元素表示是给定股票第 i 天的价格
     * @return 返回能获取的最大利润，如果不能获取利润则返回 0
     */
    public static int maxProfit_1(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProf = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (maxProf < prices[i] - minPrice) {
                maxProf = prices[i] - minPrice;
            }
        }
        return maxProf;
    }

    // 动态规划解法
    public static int maxProfit_2(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        // dp[i][j] 表示第 i 天状态为 j 时持有的现金数
        int[][] dp = new int[len][2];
        // j = 0 表示不持有，此时现金数为 0
        dp[0][0] = 0;
        // j = 1 表示持有，此时现金数为 -prices[i]
        dp[0][1] = -prices[1];
        for (int i = 1; i < len; i++) {
            // 当天不持有的现金数 等于 （前一天不持有 和 前一天持有当天卖出）的现金数最大值
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            // 当天持有（只有一次卖出机会）的现金数 等于 前一天持有 和 前一天不持有今天持有 的现金数最大值
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[len - 1][0];
    }
}