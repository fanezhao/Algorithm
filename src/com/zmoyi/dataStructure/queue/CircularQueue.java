package com.zmoyi.dataStructure.queue;

import java.util.Arrays;

/**
 * 用数组循环队列：循环队列存储元素的个数比数组长度要少一个
 * @author zhaofeng
 * @date 2023/10/28 17:57
 */
public class CircularQueue {

    private int[] arr;
    private Integer cap;
    private Integer count;
    private Integer head;
    private Integer tail;

    public CircularQueue(Integer cap) {
        this.cap = cap + 1;
        this.arr = new int[this.cap];
        this.count = 0;
        this.head = 0;
        this.tail = 0;
    }

    public boolean enqueue(int val) {
        int nextTail = (tail + 1) % cap;
        if (nextTail == head) {
            return false;
        }
        arr[tail] = val;
        tail = nextTail;
        count++;
        return true;
    }

    public int dequeue() {
        if (head == tail) {
            return -1;
        }
        int ret = arr[head];
        head = (head + 1) % cap;
        count--;
        return ret;
    }

    @Override
    public String toString() {
        return "CircularQueue{" +
                "arr=" + Arrays.toString(arr) +
                ", cap=" + cap +
                ", count=" + count +
                ", head=" + head +
                ", tail=" + tail +
                '}';
    }
}
