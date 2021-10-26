package pers.wc.leetcode;

public class T0209 {
    public static void main(String[] args) {
        int target = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};
        // 2
        System.out.println(minSubArrayLen(target, nums));
    }

    /**
     * 长度最小的子数组
     *
     * @param target 目标元素
     * @param nums   含有 n 个正整数的数组
     * @return 返回数组中满足其和 >= target 的长度最小的连续子数组长度，若没有则返回 0
     */
    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int minLen = 0;
        int sum = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                if (minLen == 0) {
                    minLen = right - left + 1;
                } else {
                    minLen = Math.min(minLen, right - left + 1);
                }
                sum -= nums[left++];
            }
        }
        return minLen;
    }
}
