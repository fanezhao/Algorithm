package com.zmoyi.dataStructure.queue;

/**
 * @author zhaofeng
 * @date 2023/10/28 17:06
 */
public class ArrayQueueTest {

    public static void main(String[] args) {

        ArrayQueue queue = new ArrayQueue(3);
        System.out.println(queue.enqueue(1));
        System.out.println(queue);
        System.out.println(queue.enqueue(2));
        System.out.println(queue);
        System.out.println(queue.enqueue(3));
        System.out.println(queue);

        System.out.println(queue.dequeue());
        System.out.println(queue);

        System.out.println(queue.enqueue(4));
        System.out.println(queue);

        System.out.println(queue.dequeue());
        System.out.println(queue);

        System.out.println(queue.dequeue());
        System.out.println(queue);

        System.out.println(queue.dequeue());
        System.out.println(queue);
    }
}
