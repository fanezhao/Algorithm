package com.zmoyi.algorithm.栈Stack;

/**
 * @author zhaofeng
 * @date 2023/10/22 21:53
 * @desc
 */
public class ListStackTest {

    public static void main(String[] args) {
        ListStack stack = new ListStack(2);
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.size());
        System.out.println(stack.pop());
        System.out.println(stack.size());
        System.out.println(stack.pop());
        System.out.println(stack.size());
        System.out.println(stack.pop());
        System.out.println(stack.size());
        stack.push(4);
        System.out.println(stack.size());
    }
}
