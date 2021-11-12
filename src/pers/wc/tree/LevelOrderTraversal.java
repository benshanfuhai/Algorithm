package pers.wc.tree;

import pers.wc.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的层序遍历
 */
public class LevelOrderTraversal {
    /**
     * 迭代法
     *
     * @param root 根节点
     * @return 层序遍历结果
     */
    public List<List<Integer>> iteration(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        // 添加根节点到队列
        queue.add(root);
        while (!queue.isEmpty()) {
            // 获取当前层结点的个数，不能直接在下面的循环中直接使用 queue.size()
            int size = queue.size();
            List<Integer> tempList = new ArrayList<>();
            // 遍历添加当前层中的结点到链表中
            for (int i = 0; i < size; i++) {
                // 顺序取出第一个结点
                TreeNode cur = queue.remove();
                tempList.add(cur.val);
                // 添加当前结点的左子节点到队列，用于下次遍历输出
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                // 添加当前结点的右子节点到队列，用于下次遍历输出
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
            // 添加当前层的结点链表到结果链表中
            list.add(tempList);
        }
        return list;
    }

}
