package pers.wc.lanqiao;

import java.util.Scanner;

public class TimeDisplay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 46800999 13:00:00
        // 1618708103123L 01:08:23
        long time = scanner.nextLong();

        long totalSecond = time / 1000;

        long second = totalSecond % 60;

        totalSecond /= 60;

        long minute = totalSecond % 60;

        totalSecond /= 60;

        long hour = totalSecond % 24;

        System.out.printf("%02d:%02d:%02d", hour, minute, second);

    }
}
