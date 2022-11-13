package com.zmoyi.algorithm.sort;

import java.util.Arrays;

public class BinaryHeapSort {

    /**
     * "下沉"调整
     * @param array
     * @param parentIndex
     * @param length
     */
    public static void downAdjust(int[] array, int parentIndex, int length) {
        // temp用于保存父节点值，用于最后的赋值
        int temp = array[parentIndex];
        int childIndex = parentIndex * 2 + 1;
        while (childIndex < length) {
            // 如果有右孩子，且右孩子小于左孩子的值，则定位到右孩子
            if (childIndex + 1 < length && array[childIndex + 1] < array[childIndex]) {
                childIndex++;
            }
            // 如果父节点小于任何一个孩子的值，则直接跳出
            if (temp >= array[childIndex]) {
                break;
            }
            // 无需真正交换，单向赋值即可
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = 2 * childIndex + 1;
        }
        array[parentIndex] = temp;
    }

    /**
     * 堆排序，升序
     * @param array
     */
    public static void sort(int[] array) {
        for (int i = (array.length - 2) / 2; i >= 0; i--) {
            downAdjust(array, i, array.length);
        }
        System.out.println(Arrays.toString(array));
        for (int i = array.length - 1; i > 0; i--) {
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;
            downAdjust(array, 0, i);
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 2, 6, 5, 7, 8, 9, 10, 0};
        sort(array);
        System.out.println(Arrays.toString(array));
    }
}
