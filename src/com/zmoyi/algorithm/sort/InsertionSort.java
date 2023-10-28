package com.zmoyi.algorithm.sort;

import java.util.Arrays;

/**
 * 插入排序
 * @author zhaofeng
 * @date 2023/10/28 20:46
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 3, 2, 1};
        sort(nums);
        System.out.println(Arrays.toString(nums));

        int[] nums2 = {4, 5, 6, 3, 2, 1};
        sort2(nums2);
        System.out.println(Arrays.toString(nums2));
    }

    public static void sort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (nums[j] > num) {
                    nums[j + 1] = nums[j];
                } else {
                    break;
                }
            }
            nums[j + 1] = num;
        }
    }

    public static void sort2(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            int j = i - 1;
            while (j >= 0) {
                if (nums[j] > nums[j + 1]) {
                    nums[j + 1] = nums[j];
                } else {
                    break;
                }
                j--;
            }
            nums[j + 1] = num;
        }
    }
}
