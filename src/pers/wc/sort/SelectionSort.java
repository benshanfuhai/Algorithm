package pers.wc.sort;

import java.util.Arrays;

/**
 * 选择排序
 * <p>
 * 1.首先在未排序序列中找最小（大）元素，存放到排序序列的起始位置。
 * 2.再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
 * 3.重复第二步，直到所有素均排序完毕元。
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] array = {22, 34, 3, 32, 82, 55, 89, 50, 37, 5, 64, 35, 9, 70};
        System.out.println("排序前：");
        System.out.println(Arrays.toString(array));
        int len = array.length;
        System.out.println("排序过程：");
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (array[j] < array[i]) {
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
            System.out.println(Arrays.toString(array));
        }
        System.out.println("排序后：");
        System.out.println(Arrays.toString(array));
    }
}
