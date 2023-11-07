//给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。 
//
// 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-4,-1,0,3,10]
//输出：[0,1,9,16,100]
//解释：平方后，数组变为 [16,1,0,9,100]
//排序后，数组变为 [0,1,9,16,100] 
//
// 示例 2： 
//
// 
//输入：nums = [-7,-3,2,3,11]
//输出：[4,9,9,49,121]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// nums 已按 非递减顺序 排序 
// 
//
// 
//
// 进阶： 
//
// 
// 请你设计时间复杂度为 O(n) 的算法解决本问题 
// 
//
// Related Topics 数组 双指针 排序 👍 914 👎 0


package com.zmoyi.leetcode.editor.cn;

import java.util.Arrays;

public class LC_977_有序数组的平方 {
    public static void main(String[] args) {
        Solution solution = new LC_977_有序数组的平方().new Solution();

        int[] nums = {-7, -3, 2, 3, 11};
        System.out.println(Arrays.toString(solution.sortedSquares(nums)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sortedSquares(int[] nums) {
            int[] arr = new int[nums.length]; // 用一个新数组承接求平方后的值
            int k = arr.length - 1;
            int left = 0;
            int right = nums.length - 1;
            while (left <= right) { // 利用双指针从原数组前后开始计算，这里一定要是<= 不然有可能中间的那个值放不到新数组
                if (nums[left] * nums[left] < nums[right] * nums[right]) {  // 谁在就把平方值放到新数组的最后，同时把左右指针向前或向后移动一位
                    arr[k] = nums[right] * nums[right];
                    right--;
                } else {
                    arr[k] = nums[left] * nums[left];
                    left++;
                }
                k--;    // 再把新数组要赋值的指针向前移动一位
            }
            return arr;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}