//给你一个整数数组 nums ，返回数组中最大数和最小数的 最大公约数 。 
//
// 两个数的 最大公约数 是能够被两个数整除的最大正整数。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [2,5,6,9,10]
//输出：2
//解释：
//nums 中最小的数是 2
//nums 中最大的数是 10
//2 和 10 的最大公约数是 2
// 
//
// 示例 2： 
//
// 输入：nums = [7,5,6,8,3]
//输出：1
//解释：
//nums 中最小的数是 3
//nums 中最大的数是 8
//3 和 8 的最大公约数是 1
// 
//
// 示例 3： 
//
// 输入：nums = [3,3]
//输出：3
//解释：
//nums 中最小的数是 3
//nums 中最大的数是 3
//3 和 3 的最大公约数是 3
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 1000 
// 1 <= nums[i] <= 1000 
// 
//
// Related Topics 数组 数学 数论 👍 44 👎 0


package com.zmoyi.leetcode.editor.cn;

public class LC_1979_找出数组的最大公约数 {
    public static void main(String[] args) {
        Solution solution = new LC_1979_找出数组的最大公约数().new Solution();
        System.out.println(solution.findGCD(new int[]{2, 5, 6, 9, 10}));
        System.out.println(solution.findGCD(new int[]{7, 5, 6, 8, 3}));
        System.out.println(solution.findGCD(new int[]{3, 3}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 更相减损术
         * @param nums
         * @return
         */
        public int findGCD(int[] nums) {
            int min = nums[0];
            int max = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] > max) {
                    max = nums[i];
                }
                if (nums[i] < min) {
                    min = nums[i];
                }
            }
            return gcd(max, min);
        }

        public int gcd(int max, int min) {
            if (max % min == 0) {
                return min;
            }
            return gcd(min, max % min);
        }

        /**
         * 暴力解法
         * @param nums
         * @return
         */
        public int findGCD2(int[] nums) {
            int min = nums[0];
            int max = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] > max) {
                    max = nums[i];
                }
                if (nums[i] < min) {
                    min = nums[i];
                }
            }

            int gcd = min;
            while (gcd > 1) {
                if (min % gcd == 0 && max % gcd == 0) {
                    return gcd;
                }
                gcd--;
            }
            return gcd;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}