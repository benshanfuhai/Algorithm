package pers.wc.leetcode;

public class T0200 {
    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};
        // 1
        System.out.println(numIslands(grid));
    }


    /**
     * 岛屿数量
     *
     * @param grid 由 '1'（陆地）和 '0'（水）组成的的二维网格，假设该网格的四条边均被水包围。
     * @return 返回岛屿的数量
     */
    public static int numIslands(char[][] grid) {
        int islandNum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    inflect(i, j, grid);
                    islandNum++;
                }
            }
        }
        return islandNum;
    }

    /**
     * 感染函数，将遇到的 ‘1’ 进行标注，以及进行周边标注
     *
     * @param i indexI
     * @param j indexJ
     */
    public static void inflect(int i, int j, char[][] grid) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != '1') {
            return;
        }
        // 进行标注
        grid[i][j] = '2';
        // 向上
        inflect(i, j - 1, grid);
        // 向下
        inflect(i, j + 1, grid);
        // 向左
        inflect(i - 1, j, grid);
        // 向右
        inflect(i + 1, j, grid);
    }
}
