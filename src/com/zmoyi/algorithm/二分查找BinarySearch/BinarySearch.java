package com.zmoyi.algorithm.二分查找BinarySearch;

/**
 * 二分查找算法
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        System.out.println(binarySearch1(nums, 2));
        System.out.println(binarySearch1(nums, 1));

        System.out.println(binarySearch2(nums, 2));
        System.out.println(binarySearch2(nums, 1));
    }

    /**
     * 常规实现
     * @param nums
     * @param target
     * @return
     */
    public static int binarySearch1(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 递归实现
     * @param nums
     * @param target
     * @return
     */
    public static int binarySearch2(int[] nums, int target) {
        return binarySearchInternally(nums, 0, nums.length - 1, target);
    }

    private static int binarySearchInternally(int[] nums, int low, int high, int target) {
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                return binarySearchInternally(nums, mid + 1, high, target);
            } else {
                return binarySearchInternally(nums, low, mid - 1, target);
            }
        }
        return -1;
    }

    /**
     * 变形1：查找第一个值等于给定值的元素
     * @param nums
     * @param target
     * @return
     */
    public static int binarySearch(int[] nums, int target) {
        return -1;
    }
}
