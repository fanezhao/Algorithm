package com.zmoyi.dataStructure.queue;

import com.zmoyi.ListNode;

/**
 * @author zhaofeng
 * @date 2023/10/28 17:23
 */
public class ListQueue {

    private ListNode head;
    private ListNode tail;
    private Integer cap;
    private Integer count;

    public ListQueue(Integer cap) {
        this.cap = cap;
        this.count = 0;
        this.head = null;
        this.tail = this.head;
    }

    public boolean enqueue(int val) {
        if (count == cap) {
            return false;
        }
        ListNode node = new ListNode(val);
        if (tail == null) {
            tail = node;
            if (head == null) {
                head = tail;
            }
        } else {
            tail.next = node;
            tail = node;
        }
        count++;
        return true;
    }

    public int dequeue() {
        if (count == 0) {
            return -1;
        }
        ListNode node = head;
        head = head.next;
        node.next = null;
        count--;
        return node.val;
    }

    public void print() {
        StringBuilder sb = new StringBuilder();
        ListNode temp = head;
        while (temp != null) {
            sb.append(temp.val).append(", ");
            temp = temp.next;
        }
        System.out.println(sb);
    }
}
