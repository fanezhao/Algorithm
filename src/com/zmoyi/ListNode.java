package com.zmoyi;

public class ListNode {

    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public void add(ListNode node) {
        if (this.next != null) {
            node.next = this.next;
            this.next = node;
        } else {
            this.next = node;
        }
    }

    public void print() {
        System.out.printf("%s%n", this.val);
        ListNode temp = this.next;
        while (temp != null) {
            System.out.printf("%s%n", temp.val);
            temp = temp.next;
        }
    }
}
