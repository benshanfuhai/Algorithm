package pers.wc.leetcode;

import java.util.ArrayList;
import java.util.List;

public class T0118 {
    public static void main(String[] args) {
        int numRows = 5;
        List<List<Integer>> res = generate(numRows);
        for (List<Integer> list : res) {
            System.out.println(list.toString());
        }
    }

    /**
     * 杨辉三角 https://leetcode.cn/problems/pascals-triangle/
     *
     * @param numRows 一个非负整数
     * @return 杨辉三角的前numRows行
     */
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows >= 1) {
            List<Integer> one = new ArrayList<>();
            one.add(1);
            res.add(one);
        }
        if (numRows >= 2) {
            List<Integer> two = new ArrayList<>();
            two.add(1);
            two.add(1);
            res.add(two);
        }
        for (int i = 2; i < numRows; i++) {
            List<Integer> tempList = new ArrayList<>();
            tempList.add(1);
            for (int j = 1; j <= i - 1; j++) {
                int num1 = res.get(i - 1).get(j - 1);
                int num2 = res.get(i - 1).get(j);
                tempList.add(num1 + num2);
            }
            tempList.add(1);
            res.add(tempList);
        }
        return res;
    }
}
