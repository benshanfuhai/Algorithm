package pers.wc.leetcode;

public class T0033 {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 1};
        int target = 3;
        System.out.println(search(nums, target));
    }

    /**
     * 搜索旋转排序数组
     *
     * @param nums   旋转后的升序数组，该数组在某个下标处进行了旋转。
     *               例如升序数组 [1,2,3,4,5,6,7], 在下标 3 出旋转后，变成 [4,5,6,7,1,2,3]
     * @param target 目标元素
     * @return 目标元素在旋转后的数组的下标
     */
    public static int search(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while (left <= right) {
            // 按中间拆分时，必有一边为有序
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] >= nums[left]) {
                // 左边有序，此处需要等于号，因为 left 和 mid 的值可能相等，为同一个元素
                // 目标元素在左边有序部分中
                if (nums[left] <= target && nums[mid] > target) {
                    right = mid - 1;
                } else {
                    // 目标元素不在有序部分
                    left = mid + 1;
                }
            } else {
                // 左边无序，则右边必为有序
                // 目标元素在右边有序部分中
                if (nums[mid] < target && nums[right] >= target) {
                    left = mid + 1;
                } else {
                    // 目标元素不在有序部分
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
