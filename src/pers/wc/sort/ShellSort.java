package pers.wc.sort;

import java.util.Arrays;

/**
 * 先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序
 * <p>
 * 具体算法描述：
 * 1.选择一个增量序列t1，t2，…，tk，其中ti>tj，tk=1；
 * 2.按增量序列个数k，对序列进行k 趟排序；
 * 3.每趟排序，根据对应的增量ti，将待排序列分割成若干长度为m 的子序列，分别对各子表进行直接插入排序。
 * 仅增量因子为1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] array = {22, 34, 3, 32, 82, 55, 89, 50, 37, 5, 64, 35, 9, 70};
        System.out.println("排序前：");
        System.out.println(Arrays.toString(array));
        int len = array.length;
        for (int step = len / 2; step >= 1; step /= 2) {
            int temp;
            for (int i = step; i < len; i++) {
                temp = array[i];
                int j = i - step;
                while (j >= 0 && array[j] > temp) {
                    array[j + step] = array[j];
                    j -= step;
                }
                array[j + step] = temp;
            }
        }
        System.out.println("排序后：");
        System.out.println(Arrays.toString(array));
    }
}
