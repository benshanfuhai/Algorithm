package pers.wc.leetcode;

import pers.wc.leetcode.utils.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class T0019 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        int n = 1;
        System.out.println(removeNthFromEnd(head, n));
    }

    /**
     * 删除链表的倒数第N个结点 https://leetcode.cn/problems/remove-nth-node-from-end-of-list/
     *
     * @param head 链表的头结点
     * @param n    删除的位置
     * @return 链表的头结点
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // 因为删除的是倒数第N个，所以使用栈来实现
        Deque<ListNode> stack = new ArrayDeque<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        ListNode res = null;
        while (!stack.isEmpty()) {
            ListNode temp = stack.pop();
            n--;
            // 遇到倒数第N个结点时直接跳过
            if (n != 0) {
                temp.next = res;
                res = temp;
            }
        }
        return res;
    }
}
