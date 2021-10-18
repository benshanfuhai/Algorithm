package pers.wc.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T0986 {
    public static void main(String[] args) {
        int[][] firstList = {{0, 2}, {5, 10}, {13, 23}, {24, 25}};
        int[][] secondList = {{1, 5}, {8, 12}, {15, 24}, {25, 26}};
        // [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
        System.out.println(Arrays.deepToString(intervalIntersection(firstList, secondList)));
    }

    /**
     * 区间列表的交集
     *
     * @param firstList  区间列表，已按大小排序
     * @param secondList 区间列表，已按大小排序
     * @return 区间列表的交集
     */
    public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> list = new ArrayList<>();
        int firLen = firstList.length;
        int secLen = secondList.length;
        int i = 0;
        int j = 0;
        while (i < firLen && j < secLen) {
            int tempStart = Math.max(firstList[i][0], secondList[j][0]);
            int tempEnd = Math.min(firstList[i][1], secondList[j][1]);
            if (tempStart <= tempEnd) {
                list.add(new int[]{tempStart, tempEnd});
            }
            // 忽略小端点区间，继续搜索
            if (firstList[i][1] < secondList[j][1]) {
                i++;
            } else {
                j++;
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
