package com.zmoyi.dataStructure.stack;

/**
 * @author zhaofeng
 * @date 2023/10/22 21:41
 * @desc
 */
public class ArrayStackTest {

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(10);
        stack.push("A");
        stack.push("B");
        stack.push("C");

        System.out.println(stack.size());
        System.out.println(stack.pop());
        System.out.println(stack.size());
        System.out.println(stack.pop());
        System.out.println(stack.size());
        System.out.println(stack.pop());
        System.out.println(stack.size());
        stack.push("D");
        System.out.println(stack.size());
    }
}
