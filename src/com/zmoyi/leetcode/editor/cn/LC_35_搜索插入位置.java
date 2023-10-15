//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
//
// 请必须使用时间复杂度为 O(log n) 的算法。
//
//
//
// 示例 1:
//
//
//输入: nums = [1,3,5,6], target = 5
//输出: 2
//
//
// 示例 2:
//
//
//输入: nums = [1,3,5,6], target = 2
//输出: 1
//
//
// 示例 3:
//
//
//输入: nums = [1,3,5,6], target = 7
//输出: 4
//
//
//
//
// 提示:
//
//
// 1 <= nums.length <= 10⁴
// -10⁴ <= nums[i] <= 10⁴
// nums 为 无重复元素 的 升序 排列数组
// -10⁴ <= target <= 10⁴
//
//
// Related Topics 数组 二分查找 👍 2165 👎 0


package com.zmoyi.leetcode.editor.cn;

public class LC_35_搜索插入位置 {
    public static void main(String[] args) {
        Solution solution = new LC_35_搜索插入位置().new Solution();
        System.out.println(solution.searchInsert(new int[]{1, 3, 5, 6}, 5));
        System.out.println(solution.searchInsert(new int[]{1, 3, 5, 6}, 2));
        System.out.println(solution.searchInsert(new int[]{2, 3, 5, 6}, 1));
        System.out.println(solution.searchInsert(new int[]{1, 3, 5, 6}, 7));

        System.out.println(solution.searchInsert2(new int[]{1, 3, 5, 6}, 5));
        System.out.println(solution.searchInsert2(new int[]{1, 3, 5, 6}, 2));
        System.out.println(solution.searchInsert2(new int[]{2, 3, 5, 6}, 1));
        System.out.println(solution.searchInsert2(new int[]{1, 3, 5, 6}, 7));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 二分查找：当num[mid] = targe时，mid就是要插入的位置；如果找到最后都没找到等于target的元素，那low就是要插入的位置
         * @param nums
         * @param target
         * @return
         */
        public int searchInsert(int[] nums, int target) {
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
            return low;
        }

        /**
         * 递归实现
         * @param nums
         * @param target
         * @return
         */
        public int searchInsert2(int[] nums, int target) {
            return bsearchInternally(nums, 0, nums.length - 1, target);
        }

        private int bsearchInternally(int[] nums, int low, int high, int target) {
            if (low > high) {
                return low;
            }
            int mid = low + ((high - low) >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                return bsearchInternally(nums, mid + 1, high, target);
            } else {
                return bsearchInternally(nums, low, mid - 1, target);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}