package com.zmoyi.dataStructure.stack;

import com.zmoyi.ListNode;

import java.util.Objects;

/**
 * @author zhaofeng
 * @date 2023/10/22 21:44
 * @desc 用链表实现顺序栈
 */
public class ListStack {

    private ListNode head;
    private Integer cap;
    private Integer count;

    public ListStack(Integer cap) {
        this.head = new ListNode();
        this.cap = cap;
        this.count = 0;
    }

    public boolean push(int val) {
        if (count == cap) {
            return false;
        }
        head.add(new ListNode(val));
        count++;
        return true;
    }

    public int pop() {
        if (count == 0) {
            return -1;
        }
        ListNode node = head.removeAfter();
        count--;
        return Objects.nonNull(node) ? node.val : -1;
    }

    public Integer size() {
        return count;
    }
}
