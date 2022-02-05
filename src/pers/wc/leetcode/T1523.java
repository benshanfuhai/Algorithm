package pers.wc.leetcode;

public class T1523 {
    public static void main(String[] args) {
        int low = 9;
        int high = 17;
        System.out.println(countOdds(low, high));
    }

    /**
     * 在区间范围内统计奇数数目
     *
     * @param low  非负整数
     * @param high 非负整数
     * @return 返回 low 和 high 之间的奇数数目
     */
    public static int countOdds(int low, int high) {
        int edgeCount = isOdd(low) + isOdd(high);
        if (edgeCount != 0) {
            return (high - low) / 2 + 1;
        } else {
            return (high - low) / 2;
        }
    }

    public static int isOdd(int num) {
        if (num % 2 != 0) {
            return 1;
        }
        return 0;
    }
}
