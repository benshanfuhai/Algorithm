package pers.wc.leetcode;

public class T0121 {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4, 9};
        System.out.println(maxProfit(prices));
    }

    /**
     * 买卖股票的最佳时机
     * <p>
     * 给定一个数组 prices，只能选择某一天买入这个股票，并在未来某一天卖出这个股票，求出能获得的最大利润
     *
     * @param prices 数组，第 i 个元素表示是给定股票第 i 天的价格
     * @return 返回能获取的最大利润，如果不能获取利润则返回 0
     */
    public static int maxProfit(int[] prices) {
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
}