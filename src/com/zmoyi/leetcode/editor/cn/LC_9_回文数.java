//给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。 
//
// 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。 
//
// 
// 例如，121 是回文，而 123 不是。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 121
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：x = -121
//输出：false
//解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
// 
//
// 示例 3： 
//
// 
//输入：x = 10
//输出：false
//解释：从右向左读, 为 01 。因此它不是一个回文数。
// 
//
// 
//
// 提示： 
//
// 
// -2³¹ <= x <= 2³¹ - 1 
// 
//
// 
//
// 进阶：你能不将整数转为字符串来解决这个问题吗？ 
//
// Related Topics 数学 👍 2710 👎 0


package com.zmoyi.leetcode.editor.cn;

public class LC_9_回文数 {
    public static void main(String[] args) {
        Solution solution = new LC_9_回文数().new Solution();
        System.out.println(solution.isPalindrome(12321));
        System.out.println(solution.isPalindrome2(12321));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        /**
         * 个人思路：如果当前值小于0，那一定不是回文数；如果大于0，将其转成字符串，然后从头和尾对比，只要不等于就不是。
         * @param x
         * @return
         */
        public boolean isPalindrome(int x) {
            if (x < 0) {
                return false;
            }
            String s = String.valueOf(x);
            int head = 0;
            int tail = s.length() - 1;
            while (head < tail) {
                if (s.charAt(head++) != s.charAt(tail--)) {
                    return false;
                }
            }
            return true;
        }

        public boolean isPalindrome2(int x) {
            if (x < 0) {
                return false;
            }
            int reverse = 0;
            while (x > reverse) {
                reverse = reverse * 10 + x % 10;
                x = x / 10;
            }
            return x == reverse || x == reverse / 10;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}