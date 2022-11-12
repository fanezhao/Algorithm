package com.zmoyi.data_structure.linked_list;

public class MyLinkedList {

    /** 头节点 */
    private LinkedListNode head;
    /** 尾节点 */
    private LinkedListNode tail;
    /** 链表实际长度 */
    private int size;

    /**
     * 链表插入元素
     * @param data
     * @param index
     */
    public void insert(int data, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("超限");
        }

        LinkedListNode insertedNode = new LinkedListNode(data);

        if (size == 0) {
            head = insertedNode;
            tail = insertedNode;
        } else if (index == 0) {    // 插入头节点
            insertedNode.next = head;
            head = insertedNode;
        } else if (size == index) { // 插入尾节点
            tail.next = insertedNode;
            tail = insertedNode;
        } else {    // 中间插入
            LinkedListNode previous = get(index - 1);
            insertedNode.next = previous.next;
            previous.next = insertedNode;
        }
        size++;
    }

    /**
     * 删除链表元素
     * @param index
     * @return
     */
    public LinkedListNode remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("超限");
        }

        LinkedListNode removeNode = null;
        if (index == 0) {
            removeNode = head;
            head = head.next;
        } else if (index == size - 1) {
            LinkedListNode previous = get(index - 1);
            removeNode = previous.next;
            previous.next = null;
            tail = previous;
        } else {
            LinkedListNode previous = get(index - 1);
            removeNode = previous.next;
            previous.next = previous.next.next;
        }
        size--;
        return removeNode;
    }

    /**
     * 获取节点
     * @param index
     * @return
     */
    public LinkedListNode get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("超限");
        }

        LinkedListNode temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    /**
     * 打印链表
     */
    public void output() {
        LinkedListNode temp = head;
        for (int i = 0; i < size; i++) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.insert(1, 0);
        linkedList.insert(5, 1);
        linkedList.insert(7, 2);
        linkedList.insert(3, 1);
        linkedList.output();

        linkedList.remove(1);
        System.out.println("---");
        linkedList.output();
    }
}
