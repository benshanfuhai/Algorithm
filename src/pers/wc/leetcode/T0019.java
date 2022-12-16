package pers.wc.leetcode;

import pers.wc.leetcode.utils.ListNode;
import pers.wc.leetcode.utils.XToString;

import java.util.ArrayDeque;
import java.util.Deque;

public class T0019 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        int n = 1;
        System.out.println(XToString.ListNodeToString(removeNthFromEnd_2(head, n)));
    }

    /**
     * 删除链表的倒数第N个结点 https://leetcode.cn/problems/remove-nth-node-from-end-of-list/
     *
     * @param head 链表的头结点
     * @param n    删除的位置
     * @return 链表的头结点
     */
    public static ListNode removeNthFromEnd_1(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        // 因为删除的是倒数第N个，所以使用栈来实现
        Deque<ListNode> stack = new ArrayDeque<>();
        ListNode cur = dummy;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        // 找到倒数第N个元素，直接删除
        for (int i = 0; i < n; i++) {
            stack.pop();
        }
        // 弹出栈顶元素
        ListNode prev = stack.peek();
        // 将栈顶元素与第N个元素之后的元素进行连接
        // 虽然链表结点被拆开放入栈中，但是每个节点的结构依然保存在其中，即next指针
        prev.next = prev.next.next;
        return dummy.next;
    }

    /**
     * 双指针法
     *
     * @param head 头结点
     * @param n    要删除元素的位置
     * @return 头结点
     */
    public static ListNode removeNthFromEnd_2(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode first = head;
        // 将第二个指针指向dummy，则可以在first遍历到链表结尾时，second正好指向要删除节点的前一个位置
        ListNode second = dummy;
        // 先将first向前走n个位置
        for (int i = 0; i < n; i++) {
            first = first.next;
        }
        // 当first走到结尾时，second指向待删除节点的前一个位置
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
}
