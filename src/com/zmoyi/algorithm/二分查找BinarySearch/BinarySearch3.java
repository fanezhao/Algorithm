package com.zmoyi.algorithm.二分查找BinarySearch;

public class BinarySearch3 {

    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 5, 6, 8, 8, 8, 11, 18};
        System.out.println(binarySearch1(nums, 0));
        System.out.println(binarySearch1(nums, 8));
        System.out.println(binarySearch2(nums, 8));
        System.out.println("-----");

        int[] nums1 = {3, 4, 6, 7, 10};
        System.out.println(binarySearch3(nums1, 1));
        System.out.println(binarySearch3(nums1, 3));
        System.out.println(binarySearch3(nums1, 5));
        System.out.println(binarySearch3(nums1, 8));
        System.out.println(binarySearch3(nums1, 10));
        System.out.println(binarySearch3(nums1, 11));
        System.out.println("-----");

        int[] nums2 = {3, 5, 6, 8, 9, 10};
        System.out.println(binarySearch4(nums2, 7));
        System.out.println(binarySearch4(nums2, 8));
        System.out.println(binarySearch4(nums2, 2));
    }

    /**
     * 查找第一个值等于给定值的元素
     * @param nums
     * @param target
     * @return
     */
    public static int binarySearch1(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] < target) {
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                if ((mid == 0) || nums[mid - 1] != target) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    /**
     * 变体2：查找最后一个值等于给定值的元素
     * @param nums
     * @param target
     * @return
     */
    public static int binarySearch2(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] < target) {
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                if ((mid == nums.length - 1) || nums[mid + 1] != target) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    /**
     * 查找第一个大于等于给定值的元素
     * @param nums
     * @param target
     * @return
     */
    public static int binarySearch3(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] >= target) {
                if (mid == 0 || nums[mid - 1] < target) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 查找最后一个小于等于给定值的元素
     * @param nums
     * @param target
     * @return
     */
    public static int binarySearch4(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] <= target) {
                if (mid == nums.length - 1 || nums[mid + 1] > target) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
