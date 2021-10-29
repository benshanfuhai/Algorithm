package pers.wc.leetcode;

public class T1343 {
    public static void main(String[] args) {
        int[] arr = {11, 13, 17, 23, 29, 31, 7, 5, 2, 3};
        int k = 3;
        int threshold = 5;
        // 3    {2, 5, 5}  {5, 5, 5}   {5, 5, 8}
        System.out.println(numOfSubarrays(arr, k, threshold));
    }

    /**
     * 大小为 K 且平均值大于等于阈值的子数组数目
     *
     * @param arr       整数数组
     * @param k         子数组长度
     * @param threshold 阈值
     * @return 符合条件的子数组数组
     */
    public static int numOfSubarrays(int[] arr, int k, int threshold) {
        int ans = 0;
        int left = 0;
        int right = k - 1;
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        while (right < arr.length) {
            if (sum >= threshold * k) {
                ans++;
            }
            sum -= arr[left++];
            if (++right < arr.length) {
                sum += arr[right];
            }
        }
        return ans;
    }
}
