package com.zmoyi.algorithm.sort;

import java.util.Arrays;

/**
 * 快速排序
 */
public class QuickSort {

    public static void sort(int[] array, int startIndex, int endIndex) {
        // 递归结束条件：startIndex大于或等于endIndex
        if (startIndex >= endIndex) {
            return;
        }

        // 获取基准元素位置
        int pivotIndex = partition(array, startIndex, endIndex);
        // 根据基准元素，分两部分进行递归
        sort(array, startIndex, pivotIndex - 1);
        sort(array, pivotIndex + 1, endIndex);
    }

    /**
     * 双边循环
     * @param array
     * @param startIndex
     * @param endIndex
     * @return
     */
    public static int partition(int[] array, int startIndex, int endIndex) {
        // 取第一个位置的元素作为基准元素
        int pivot = array[startIndex];
        int left = startIndex;
        int right = endIndex;

        while (left != right) {
            // 控制right指针比较并左移
            while (left < right && array[right] > pivot) {
                right--;
            }
            // 控制left指针比较并右移
            while (left < right && array[left] <= pivot) {
                left++;
            }
            // 交换left和right指针指向的元素
            if (left < right) {
                int tmp = array[right];
                array[right] = array[left];
                array[left] = tmp;
            }
        }

        // pivot和指针重合点交换
        array[startIndex] = array[left];
        array[left] = pivot;

        return left;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 4, 6, 5, 3, 2, 8, 1};
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

}
