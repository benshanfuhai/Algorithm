package pers.wc.leetcode;

import java.util.Arrays;

public class T1502 {
    public static void main(String[] args) {
        int[] arr = {3, 5, 1};
        System.out.println(canMakeArithmeticProgression(arr));
    }

    /**
     * 判断能否形成等差数列
     *
     * @param arr 整数数组
     * @return 如果数组元素能够排列形成等差数列，则返回 true，否则返回 false。
     */
    public static boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int base = arr[1] - arr[0];
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i + 1] - arr[i] != base) {
                return false;
            }
        }
        return true;
    }
}
