package com.zmoyi.algorithm.array;

import com.sun.org.apache.regexp.internal.RE;

public class Q1979_FindGCD {

    public int findGCD(int[] nums) {

        int max = nums[0];
        int min = nums[0];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
            if (nums[i] < min) {
                min = nums[i];
            }
        }

        int big = max > min ? max : min;
        int small = max < min ? max : min;

        if (big % small == 0) {
            return small;
        }

        // 从较小整数的一半开始递减，试图找到一个整数被big和small整除
        for (int i = small / 2; i > 1; i--) {
            if (big % i == 0 && small % i == 0) {
                return i;
            }
        }
        return 1;
    }

    public int findGCD2(int[] nums) {

        int max = nums[0];
        int min = nums[0];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
            if (nums[i] < min) {
                min = nums[i];
            }
        }

        return getGreatestCommonDivisorV2(max, min);
    }

    /**
     * 暴力破解
     * @param a
     * @param b
     * @return
     */
    public int getGreatestCommonDivisorV1(int a, int b) {
        int big = a > b ? a : b;
        int small = a < b ? a : b;

        if (big % small == 0) {
            return small;
        }

        // 从较小整数的一半开始递减，试图找到一个整数被big和small整除
        for (int i = small / 2; i > 1; i--) {
            if (big % i == 0 && small % i == 0) {
                return i;
            }
        }
        return 1;
    }

    /**
     * 辗转相除法（欧几里得算法）：两个正整数a和b（a > b），它们的最大公约数等于a除以b的余数c和b的约数。
     * 比如25和10的约数，等于25除以10的余数5和10的最大公约数，即为5。
     * @param a
     * @param b
     * @return
     */
    public int getGreatestCommonDivisorV2(int a, int b) {
        int big = a > b ? a : b;
        int small = a < b ? a : b;

        if (big % small == 0) {
            return small;
        }

        return getGreatestCommonDivisorV2(big % small, small);
    }

    public static void main(String[] args) {
        int[] nums = {7,5,6,8,3};

        Q1979_FindGCD gcd = new Q1979_FindGCD();
        System.out.println(gcd.findGCD(nums));
    }
}
