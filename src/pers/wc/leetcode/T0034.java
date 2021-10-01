package pers.wc.leetcode;

import java.util.Arrays;

public class T0034 {

    public static void main(String[] args) {
        int[] nums = {};
        int target = 0;
        System.out.println(binarySearch(nums, target));
        System.out.println(Arrays.toString(searchRange(nums, target)));
    }

    /**
     * 在排序数组中查找元素的第一个和最后一个位置
     *
     * @param nums   升序数组
     * @param target 目标元素
     * @return 数组，第一个元素表示起始位置，第二个元素表示结尾位置
     */
    public static int[] searchRange(int[] nums, int target) {
        int index = binarySearch(nums, target);
        // 若不存在该元素，直接返回[-1,-1]
        if (index == -1) {
            return new int[]{-1, -1};
        }
        // 存在该元素，找边界
        int left = index;
        int right = index;
        // 找左边界
        while (left - 1 >= 0 && nums[left - 1] == target) {
            left--;
        }
        // 找右边界
        while (right + 1 <= nums.length - 1 && nums[right + 1] == target) {
            right++;
        }
        return new int[]{left, right};
    }

    /**
     * 二分查找
     *
     * @param nums   一维数组
     * @param target 目标元素
     * @return 目标元素在数组中的位置，若不存在目标元素，则返回 -1。
     */
    public static int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
