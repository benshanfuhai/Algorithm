package pers.wc.leetcode;

import java.util.*;

public class T0797 {
    // 存放结果
    public static List<List<Integer>> ans = new ArrayList<>();
    // 存放某一次的路径
    public static Deque<Integer> stack = new ArrayDeque<>();

    public static void main(String[] args) {
        int[][] graph = {{1, 2}, {3}, {3}, {}};
        // [[0,1,3],[0,2,3]]
        System.out.println(allPathsSourceTarget(graph));
    }

    /**
     * @param graph 有 n 个结点的有向无环图
     * @return 返回从 0 到 n-1 的路径
     */
    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        stack.offerLast(0);
        dfs(graph, 0, graph.length - 1);
        return ans;
    }

    /**
     * @param graph 有向无环图
     * @param num   当前长度
     * @param len   目标长度 n - 1
     */
    public static void dfs(int[][] graph, int num, int len) {
        // 结束条件
        if (num == len) {
            ans.add(new ArrayList<>(stack));
            return;
        }
        // 进行选择
        for (int temp : graph[num]) {
            // 选择
            stack.offerLast(temp);
            dfs(graph, temp, len);
            // 撤销选择
            stack.pollLast();
        }
    }
}
