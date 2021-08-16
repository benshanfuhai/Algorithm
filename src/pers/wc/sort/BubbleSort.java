package pers.wc.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * <p>
 * 1.比较相邻的元素。如果第一个比第二个大，就交换它们两个；
 * 2.对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
 * 3.针对所有的元素重复以上的步骤，除了最后一个；
 * 4.重复步骤1~3，直到排序完成。
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {22, 34, 3, 32, 82, 55, 89, 50, 37, 5, 64, 35, 9, 70};
        System.out.println("排序前：");
        System.out.println(Arrays.toString(array));
        int len = array.length;
        System.out.println("排序过程：");
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
            System.out.println(Arrays.toString(array));
        }
        System.out.println("排序后：");
        System.out.println(Arrays.toString(array));
    }
}
