package com.zmoyi.algorithm.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort {

    /**
     * 冒泡排序基础版
     * @param array
     */
    public static void sort1(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                int tmp;
                if (array[j] > array[j + 1]) {
                    tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
    }

    /**
     * 冒泡排序2.0：排序过程中已经有序了就立马跳出排序
     * @param array
     */
    public static void sort2(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            boolean isSorted = true;
            for (int j = 0; j < array.length - 1 - i; j++) {
                int tmp = 0;
                if (array[j] > array[j + 1]) {
                    tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    // 因为有元素交换，所以当前还不是有序的
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
        }
    }

    /**
     * 冒泡排序3.0：每轮对比只需要对比前面一段无序的即可
     * @param array
     */
    public static void sort3(int[] array) {
        // 最后一次交换的时间
        int lastExchangeIndex = 0;
        // 无序数列的边界，每次比较只需要到这里为此
        int sortBorder = array.length - 1;
        for (int i = 0; i < array.length - 1; i++) {
            boolean isSorted = true;
            // 只需要遍历到有序队列边界
            for (int j = 0; j < sortBorder; j++) {
                int tmp;
                if (array[j] > array[j + 1]) {
                    tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    // 因为有元素交换，所以当前还不是有序的
                    isSorted = false;
                    // 更新最后一次交换的位置
                    lastExchangeIndex = j;
                }
            }
            sortBorder = lastExchangeIndex;
            if (isSorted) {
                break;
            }
        }
    }

    /**
     * 鸡尾酒排序
     * @param array
     */
    public static void sort4(int[] array) {
        int tmp = 0;
        for (int i = 0; i < array.length / 2; i++) {
            boolean isSorted = true;
            for (int j = i; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }

            isSorted = true;
            for (int j = array.length - 1 - i; j > i; j--) {
                if (array[j] < array[j - 1]) {
                    tmp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = tmp;
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {5, 8, 6, 3, 9, 2, 1, 7};
        sort1(array);
        System.out.println(Arrays.toString(array));

        int[] array2 = {5, 8, 6, 3, 9, 2, 1, 7};
        sort2(array2);
        System.out.println(Arrays.toString(array2));

        int[] array3 = {5, 8, 6, 3, 9, 2, 1, 7};
        sort3(array3);
        System.out.println(Arrays.toString(array3));

        int[] array4 = {5, 8, 6, 3, 9, 2, 1, 7};
        sort4(array4);
        System.out.println(Arrays.toString(array4));
    }

}
