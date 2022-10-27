package pers.wc.leetcode;

import java.util.Arrays;

public class T0016 {
    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        int target = 1;
        System.out.println(threeSumClosest(nums, target));
    }

    /**
     * 最接近的三数之和 https://leetcode.cn/problems/3sum-closest/
     *
     * @param nums   数组
     * @param target 目标值
     * @return 返回数组中与目标值最接近的三数之和
     */
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[2];
        int closestDis = Math.abs(target - closestSum);
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int tempSum = nums[left] + nums[i] + nums[right];
                int tempDis = Math.abs(tempSum - target);
                if (tempDis < closestDis) {
                    closestDis = tempDis;
                    closestSum = tempSum;
                }
                if (tempSum > target) {
                    right--;
                } else if (tempSum < target) {
                    left++;
                } else {
                    return tempSum;
                }

            }
        }
        return closestSum;
    }
}
