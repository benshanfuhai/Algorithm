package pers.wc.leetcode;

public class T0547 {
    public static void main(String[] args) {
        int[][] isConnected = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        // 2
        System.out.println(findCircleNum(isConnected));
    }

    /**
     * 省份数量，省份是一组直接或间接相连的城市，组内不含其他没有相连的城市。
     *
     * @param isConnected n x n 的矩阵 isConnected，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，
     *                    而 isConnected[i][j] = 0 表示二者不直接相连。
     * @return 返回省份的数量
     */
    public static int findCircleNum(int[][] isConnected) {
        int res = 0;
        boolean[] isVisited = new boolean[isConnected.length];
        for (int i = 0; i < isVisited.length; i++) {
            if (!isVisited[i]) {
                dfs(isVisited, i, isConnected);
                res++;
            }
        }
        return res;
    }

    /**
     * 深度优先搜索
     *
     * @param isVisited   是否被访问过
     * @param i           行索引
     * @param isConnected n x n 的矩阵 isConnected，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，
     *                    而 isConnected[i][j] = 0 表示二者不直接相连。
     */
    public static void dfs(boolean[] isVisited, int i, int[][] isConnected) {
        for (int j = 0; j < isConnected[i].length; j++) {
            if (!isVisited[j] && isConnected[i][j] == 1) {
                isVisited[j] = true;
                dfs(isVisited, j, isConnected);
            }
        }
    }
}
