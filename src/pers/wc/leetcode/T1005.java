package pers.wc.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class T1005 {
    public static void main(String[] args) {
        int[] nums = {4, 2, 3};
        int k = 1;
        // 5
        System.out.println(largestSumAfterKNegations(nums, k));
    }

    /**
     * K 次取反后最大化的数组和
     * <p>
     * 选择某个下标 i 并将 nums[i] 替换为 -nums[i]，重复 k 次，i 的值可重复选择
     *
     * @param nums 整数数组
     * @param k    取反次数
     * @return 返回修改数组的可能最大和
     */
    public static int largestSumAfterKNegations(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        int ans = Arrays.stream(nums).sum();
        for (int i = -100; i < 0; ++i) {
            if (freq.containsKey(i)) {
                int ops = Math.min(k, freq.get(i));
                ans += (-i) * ops * 2;
                freq.put(i, freq.get(i) - ops);
                freq.put(-i, freq.getOrDefault(-i, 0) + ops);
                k -= ops;
                if (k == 0) {
                    break;
                }
            }
        }
        if (k > 0 && k % 2 == 1 && !freq.containsKey(0)) {
            for (int i = 1; i <= 100; ++i) {
                if (freq.containsKey(i)) {
                    ans -= i * 2;
                    break;
                }
            }
        }
        return ans;
    }
}
