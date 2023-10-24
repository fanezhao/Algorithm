//给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。 
//
// 如果反转后整数超过 32 位的有符号整数的范围 [−2³¹, 231 − 1] ，就返回 0。 
//假设环境不允许存储 64 位整数（有符号或无符号）。
//
// 
//
// 示例 1： 
//
// 
//输入：x = 123
//输出：321
// 
//
// 示例 2： 
//
// 
//输入：x = -123
//输出：-321
// 
//
// 示例 3： 
//
// 
//输入：x = 120
//输出：21
// 
//
// 示例 4： 
//
// 
//输入：x = 0
//输出：0
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
// Related Topics 数学 👍 3918 👎 0


package com.zmoyi.leetcode.editor.cn;

public class LC_7_整数反转 {
    public static void main(String[] args) {
        Solution solution = new LC_7_整数反转().new Solution();
        System.out.println(solution.reverse(-123));
        System.out.println(solution.reverse(120));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int reverse(int x) {
            int reverseNum = 0;
            while (x != 0) {
                if (reverseNum > Integer.MAX_VALUE / 10 || reverseNum < Integer.MIN_VALUE / 10) {
                    return 0;
                }
                reverseNum = reverseNum * 10 + x % 10;  // 将老数的末尾推入新数的末尾
                x = x / 10;
            }
            return reverseNum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}