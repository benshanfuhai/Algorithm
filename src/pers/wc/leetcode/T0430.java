package pers.wc.leetcode;

import pers.wc.leetcode.utils.Node;

public class T0430 {
    public static void main(String[] args) {
        flatten(null);
    }

    /**
     * 扁平化多级双向链表
     *
     * @param head 多级链表，例如[1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
     *             -            1 -- 2 -- 3 -- 4 -- 5 -- 6 -- null
     *             -           null null  |
     *             -                      7 -- 8 -- 9 -- null
     *             -                     null  |
     *             -                          11 -- 12 -- null
     * @return 扁平化后的链表 [1, 2, 3, 7, 8, 11, 12, 9, 10, 4, 5, 6]
     */
    public static Node flatten(Node head) {
        dfs(head);
        return head;
    }

    public static Node dfs(Node node) {
        Node cur = node;
        // 子链表结尾结点
        Node last = null;
        while (cur != null) {
            Node next = cur.next;
            // 先处理子链表
            if (cur.child != null) {
                Node childLast = dfs(cur.child);
                next = cur.next;
                // 连接node与child
                cur.next = cur.child;
                cur.child.prev = cur;
                // 若next不为空，则连接childLast和next
                if (next != null) {
                    childLast.next = next;
                    next.prev = childLast;
                }
                // child置为空
                cur.child = null;
                last = childLast;
            } else {
                last = cur;
            }
            cur = next;
        }
        return last;
    }
}
