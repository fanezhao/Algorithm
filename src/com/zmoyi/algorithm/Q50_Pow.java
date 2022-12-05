package com.zmoyi.algorithm;

/**
 * 实现 pow(x, n) ，即计算 x 的整数 n 次幂函数（即，x ^ n ）。
 */
public class Q50_Pow {

    /**
     * 暴力求解：时间超时
     * @param x
     * @param n
     * @return
     */
    public static double myPow(double x, int n) {

        if (n == 0) {
            return 1;
        }

        double temp = 1;

        if (n > 0) {
            for (int i = 0; i < n; i++) {
                temp = temp * x;
            }
            return temp;
        } else {
            for (int i = 0; i < n * -1; i++) {
                temp = temp * x;
            }
            return 1 / temp;
        }
    }

    /**
     * 递归：没写出来
     * @param x
     * @param n
     * @return
     */
    public static double myPow2(double x, int n) {
        if (n == 0) {
            return 1;
        }

        if (n % 2 == 0) {
            return myPow2(x, n / 2) * myPow2(x, n / 2);
        } else {
            return myPow2(x, n / 2) * myPow2(x, n / 2 + 1);
        }
    }

    /**
     * 官方解法（递归）
     *
     * @param
     */
    public static double myPow3(double x, int n) {
        long N = n;
        return N > 0 ? cal(x, n) : cal(x, -n);
    }

    public static double cal(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        double y = cal(x, n / 2);
        return n % 2 == 0 ? y * y : y * y * x;
    }

    public static void main(String[] args) {
//        System.out.println(myPow(2.0, 10));
//        System.out.println(myPow(2.1, 3));
//        System.out.println(myPow(2.0, -2));

        System.out.println(myPow2(2.0, 10));
        System.out.println(myPow2(2.1, 3));
//        System.out.println(myPow2(2.0, -2));
    }
}
