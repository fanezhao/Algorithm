//给定一个含有 n 个正整数的数组和一个正整数 target 。 
//
// 找出该数组中满足其总和大于等于 target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返
//回其长度。如果不存在符合条件的子数组，返回 0 。 
//
// 
//
// 示例 1： 
//
// 
//输入：target = 7, nums = [2,3,1,2,4,3]
//输出：2
//解释：子数组 [4,3] 是该条件下的长度最小的子数组。
// 
//
// 示例 2： 
//
// 
//输入：target = 4, nums = [1,4,4]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：target = 11, nums = [1,1,1,1,1,1,1,1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= target <= 10⁹ 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁵ 
// 
//
// 
//
// 进阶： 
//
// 
// 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。 
// 
//
// Related Topics 数组 二分查找 前缀和 滑动窗口 👍 1952 👎 0


package com.zmoyi.leetcode.editor.cn;

public class LC_209_长度最小的子数组 {
    public static void main(String[] args) {
        Solution solution = new LC_209_长度最小的子数组().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 滑动窗口
         *
         * @param target
         * @param nums
         * @return
         */
        public int minSubArrayLen(int target, int[] nums) {
            int slow = 0;
            int fast = 0;
            int sum = 0;
            int minSubLen = Integer.MAX_VALUE;
            while (fast < nums.length) {    // fast指针用于标定窗口终点
                sum += nums[fast++];
                while (sum >= target) {
                    minSubLen = Math.min(minSubLen, fast - slow);   // 窗口符合条件时，要更新最小窗口长度
                    sum -= nums[slow++];    // 移动窗口前移并重新计算窗口内大小的和
                }
            }
            return minSubLen == Integer.MAX_VALUE ? 0 : minSubLen;
        }

        /**
         * 双层循环暴力破解，提交会超时
         *
         * @param target
         * @param nums
         * @return
         */
        public int minSubArrayLen2(int target, int[] nums) {
            int subLen = Integer.MAX_VALUE;
            for (int slow = 0; slow < nums.length; slow++) {
                int sum = 0;
                for (int fast = slow; fast < nums.length; fast++) {
                    sum += nums[fast];
                    if (sum >= target) {
                        subLen = Math.min(subLen, fast - slow + 1);
                    }
                }
            }
            return subLen == Integer.MAX_VALUE ? 0 : subLen;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}