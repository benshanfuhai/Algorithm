package pers.wc.leetcode;

import pers.wc.leetcode.utils.ListNode;

import java.util.HashMap;
import java.util.Map;

public class T0817 {
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(5);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        int[] nums = {0, 3, 1, 4};
        // 2
        System.out.println(numComponents(head, nums));
    }

    /**
     * 统计链表 head 中组件的个数，组成组件的元素由数组 nums 提供，组件的定义为连续的元素，最小长度为 1。
     *
     * @param head 链表头结点，链表中元素唯一。
     * @param nums 数组，数组中元素为链表中元素的子集，并且唯一。
     * @return 返回链表中组件的个数
     */
    public static int numComponents(ListNode head, int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>();
        ListNode temp = head;
        // 将链表元素存放在哈希表中，Key 为当前元素值，初始 Value 为 false
        while (head != null) {
            map.put(head.val, false);
            head = head.next;
        }
        // 如果数组中元素在链表中存在，修改值为 true
        for (int num : nums) {
            map.put(num, true);
        }
        int count = 0;
        // 结合哈希表遍历链表，统计数组元素在链表中连续出现的情况
        while (temp != null) {
            int tempCount = 0;
            while (map.get(temp.val)) {
                tempCount += 1;
                if (temp.next != null) {
                    temp = temp.next;
                } else {
                    break;
                }
            }
            // 当连续出现的长度大于 1 时，对 count 加 1
            if (tempCount != 0) {
                count += 1;
            }
            temp = temp.next;
        }
        return count;
    }
}
