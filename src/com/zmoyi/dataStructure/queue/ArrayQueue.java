package com.zmoyi.dataStructure.queue;

import java.util.Arrays;

/**
 * 用数据实现队列
 *
 * @author zhaofeng
 * @date 2023/10/28 16:57
 */
public class ArrayQueue {

    /**
     * 存储数据的数组
     */
    private Object[] arr;

    /**
     * 数组容量
     */
    private Integer cap;

    /**
     * 数组中有效数据的个数
     */
    private Integer count;

    /**
     * 头指针：下一个准备出队的数组下标
     */
    private Integer head;

    /**
     * 尾指针：下一下准备入队的数组下标
     */
    private Integer tail;

    public ArrayQueue(Integer cap) {
        this.cap = cap;
        this.arr = new Object[cap];
        this.count = 0;
        this.head = 0;
        this.tail = 0;
    }

    public boolean enqueue(Object obj) {
        if (tail == cap) {
            if (head == 0) {
                return false;
            }
            for (int i = head; i < tail; i++) {
                arr[i - head] = arr[i];
            }
            tail = tail - head;
            head = 0;
        }
        arr[tail++] = obj;
        count++;
        return true;
    }

    public Object dequeue() {
        if (head == tail) {
            return null;
        }
        Object o = arr[head++];
        count--;
        return o;
    }

    public Integer size() {
        return count;
    }

    @Override
    public String toString() {
        return "ArrayQueue{" +
                "arr=" + Arrays.toString(arr) +
                ", cap=" + cap +
                ", count=" + count +
                ", head=" + head +
                ", tail=" + tail +
                '}';
    }
}
