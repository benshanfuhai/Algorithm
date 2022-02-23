package pers.wc.lanqiao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class YangHuiTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // int N = scanner.nextInt();

        int N = 1;

        List<List<Integer>> list = new ArrayList<>();
        List<Integer> firstList = new ArrayList<>();
        firstList.add(1);

        System.out.println(firstList);

        list.add(firstList);
        int count = 2;
        while (count < 15) {
            List<Integer> tempList = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                if (i == 0 || i == count - 1) {
                    tempList.add(1);
                } else {
                    int tempNum = list.get(count - 2).get(i - 1) + list.get(count - 2).get(i);
                    tempList.add(tempNum);
                }
            }
            System.out.println(tempList);
            list.add(tempList);
            count++;
        }
        // System.out.println(list);
    }
}
