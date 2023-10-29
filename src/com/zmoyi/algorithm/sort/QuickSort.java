package com.zmoyi.algorithm.sort;

import java.util.Arrays;

/**
 * @author zhaofeng
 * @date 2023/10/29 19:18
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 3, 2, 1};
        sort(nums, 6);
        System.out.println(Arrays.toString(nums));

        int[] nums2 = {6, 11, 3, 9, 8};
        sort(nums2, 5);
        System.out.println(Arrays.toString(nums2));
    }

    public static void sort(int[] nums, int n) {
        quickSort(nums, 0, n - 1);
    }

    private static void quickSort(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }
        int q = partition(nums, low, high);
        quickSort(nums, low, q - 1);
        quickSort(nums, q + 1, high);
    }

    private static int partition(int[] nums, int low, int high) {
        int pivot = nums[high];
        int i = low;
        for (int j = low; j < high - 1; j++) {
            if (nums[j] < pivot) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                i++;
            }
        }
        int temp = nums[i];
        nums[i] = pivot;
        nums[high] = temp;
        return i;
    }

    /**
     * 分别声明两个数组X和Y，小于pivot的放在X数组，大于pivot的放在Y数组，然后再统一放到nums中
     *
     * @param nums
     * @param low
     * @param high
     * @return
     */
    private static int p2(int[] nums, int low, int high) {
        int[] X = new int[high - low + 1];
        int p1 = 0;
        int[] Y = new int[high - low + 1];
        int p2 = 0;

        int pivot = nums[high];
        for (int i = low; i <= high; i++) {
            if (nums[i] < pivot) {
                X[p1++] = nums[i];
            } else if (nums[i] > pivot) {
                Y[p2++] = nums[i];
            }
        }

        int k = 0;
        while (k < p1) {
            nums[low++] = X[k++];
        }
        int p = low;
        nums[low++] = pivot;
        k = 0;
        while (k < p2) {
            nums[low++] = Y[k++];
        }
        return p;
    }
}
