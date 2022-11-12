package com.zmoyi.data_structure.queue;

/**
 * 循环队列
 */
public class MyQueue {

    private int[] array;

    // 头指针
    private int front;

    // 尾指针
    private int rear;

    public MyQueue(int capacity) {
        this.array = new int[capacity];
    }

    /**
     * 入队
     * @param element
     * @throws Exception
     */
    public void enQueue(int element) throws Exception {
        if ((rear + 1) % array.length == front) {
            throw new Exception("队列已满");
        }

        array[rear] = element;
        rear = (rear + 1) % array.length;
    }

    /**
     * 出队
     * @return
     */
    public int deQueue() throws Exception {
        if (rear == front) {
            throw new Exception("队列已空");
        }

        int deQueueElement = array[front];
        front = (front + 1) % array.length;
        return deQueueElement;
    }

    /**
     * 打印队列
     */
    public void output() {
        for (int i = front; i != rear; i = (i + 1) % array.length) {
            System.out.println(array[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        MyQueue myQueue = new MyQueue(5);
        myQueue.enQueue(1);
        myQueue.enQueue(5);
        myQueue.enQueue(7);
        myQueue.output();

        System.out.println("---");
        myQueue.deQueue();
        myQueue.output();
    }
}
