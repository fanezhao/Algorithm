package com.zmoyi.algorithm.sort;

import java.util.Arrays;

/**
 * 归并排序
 * @author zhaofeng
 * @date 2023/10/29 16:41
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] nums3 = {4, 5, 6, 3, 2, 1};
        sort(nums3, 6);
        System.out.println(Arrays.toString(nums3));
    }

    public static void sort(int[] nums, int n) {
        mergeSort(nums, 0, n - 1);
    }

    private static void mergeSort(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }

        int mid = low + ((high - low) >> 2);
        mergeSort(nums, low, mid);
        mergeSort(nums, mid + 1, high);
        merge(nums, low, mid, high);
    }

    private static void merge(int[] nums, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        int[] temp = new int[high - low + 1];
        int t = 0;
        while (i <= mid && j <= high) {
            if (nums[i] < nums[j]) {
                temp[t++] = nums[i++];
            } else {
                temp[t++] = nums[j++];
            }
        }

        while (i <= mid) {
            temp[t++] = nums[i++];
        }
        while (j <= high) {
            temp[t++] = nums[j++];
        }
        // 将最终的结果复制给原数组
        for (int k = 0; k < temp.length; k++) {
            nums[low + k] = temp[k];
        }
    }
}
