package com.zmoyi.algorithm.sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 快速排序
 */
public class QuickSort {

    /**
     * 快排：递归实现
     * @param array
     * @param startIndex
     * @param endIndex
     */
    public static void sort(int[] array, int startIndex, int endIndex) {
        // 递归结束条件：startIndex大于或等于endIndex
        if (startIndex >= endIndex) {
            return;
        }

        // 获取基准元素位置
        int pivotIndex = partition2(array, startIndex, endIndex);
        // 根据基准元素，分两部分进行递归
        sort(array, startIndex, pivotIndex - 1);
        sort(array, pivotIndex + 1, endIndex);
    }

    /**
     * 分治：双边循环
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

    /**
     * 分治：单边循环
     * @param array
     * @param startIndex
     * @param endIndex
     * @return
     */
    public static int partition2(int[] array, int startIndex, int endIndex) {
        int pivot = array[startIndex];
        int mark = startIndex;

        for (int i = startIndex + 1; i <= endIndex; i++) {
            if (array[i] < pivot) {
                mark++;
                int tmp = array[i];
                array[i] = array[mark];
                array[mark] = tmp;
            }
        }

        array[startIndex] = array[mark];
        array[mark] = pivot;
        return mark;
    }

    /**
     * 快排：非递归实现
     * @param arr
     * @param startIndex
     * @param endIndex
     */
    public static void sort2(int[] arr, int startIndex, int endIndex) {
        // 用一个集合栈来代替递归的函数栈
        Stack<Map<String, Integer>> quickSortStack = new Stack<>();
        // 整个数列的起始下标，以哈希的形式入栈
        Map<String, Integer> rootParam = new HashMap<>();
        rootParam.put("startIndex", startIndex);
        rootParam.put("endIndex", endIndex);
        quickSortStack.push(rootParam);
        // 循环结束条件：栈为空时
        while (!quickSortStack.isEmpty()) {
            Map<String, Integer> param = quickSortStack.pop();
            int pivotIndex = partition(arr, param.get("startIndex"), param.get("endIndex"));

            if (param.get("startIndex") < pivotIndex - 1) {
                Map<String, Integer> leftParam = new HashMap<>();
                leftParam.put("startIndex", startIndex);
                leftParam.put("endIndex", pivotIndex - 1);
                quickSortStack.push(leftParam);
            }

            if (param.get("endIndex") > pivotIndex + 1) {
                Map<String, Integer> rightParam = new HashMap<>();
                rightParam.put("startIndex", pivotIndex + 1);
                rightParam.put("endIndex", endIndex);
                quickSortStack.push(rightParam);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 4, 6, 5, 3, 2, 8, 1};
        sort2(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

}
