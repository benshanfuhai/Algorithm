package pers.wc.tree;

import pers.wc.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的中序遍历
 */
public class InorderTraversal {

    /**
     * 递归法
     *
     * @param root 根节点
     * @return 二叉树中序序列
     */
    public static List<Integer> recursion(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list;
    }

    /**
     * 递归
     *
     * @param root 根节点
     * @param list 二叉树中序序列列表
     */
    public static void inorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }


    /**
     * 迭代，模拟栈
     *
     * @param root 根节点
     * @return 二叉树中序序列
     */
    public static List<Integer> iteration(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
        return list;
    }
}
