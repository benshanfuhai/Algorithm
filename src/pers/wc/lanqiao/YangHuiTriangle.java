package pers.wc.lanqiao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class YangHuiTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long N = scanner.nextLong();

        List<List<Integer>> list = new ArrayList<>();
        boolean flag = true;

        if (N == 1) {
            flag = false;
        }

        int count = 1;
        int result = 1;
        while (flag) {
            List<Integer> tempList = new ArrayList<>();
            if (count == 1) {
                tempList.add(1);
            } else {
                List<Integer> beforeList = list.get(count - 2);
                for (int i = 0; i < count; i++) {
                    if (i == 0 || i == count - 1) {
                        tempList.add(1);
                    } else {
                        int tempNum = beforeList.get(i - 1) + beforeList.get(i);
                        if (tempNum == N) {
                            // System.out.println(count);
                            // System.out.println(i);
                            // 取到当前层的上一层，求和
                            count = count - 1;
                            // 等差求和，求目标数之前各层的个数之和；再加上当前层的个数
                            result = (count + ((count * (count - 1)) / 2)) + (i + 1);
                            flag = false;
                            tempList.add(tempNum);
                            break;
                        }
                        tempList.add(tempNum);
                    }
                }
            }
            // System.out.println(tempList);
            list.add(tempList);
            count++;
        }
        // System.out.println(list);
        System.out.println(result);
    }
}
