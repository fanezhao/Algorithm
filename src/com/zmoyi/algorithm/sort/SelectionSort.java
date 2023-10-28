package com.zmoyi.algorithm.sort;

import java.util.Arrays;

/**
 * 选择排序
 * @author zhaofeng
 * @date 2023/10/28 21:15
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 3, 2, 1};
        sort(nums);
        System.out.println(Arrays.toString(nums));

        int[] nums2 = {4, 5, 6, 3, 2, 1};
        sort2(nums2);
        System.out.println(Arrays.toString(nums2));

        int[] nums3 = {4, 5, 6, 3, 2, 1};
        sort3(nums3);
        System.out.println(Arrays.toString(nums3));
    }

    public static void sort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int minIdx = i;
            int min = nums[i];
            int j = i + 1;
            while (j < nums.length) {
                if (nums[j] < min) {
                    min = nums[j];
                    minIdx = j;
                }
                j++;
            }
            int temp = nums[i];
            nums[i] = min;
            nums[minIdx] = temp;
        }
    }

    public static void sort2(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int minIdx = i;
            int min = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < min) {
                    minIdx = j;
                    min = nums[j];
                }
            }
            int temp = nums[i];
            nums[i] = min;
            nums[minIdx] = temp;
        }
    }

    public static void sort3(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int minIdx = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIdx]) {
                    minIdx = j;
                }
            }
            if (i != minIdx) {
                int temp = nums[i];
                nums[i] = nums[minIdx];
                nums[minIdx] = temp;
            }
        }
    }
}
