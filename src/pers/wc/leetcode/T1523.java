package pers.wc.leetcode;

public class T1523 {
    public static void main(String[] args) {
        int low = 8;
        int high = 10;
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
        // low 和 high 中存在奇数时
        if ((low % 2 != 0) | (high % 2 != 0)) {
            return (high - low) / 2 + 1;
        } else {
            return (high - low) / 2;
        }
    }
}
