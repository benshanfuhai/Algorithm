package pers.wc.leetcode;

public class T0162 {
    public static void main(String[] args) {
        // int[] nums = {1, 2, 3, 1};
        int[] nums = {1, 2};
        System.out.println(findPeakElement(nums));
    }


    /**
     * 寻找峰值
     *
     * @param nums 整数数组
     * @return 返回峰值元素的索引值，如果存在多个峰值，返回任何一个峰值元素的索引即可
     */
    public static int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            // 判断中点处的增减即可
            // 若增，则将left移到mid的右边一位；若减，则将right移到mid的位置
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
