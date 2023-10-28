//给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。 
//
// 如果存在一个整数 x 使得 n == 2ˣ ，则认为 n 是 2 的幂次方。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 1
//输出：true
//解释：2⁰ = 1
// 
//
// 示例 2： 
//
// 
//输入：n = 16
//输出：true
//解释：2⁴ = 16
// 
//
// 示例 3： 
//
// 
//输入：n = 3
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：n = 4
//输出：true
// 
//
// 示例 5： 
//
// 
//输入：n = 5
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// -2³¹ <= n <= 2³¹ - 1 
// 
//
// 
//
// 进阶：你能够不使用循环/递归解决此问题吗？ 
//
// Related Topics 位运算 递归 数学 👍 639 👎 0


package com.zmoyi.leetcode.editor.cn;

public class LC_231_2的幂 {
    public static void main(String[] args) {
        Solution solution = new LC_231_2的幂().new Solution();
        System.out.println(solution.isPowerOfTwo(16));
        System.out.println(solution.isPowerOfTwo(3));
        System.out.println(solution.isPowerOfTwo(1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 递归解法：提交的时候不通过，
         *
         * @param n
         * @return
         */
        public boolean isPowerOfTwo(int n) {
            if (n < 0) {
                return false;
            }
            if (n == 1) {
                return true;
            }
            if (n % 2 != 0) {
                return false;
            }
            if (n / 2 == 1) {
                return true;
            }
            return isPowerOfTwo(n / 2);
        }

        /**
         * 按位与(牛逼)
         * 1000 & 0111 == 0
         * @param n
         * @return
         */
        public boolean isPowerOfTwo2(int n) {
            return n > 0 && (n & (n - 1)) == 0;
        }
//leetcode submit region end(Prohibit modification and deletion)

    }
}