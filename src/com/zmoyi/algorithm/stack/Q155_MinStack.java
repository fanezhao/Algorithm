package com.zmoyi.algorithm.stack;

import java.util.Objects;
import java.util.Stack;

/**
 * 最小栈：入栈、出栈、获取栈最小值
 */
public class Q155_MinStack {

    /*

    设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。

实现 MinStack 类:

MinStack() 初始化堆栈对象。
void push(int val) 将元素val推入堆栈。
void pop() 删除堆栈顶部的元素。
int top() 获取堆栈顶部的元素。
int getMin() 获取堆栈中的最小元素。

     */

    public Stack<Integer> mainStack = new Stack<>();
    public Stack<Integer> minStack = new Stack<>();

    /**
     * 辅助栈解法
     * @param element
     */
    public void push(Integer element) {
        if (minStack.isEmpty() || element <= minStack.peek()) {
            minStack.push(element);
        }

        mainStack.push(element);
    }

    public Integer pop() {
        if (Objects.equals(mainStack.peek(), minStack.peek())) {
            minStack.pop();
        }

        return mainStack.pop();
    }

    public Integer getTop() throws Exception {
        if (mainStack.isEmpty()) {
            throw new Exception("Stack is empty");
        }
        return mainStack.peek();
    }

    public Integer getMin() throws Exception {
        if (minStack.isEmpty()) {
            throw new Exception("Stack is empty");
        }

        return minStack.peek();
    }

    public static void main(String[] args) throws Exception {
//        Q155_MinStack stack = new Q155_MinStack();
//        stack.push(9);
//        stack.push(4);
//        stack.push(7);
//        stack.push(3);
//        stack.push(8);
//        stack.push(5);
//        System.out.println(stack.getMin());
//        System.out.println(stack.getTop());
//
//        stack.pop();
//        stack.pop();
//        stack.pop();
//        System.out.println(stack.getMin());


        MinStack2 stack = new MinStack2();
        stack.push(9);
        stack.push(4);
        stack.push(7);
        stack.push(3);
        stack.push(8);
        stack.push(5);
        System.out.println(stack.getMin());
        System.out.println(stack.top());

        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println(stack.getMin());
    }
}

/**
 * 非辅助栈解法
 */
class MinStack2 {

    private Stack<Integer> stack;
    private int min = 0;

    public MinStack2() {
        this.stack = new Stack<>();
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            min = val;
            stack.push(0);
            return;
        }

        stack.push(val - min);
        min = Math.min(val, min);
    }

    public void pop() {
        Integer top = stack.pop();
        if (top < 0) {
            min -= top;
        }
    }

    public int top() {
        Integer d = stack.peek();
        if (d < 0) {
            return min;
        } else {
            return min + d;
        }
    }

    public int getMin() {
        return min;
    }
}