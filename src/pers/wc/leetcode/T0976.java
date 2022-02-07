package pers.wc.leetcode;

import java.util.Arrays;

public class T0976 {
    public static void main(String[] args) {
        int[] nums = {2, 1, 2};
        System.out.println(largestPerimeter(nums));
    }

    /**
     * 三角形的最大周长
     * <p>
     * 贪心思想：
     * 先将数组排序，由于三角形要求任意两边之和大于第三边，故选择最大的边为第三边即可，最大边前面的两个数为两边。
     * 另外，若前面两边之和小于第三边，则前面的边都无法满足条件，只需要将最大边向前移动即可找到符合条件的三角形。
     *
     * @param nums 一些代表 长度 的正数组成的数组
     * @return 返回由 其中三个长度组成的、面积不为零的 三角形的最大周长。如果不能形成面积不为零的三角形，则返回 0 。
     */
    public static int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for (int i = nums.length - 3; i >= 0; i--) {
            if (nums[i] + nums[i + 1] > nums[i + 2]) {
                return nums[i] + nums[i + 1] + nums[i + 2];
            }
        }
        return 0;
    }
}
