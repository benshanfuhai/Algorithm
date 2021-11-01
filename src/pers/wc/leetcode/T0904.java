package pers.wc.leetcode;

import java.util.HashMap;

public class T0904 {
    public static void main(String[] args) {
        int[] fruits = {3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4};
        // 5
        System.out.println(totalFruit(fruits));
    }

    /**
     * 水果成篮
     *
     * @param fruits 水果种类
     * @return 能摘水果的树的最大数量
     */
    public static int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int total = 0;
        int left = 0;
        for (int right = 0; right < fruits.length; right++) {
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
            while (map.size() > 2) {
                map.put(fruits[left], map.get(fruits[left]) - 1);
                if (map.get(fruits[left]) == 0) {
                    map.remove(fruits[left]);
                }
                left++;
            }
            total = Math.max(total, right - left + 1);
        }
        return total;
    }
}
