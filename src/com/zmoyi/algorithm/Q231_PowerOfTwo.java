package com.zmoyi.algorithm;

/**
 * 给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
 *
 * 如果存在一个整数 x 使得 n == 2 ^ x ，则认为 n 是 2 的幂次方。
 */
public class Q231_PowerOfTwo {

    /**
     * 从1开始，每次乘2，如果在任意时候这个数等于num，则说明它是2的次幂
     * @param num
     * @return
     */
    public boolean isPowerOfTwo(int num) {
        int temp = 1;
        while (temp <= num) {
            if (temp == num) {
                return true;
            }
            temp = temp * 2;
        }
        return false;
    }

    /**
     * 从1开始，每次乘2，如果在任意时候这个数等于num，则说明它是2的次幂。使用位移计算
     * @param num
     * @return
     */
    public boolean isPowerOfTwo2(int num) {
        int temp = 1;
        while (temp <= num) {
            if (temp == num) {
                return true;
            }
            temp = temp << 1;
        }
        return false;
    }

    /**
     * 如果一个数的2的次幂，那它与上当前这个数减1，结果等于0，例如8
     * 1 0 0 0
     & 0 1 1 1
     * -------
     * 0 0 0 0
     * @param num
     * @return
     */
    public boolean isPowerOfTwo3(int num) {
        return (num & num - 1) == 0;
    }
}
