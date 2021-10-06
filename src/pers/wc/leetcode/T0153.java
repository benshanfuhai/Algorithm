package pers.wc.leetcode;

public class T0153 {
    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 1, 2};
        System.out.println(findMin(nums));
    }

    /**
     * 寻找旋转排序数组中的最小值
     *
     * @param nums 长度为 n 的数组，元素值互不相同，预先按照升序排列，经过了多次旋转
     *             数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]]
     * @return 数组中的最小元素
     */
    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            // 无论旋转多少次，总有一边为升序排列
            if (nums[mid] < nums[right]) {
                // 右边（含中点）有序（升序），则搜索左边即可
                // 注意要把右边最小值（nums[mid]）包含进左边部分进行搜索，因为此时左边也可能为升序
                right = mid;
            } else {
                // 此时最小值只能在右边
                // 由于中点值大于右边的最小值（nums[right]），所以不需要包含进右边部分进行搜索
                left = mid + 1;
            }
        }
        return nums[mid];
    }
}
