package pers.wc.leetcode;

import java.util.*;

public class T0018 {
    public static void main(String[] args) {
        int[] nums = {0, 0, 0, 1000000000, 1000000000, 1000000000, 1000000000};
        int target = 1000000000;
        System.out.println(fourSum(nums, target).toString());
    }


    /**
     * 四数之和 https://leetcode.cn/problems/4sum/
     *
     * @param nums   一个由n个整数组成的数组
     * @param target 目标值
     * @return 返回nums中四个位置互不相同并且值之和等于target的四个数
     */
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < len - 3; i++) {
            // 去重，直接进入下一轮循环
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 当最小和大于target时，直接结束循环
            // 可能会发生结果溢出，导致变号
            if ((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            // 当目前的最大值小于target时，进行下一轮循环
            if ((long) nums[i] + nums[len - 3] + nums[len - 2] + nums[len - 1] < target) {
                continue;
            }
            for (int j = i + 1; j < len - 2; j++) {
                // 去重，直接进入下一轮循环
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                // 当目前的最小值大于target时，直接结束循环
                if ((long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                // 当目前的最大值小于target时，进行下一轮循环
                if ((long) nums[i] + nums[j] + nums[len - 2] + nums[len - 1] < target) {
                    continue;
                }
                int left = j + 1;
                int right = len - 1;
                while (left < right) {
                    // List<Integer> tempList = new ArrayList<>();
                    int tempSum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (tempSum > target) {
                        right--;
                    } else if (tempSum < target) {
                        left++;
                    } else {
                        // tempList.add(nums[i]);
                        // tempList.add(nums[j]);
                        // tempList.add(nums[left]);
                        // tempList.add(nums[right]);
                        // res.add(tempList);
                        // 将几个数便捷的添加为List类型
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        left++;
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        right--;
                    }
                }
            }
        }
        return res;
    }
}
