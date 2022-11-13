package com.zmoyi.algorithm.sort;

import java.util.Arrays;

public class CountSort {

    /**
     * 计数排序：朴素实现
     * @param array
     * @return
     */
    public static int[] sort(int[] array) {
        // 得到数列最大的值
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        // 根据最大的值统计数组的长度
        int[] countArray = new int[max + 1];
        // 遍历数列，填充统计数组
        for (int i = 0; i < array.length; i++) {
            countArray[array[i]]++;
        }

        // 遍历统计数组输出结果
        int index = 0;
        int[] sortArr = new int[array.length];
        for (int i = 0; i < countArray.length; i++) {
            for (int j = 0; j < countArray[i]; j++) {
                sortArr[index++] = i;
            }
        }

        return sortArr;
    }

    /**
     * 计数排序优化：稳定排序版本
     * @param array
     * @return
     */
    public static int[] sort2(int[] array) {
        // 得到数列的最大值得最小值，并算出差值
        int max = array[0];
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
            if (array[i] < min) {
                min = array[i];
            }
        }

        // 创建统计数组并统计对应元素个数
        int[] countArray = new int[max - min + 1];
        for (int i  = 0; i < array.length; i++) {
            countArray[array[i] - min]++;
        }

        // 统计数组做变形，后面的元素等于前面的元素之和
        for (int i = 1; i < countArray.length; i++) {
            countArray[i] += countArray[i - 1];
        }

        // 倒序遍历原始数组，从统计数组中找到正确的位置，输出到结果数组
        int[] sortArray = new int[array.length];
        for (int i = array.length - 1; i >= 0; i--) {
            sortArray[countArray[array[i] - min] - 1] = array[i];
            countArray[array[i] - min]--;
        }

        return sortArray;
    }

    public static void main(String[] args) {
        int[] array = {4, 4, 6, 5, 3, 2, 8, 1, 7, 5, 6, 0, 10};
        int[] result1 = sort(array);
        System.out.println(Arrays.toString(result1));

        int[] array2 = {90, 99, 95, 94, 95};
        int[] result2 = sort2(array2);
        System.out.println(Arrays.toString(result2));
    }
}
