package pers.wc.leetcode;

public class T1822 {
    public static void main(String[] args) {
        int[] nums = {-1, -2, -3, -4, 3, 2, 1};
        System.out.println(arraySign(nums));
    }

    /**
     * 数组元素积的符号
     *
     * @param nums 整数数组
     * @return 返回所有数组元素的乘积的符号，正数返回 1 ，负数返回 -1 ，0 返回 0。
     */
    public static int arraySign(int[] nums) {
        int res = 1;
        for (int num : nums) {
            if (num < 0) {
                res *= -1;
            } else if (num > 0) {
                res *= 1;
            } else {
                return 0;
            }
        }
        return res;
    }
}
