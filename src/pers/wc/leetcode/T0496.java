package pers.wc.leetcode;

import java.util.Arrays;

public class T0496 {
    public static void main(String[] args) {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        System.out.println(Arrays.toString(nextGreaterElement(nums1, nums2)));
    }

    /**
     * 下一个更大元素
     *
     * @param nums1 没有重复元素的数组，为 nums2 的子集
     * @param nums2 没有重复元素的数组
     * @return 返回一个长度为 nums1.length 的数组 res 作为答案，满足 res[i] 是如上所述的 下一个更大元素 。
     */
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int j = 0;
            while (j < nums2.length && nums2[j] != nums1[i]) {
                j++;
            }
            int k = j + 1;
            while (k < nums2.length && nums2[k] < nums2[j]) {
                k++;
            }
            res[i] = k < nums2.length ? nums2[k] : -1;
        }
        return res;
    }
}
