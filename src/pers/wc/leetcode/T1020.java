package pers.wc.leetcode;

public class T1020 {
    public static void main(String[] args) {
        int[][] grid = {{0, 0, 0, 0}, {1, 0, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 0}};
        System.out.println(numEnclaves(grid));
    }

    /**
     * 飞地的数量
     *
     * @param grid 网格，其中 0 表示海， 1 表示陆地
     * @return 返回无法在任意次数的移动中离开网格边界的陆地单元格的数量
     */
    public static int numEnclaves(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // 找到边界陆地，从此处开始搜索
                if ((i == 0 || j == 0 || i == grid.length - 1 || j == grid[0].length - 1) && grid[i][j] == 1) {
                    dfs(i, j, grid);
                }
            }
        }
        // 遍历完所有的边界陆地后，剩下的都是与边界陆地相独立的陆地，循环遍历即可得到飞地的数量
        for (int[] ints : grid) {
            for (int j = 0; j < grid[0].length; j++) {
                if (ints[j] == 1) {
                    res++;
                }
            }
        }
        return res;
    }


    /**
     * 找到与边界陆地相连的陆地，将其全部改为海
     *
     * @param i    索引 i
     * @param j    索引 j
     * @param grid 网格
     */
    public static void dfs(int i, int j, int[][] grid) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) {
            return;
        }
        grid[i][j] = 0;
        dfs(i, j - 1, grid);
        dfs(i, j + 1, grid);
        dfs(i - 1, j, grid);
        dfs(i + 1, j, grid);
    }
}
