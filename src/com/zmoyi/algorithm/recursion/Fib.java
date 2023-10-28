package com.zmoyi.algorithm.recursion;

/**
 * 斐波那契队列
 * @author zhaofeng
 * @date 2023/10/28 22:06
 */
public class Fib {

    public static void main(String[] args) {
        System.out.println(fib(3));
    }

    public static int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }
}
