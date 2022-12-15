package pers.wc.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class T0071 {
    public static void main(String[] args) {
        String path = "/a/./b/../../c/";
        System.out.println(simplifyPath(path));
    }

    /**
     * 简化路径 https://leetcode.cn/problems/simplify-path/
     *
     * @param path 指向某一文件或目录的Unix风格的结对路径
     * @return 返回更加简洁的规范路径
     */
    public static String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();
        // 拆分出文件名或目录名
        String[] strings = path.split("/");
        for (String temp : strings) {
            // 遇到上一级则弹出栈顶元素，遇到本级则不进行操作，遇到文件名或目录名则入栈
            switch (temp) {
                case "..":
                    // 当栈为空时，不进行操作
                    if (stack.isEmpty()) {
                        continue;
                    } else {
                        stack.pop();
                    }
                    break;
                case ".":
                    break;
                // 根据"/"进行拆分时，可能会产生空元素
                case "":
                    break;
                default:
                    stack.push(temp);
                    break;
            }
        }
        if (stack.isEmpty()) {
            return "/";
        }
        // 相对于String进行操作，拥有较大的提升
        StringBuilder res = new StringBuilder();
        for (String temp : stack) {
            // StringBuilder的在前面进行拼接的操作
            res.insert(0, temp);
            res.insert(0, "/");
        }
        return res.toString();
    }
}
