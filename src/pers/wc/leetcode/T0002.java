package pers.wc.leetcode;

import pers.wc.leetcode.utils.ListNode;

public class T0002 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode res = addTwoNumbers(l1, l2);
        while (res != null) {
            System.out.printf("%d\t", res.val);
            res = res.next;
        }
    }

    /**
     * 计算两个数的和，数用两个链表逆序存放，即 个-十-百。
     *
     * @param l1 l1 = [2,4,3]，表示数字 342
     * @param l2 l2 = [5,6,4]，表示数字 465
     * @return [7, 0, 8]，即 342 + 465 = 807.
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode cur = res;
        // 进位
        int carry = 0;
        // l1 和 l2 的长度可能不一致
        // 直接将进位带入下一次运算，不需要在本次进行运算，在本次运算需要在末尾添加一个空节点
        while (l1 != null || l2 != null || carry != 0) {
            // l1 或 l2 为空时，赋值为0
            int num1 = l1 != null ? l1.val : 0;
            int num2 = l2 != null ? l2.val : 0;

            int nextNum = num1 + num2 + carry;
            carry = nextNum / 10;

            cur.next = new ListNode(nextNum % 10);
            cur = cur.next;

            // l1 和 l2 可能为空
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return res.next;
    }
}
