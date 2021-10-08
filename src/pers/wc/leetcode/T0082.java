package pers.wc.leetcode;

import pers.wc.leetcode.utils.ListNode;

public class T0082 {
    public static void main(String[] args) {
        ListNode head = null;
        System.out.println(deleteDuplicates(head));
    }


    /**
     * 删除链表重复元素
     *
     * @param head 单链表
     * @return 删除重复元素后的单链表
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        // 防止链表的头结点被删除
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int temp = cur.next.val;
                while (cur.next != null && cur.next.val == temp) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
