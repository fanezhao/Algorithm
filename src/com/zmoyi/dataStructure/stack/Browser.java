package com.zmoyi.dataStructure.stack;

import java.util.Stack;

/**
 * 用两个栈实现浏览器前进后退功能
 * @author zhaofeng
 * @date 2023/10/28 16:35
 */
public class Browser {

    public static void main(String[] args) {
        System.out.println(newPage("A"));
        System.out.println(newPage("B"));
        System.out.println(newPage("C"));

        System.out.println(next());
        System.out.println(prev());
        System.out.println(prev());
        System.out.println(prev());
        System.out.println(next());
        System.out.println(newPage("D"));
        System.out.println(prev());
    }

    private static Stack<String> X = new Stack<>();

    private static Stack<String> Y = new Stack<>();

    private static String newPage(String page) {
        X.push(page);
        if (!Y.isEmpty()) {
            Y.clear();
        }
        return page;
    }

    private static String prev() {
        if (X.size() == 1) {
            return "null";
        }
        Y.push(X.pop());
        return X.peek();
    }

    private static String next() {
        if (Y.isEmpty()) {
            return "null";
        }
        return X.push(Y.pop());
    }
}
