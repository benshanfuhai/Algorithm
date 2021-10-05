package pers.wc.leetcode;

public class T0074 {
    public static void main(String[] args) {
        // int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int[][] matrix = {{1, 1}};
        int target = 3;
        System.out.println(searchMatrix_1(matrix, target));
        System.out.println(searchMatrix_2(matrix, target));
    }


    /**
     * 搜索二维矩阵
     *
     * @param matrix 二维矩阵，每行中的整数从左到右按升序排列。每行的第一个整数大于前一行的最后一个整数。
     * @param target 目标元素
     * @return 布尔类型，表示二维矩阵中是否存在目标元素
     */
    public static boolean searchMatrix_1(int[][] matrix, int target) {
        int colLen = matrix[0].length;
        for (int[] rows : matrix) {
            if (rows[0] <= target && rows[colLen - 1] >= target) {
                int left = 0;
                int right = colLen - 1;
                while (left <= right) {
                    int mid = (left + right) / 2;
                    if (rows[mid] == target) {
                        return true;
                    } else if (rows[mid] > target) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
            }
        }
        return false;
    }

    /**
     * 搜索二维矩阵，将二维矩阵看出一维数组
     *
     * @param matrix 二维矩阵，每行中的整数从左到右按升序排列。每行的第一个整数大于前一行的最后一个整数。
     * @param target 目标元素
     * @return 布尔类型，表示二维矩阵中是否存在目标元素
     */
    public static boolean searchMatrix_2(int[][] matrix, int target) {
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        int left = 0;
        int right = rowLen * colLen - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int temp = matrix[mid / colLen][mid % colLen];
            if (temp == target) {
                return true;
            } else if (temp < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
