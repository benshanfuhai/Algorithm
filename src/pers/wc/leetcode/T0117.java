package pers.wc.leetcode;

import pers.wc.leetcode.utils.TreeNode;

import java.util.LinkedList;

public class T0117 {

    public static void main(String[] args) {
        TreeNode treeNode = connect(new TreeNode(1));
        System.out.println(treeNode.val);
    }

    /**
     * 填充每个节点的下一个右侧节点指针 II
     * <p>
     * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
     *
     * @param root 根节点
     * @return 填充结点后的二叉树
     */
    public static TreeNode connect(TreeNode root) {
        if (root == null) {
            return null;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode temp = null;
            for (int i = 0; i < size; i++) {
                temp = queue.remove();
                if (i < size - 1) {
                    temp.next = queue.peek();
                }
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }

            }
            temp.next = null;
        }
        return root;
    }
}
