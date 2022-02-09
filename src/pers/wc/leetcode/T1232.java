package pers.wc.leetcode;

public class T1232 {
    public static void main(String[] args) {
        int[][] coordinates = {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}};
        System.out.println(checkStraightLine(coordinates));
    }

    /**
     * 缀点成线
     *
     * @param coordinates 二维数组，coordinates[i] = [x, y]，其中 x 和 y 分别表示横纵坐标
     * @return 若这些点属于同一直线，返回 true，否则返回 false。
     */
    public static boolean checkStraightLine(int[][] coordinates) {
        for (int i = 1; i < coordinates.length - 1; i++) {
            int deltaX1 = coordinates[i][0] - coordinates[i - 1][0];
            int deltaY1 = coordinates[i][1] - coordinates[i - 1][1];
            int deltaX2 = coordinates[i + 1][0] - coordinates[i][0];
            int deltaY2 = coordinates[i + 1][1] - coordinates[i][1];
            if (deltaX1 * deltaY2 != deltaX2 * deltaY1) {
                return false;
            }
        }
        return true;
    }
}
