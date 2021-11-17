package pers.wc.sort;

import java.util.Arrays;

/**
 * 插入排序
 * <p>
 * 1.从第一个元素开始，该元素可以认为已经被排序；
 * 2.取出下一个元素，在已经排序的元素序列中从后向前扫描；
 * 3.如果该元素（已排序）大于新元素，将该元素移到下一位置；
 * 4.重复步骤 3，直到找到已排序的元素小于或者等于新元素的位置；
 * 5.将新元素插入到该位置后；
 * 6.重复步骤 2~5。
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] array = {22, 34, 3, 32, 82, 55, 89, 50, 37, 5, 64, 35, 9, 70};
        System.out.println("排序前：");
        System.out.println(Arrays.toString(array));
        int len = array.length;
        System.out.println("排序过程：");
        for (int i = 1; i < len; i++) {
            int cur = array[i];
            for (int j = i; j >= 0; j--) {
                if (j >= 1 && array[j - 1] > cur) {
                    array[j] = array[j - 1];
                } else {
                    array[j] = cur;
                    break;
                }
            }
            System.out.println(Arrays.toString(array) + ": " + cur);
        }
        System.out.println("排序后：");
        System.out.println(Arrays.toString(array));
    }

}
