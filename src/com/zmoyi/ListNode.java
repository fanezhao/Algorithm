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

    /**
     * 在当前节点后增加一个新节点
     * @param node
     */
    public void add(ListNode node) {
        if (this.next != null) {
            node.next = this.next;
            this.next = node;
        } else {
            this.next = node;
        }
    }

    /**
     * 删除当前节点的后一个节点并返回
     * @return
     */
    public ListNode removeAfter() {
        ListNode removedNode = this.next;
        if (removedNode == null) {
            return null;
        }
        this.next = this.next.next;
        return removedNode;
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
