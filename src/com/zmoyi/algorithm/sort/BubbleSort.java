package com.zmoyi.algorithm.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 *
 * @author zhaofeng
 * @date 2023/10/28 18:21
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 3, 2, 1};
        sort(nums);
        System.out.println(Arrays.toString(nums));

        int[] nums2 = {4, 5, 6, 3, 2, 1};
        sort2(nums2);
        System.out.println(Arrays.toString(nums2));
    }

    private static void sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j + 1] < nums[j]) {
                    int temp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }

    /**
     * 如果没有交换，就代表已经有序了
     * @param nums
     */
    private static void sort2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            boolean exchange = false;
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j + 1] < nums[j]) {
                    int temp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = temp;
                    exchange = true;
                }
            }
            if (!exchange) {
                break;
            }
        }
    }
}
