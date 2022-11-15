package com.zmoyi.algorithm;

public class Q191_HammingWeight {

    /*

    编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）。

     */

    public static void main(String[] args) {

        System.out.println(hammingWeight2(13));
    }

    /**
     * 直接循环检查给定整数 n 的二进制位的每一位是否为 1
     * @param num
     * @return
     */
    public static int hammingWeight(int num) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((num & (1 << i)) != 0) {
                count++;
            }
        }
        return count;
    }

    /**
     * n & (n−1)，其运算结果恰为把 n 的二进制位中的最低位的 1 变为 0 之后的结果。
     * @param num
     * @return
     */
    public static int hammingWeight2(int num) {
        int count = 0;
        while (num != 0) {
            num = num & (num - 1);
            count ++;
        }
        return count;
    }
}
