package com.zmoyi.algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

/**
 * 桶排序
 */
public class BucketSort {

    public static double[] sort(double[] array) {
        // 得到数列最大值和最小值的差值
        double max = array[0];
        double min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
            if (array[i] < min) {
                min = array[i];
            }
        }
        double d = max - min;

        // 初始化桶
        int bucketNum = array.length;
        ArrayList<LinkedList<Double>> bucket = new ArrayList<>();
        for (int i = 0; i < bucketNum; i++) {
            bucket.add(new LinkedList<>());
        }

        // 将每个元素都放到桶里
        for (int i = 0; i < array.length; i++) {
            int num = (int) ((array[i] - min) * (bucketNum - 1) / d);
            bucket.get(num).add(array[i]);
        }

        // 对每个桶中的元素进行排序
        for (int i = 0; i < bucket.size(); i++) {
            Collections.sort(bucket.get(i));
        }

        // 依次取出每个桶里的元素
        double[] result = new double[array.length];
        int index = 0;
        for (int i = 0; i < bucket.size(); i++) {
            for (int j = 0; j < bucket.get(i).size(); j++) {
                result[index++] = bucket.get(i).get(j);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        double[] array = {4.12, 6.421, 0.0023, 3.0, 2.123, 8.122, 4.12, 10.09};
        double[] result = sort(array);
        System.out.println(Arrays.toString(result));
    }
}
