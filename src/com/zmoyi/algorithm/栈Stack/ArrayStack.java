package com.zmoyi.algorithm.栈Stack;

/**
 * @author zhaofeng
 * @date 2023/10/22 21:29
 * @desc 基于数组实现的顺序栈
 */
public class ArrayStack {

    private Object[] arr;
    private int cap;
    private Integer count;

    public ArrayStack(Integer cap) {
        this.cap = cap;
        this.count = 0;
        this.arr = new Object[cap];
    }

    public boolean push(Object val) {
        if (count == cap) {
            return false;
        }
        arr[count++] = val;
        return true;
    }

    public Object pop() {
        if (count == 0) {
            return null;
        }
        return arr[--count];
    }

    public Integer size() {
        return count;
    }
}
