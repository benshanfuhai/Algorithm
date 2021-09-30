package pers.wc.leetcode;

public class T0704 {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 3, 5, 9, 12};
        int target = 9;
        System.out.println(search(nums, target));
    }


    /**
     * 二分查找
     *
     * @param nums   升序一维数组
     * @param target 目标元素
     * @return 目标元素在数组中的索引
     */
    public static int search(int[] nums, int target) {
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
        // 不存在目标元素，返回 -1
        return -1;
    }
}
