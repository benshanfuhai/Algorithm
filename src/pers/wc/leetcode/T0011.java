package pers.wc.leetcode;

public class T0011 {
    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        // int[] height = {1, 1000, 1000, 6, 2, 5, 4, 8, 3, 7};
        // 49
        // 1000
        System.out.println(maxArea(height));
    }

    /**
     * 盛最多水的容器
     *
     * @param height 表示高度的数组
     * @return 能够容纳的水的最大值
     */
    public static int maxArea(int[] height) {
        int len = height.length;
        int left = 0;
        int right = len - 1;
        int maxArea = (right - left) * Math.min(height[left], height[right]);
        while (left < right) {
            maxArea = Math.max(maxArea, (right - left) * Math.min(height[left], height[right]));
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
