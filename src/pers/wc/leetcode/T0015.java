package pers.wc.leetcode;

import java.util.*;

public class T0015 {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        // [[-1,-1,2],[-1,0,1]]
        System.out.println(threeSum(nums));
    }

    /**
     * 三数之和
     *
     * @param nums 包含 n 个整数的 nums
     * @return 所有和为 0 且不重复的三元组
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int len = nums.length;
        // 首先排序，防止结果重复
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            // 首位大于 0 ，这不可能存在三数之和等于 0
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                // 前后相等，进行下一次遍历
                continue;
            }
            // 将三数之和简化为两数之和
            int target = -nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    result.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                    left++;
                    right--;
                    // 进行去重，防止将nums[left]和nums[right]加入后，又重新加入相同的数
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (nums[left] + nums[right] < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
}
