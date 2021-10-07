package pers.wc.leetcode;

import java.util.Arrays;

public class T0414 {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1};
        System.out.println(thirdMax(nums));
    }

    /**
     * 第三大的数
     *
     * @param nums 非空数组
     * @return 返回此数组中第三大的数 。如果不存在，则返回数组中最大的数。
     */
    public static int thirdMax(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int count = 1;
        int res = nums[len - 1];
        if (len < 3) {
            return nums[len - 1];
        }
        for (int i = len - 1; i >= 0; i--) {
            if (count == 3) {
                break;
            }
            if (nums[i] < res) {
                res = nums[i];
                count++;
            }
        }
        if (count < 3) {
            return nums[len - 1];
        }
        return res;
    }
}
