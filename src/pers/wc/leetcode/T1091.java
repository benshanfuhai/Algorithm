package pers.wc.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class T1091 {
    public static void main(String[] args) {
        int[][] grid = {{0, 1}, {1, 0}};
        // 2
        System.out.println(shortestPathBinaryMatrix(grid));
    }

    /**
     * 二进制矩阵中的最短路径
     * <p>
     * 路径：从 左上角 到 右下角。
     * - 路径所有单元格都为 0
     * - 在矩阵的 8个方向 上联通
     *
     * @param grid n × n的矩阵
     * @return 返回矩阵中最短 畅通路径 的长度。如果不存在这样的路径，返回 -1。
     */
    public static int shortestPathBinaryMatrix(int[][] grid) {
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        int rowLen = grid.length;
        if (grid[0][0] == 1 || grid[rowLen - 1][rowLen - 1] == 1) {
            return -1;
        }
        if (rowLen == 1 && grid[0][0] == 0) {
            return 1;
        }
        Queue<List<int[]>> queue = new LinkedList();
        List<int[]> list = new ArrayList();
        list.add(new int[]{0, 0});
        queue.offer(list);
        grid[0][0] = 1;
        int ans = 1;
        while (!queue.isEmpty()) {
            List<int[]> curList = new ArrayList();
            list = new ArrayList(queue.poll());
            for (int[] arr : list) {
                for (int i = 0; i < directions.length; i++) {
                    int curI = arr[0] + directions[i][0];
                    int curJ = arr[1] + directions[i][1];
                    if (curI == rowLen - 1 && curJ == rowLen - 1) return ++ans;
                    if (0 <= curI && curI < rowLen && 0 <= curJ && curJ < rowLen && grid[curI][curJ] == 0) {
                        curList.add(new int[]{curI, curJ});
                        grid[curI][curJ] = 1;
                    }
                }
            }
            if (curList.size() > 0) {
                queue.add(curList);
                ans++;
            }
        }
        return -1;
    }
}
