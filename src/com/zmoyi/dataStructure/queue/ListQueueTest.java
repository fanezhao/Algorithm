package com.zmoyi.dataStructure.queue;

/**
 * @author zhaofeng
 * @date 2023/10/28 17:28
 */
public class ListQueueTest {

    public static void main(String[] args) {
        ListQueue queue = new ListQueue(3);
        System.out.println(queue.enqueue(1));
        queue.print();
        System.out.println(queue.enqueue(2));
        queue.print();
        System.out.println(queue.enqueue(3));
        queue.print();

        System.out.println(queue.dequeue());
        queue.print();

        System.out.println(queue.enqueue(4));
        queue.print();

        System.out.println(queue.dequeue());
        queue.print();

        System.out.println(queue.dequeue());
        queue.print();

        System.out.println(queue.dequeue());
        queue.print();
    }
}
