package com.zmoyi.dataStructure.queue;

/**
 * @author zhaofeng
 * @date 2023/10/28 18:10
 */
public class CircularQueueTest {

    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue(3);
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

        System.out.println(queue.enqueue(5));
        System.out.println(queue);;
    }
}
