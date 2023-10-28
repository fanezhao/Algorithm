package com.zmoyi.algorithm.recursion;

import com.zmoyi.ListNode;

/**
 * 合并两个有序链表（递归实现）
 *
 * @author zhaofeng
 * @date 2023/10/28 22:09
 */
public class MergeTwoList {

    public static ListNode mergeTwoList(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val < list2.val) {
            list1.next = mergeTwoList(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoList(list2.next, list1);
            return list2;
        }
    }
}
