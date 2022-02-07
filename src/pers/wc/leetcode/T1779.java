package pers.wc.leetcode;

public class T1779 {
    public static void main(String[] args) {
        int x = 3;
        int y = 4;
        int[][] points = {{1, 2}, {3, 1}, {2, 4}, {2, 3}, {4, 4}};
        System.out.println(nearestValidPoint(x, y, points));
    }

    /**
     * 找到最近的有相同 X 或 Y 坐标的点
     * <p>
     * 有效点：当一个点与你所在点有相同的 X 或 Y 坐标时，称为有效点。
     * <p>
     * 曼哈顿距离：abs(x1 - x2) + abs(y1 - y2)。
     *
     * @param x      目标横坐标
     * @param y      目标纵坐标
     * @param points 在同一坐标系下的数组
     * @return 返回距离当前位置 曼哈顿距离 最近的有效点的下标（数组从 0 开始），不存在则返回 -1。
     */
    public static int nearestValidPoint(int x, int y, int[][] points) {
        int minDis = Integer.MAX_VALUE;
        int resIndex = -1;
        for (int i = 0; i < points.length; i++) {
            int tempX = points[i][0];
            int tempY = points[i][1];
            if (tempX == x || tempY == y) {
                int manhattanDis = Math.abs(x - tempX) + Math.abs(y - tempY);
                if (manhattanDis < minDis) {
                    resIndex = i;
                    minDis = manhattanDis;
                }
            }
        }
        return resIndex;
    }
}
