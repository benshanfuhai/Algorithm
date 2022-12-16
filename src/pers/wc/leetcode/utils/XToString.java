package pers.wc.leetcode.utils;

/**
 * 实现将各类型数据结构转化为字符串
 */
public class XToString {
    /**
     * 将一个单链表转化为一个字符串
     *
     * @param head 链表头结点
     * @return 转化为字符串的结果
     */
    public static String ListNodeToString(ListNode head) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        while (head != null) {
            stringBuilder.append(head.val).append(", ");
            head = head.next;
        }
        // 去除最后一个","号
        stringBuilder.replace(stringBuilder.length() - 2, stringBuilder.length() - 1, "]");
        return stringBuilder.toString();
    }
}
