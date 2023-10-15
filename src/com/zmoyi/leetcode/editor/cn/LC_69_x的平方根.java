//给你一个非负整数 x ，计算并返回 x 的 算术平方根 。 
//
// 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。 
//
// 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 4
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：x = 8
//输出：2
//解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= x <= 2³¹ - 1 
// 
//
// Related Topics 数学 二分查找 👍 1452 👎 0


package com.zmoyi.leetcode.editor.cn;

public class LC_69_x的平方根 {
    public static void main(String[] args) {
        Solution solution = new LC_69_x的平方根().new Solution();
        System.out.println(solution.mySqrt(4));
        System.out.println(solution.mySqrt(8));
        System.out.println(solution.mySqrt(2147395599));


        System.out.println(solution.mySqrt2(4));
        System.out.println(solution.mySqrt2(8));
        System.out.println(solution.mySqrt2(2147395599));


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 二分查找法：k^2 <= x k就是我们要找的值
         *
         * @param x
         * @return
         */
        public int mySqrt(int x) {
            int low = 0;
            int high = x;
            int ans = -1;
            while (low <= high) {
                int mid = low + ((high - low) >> 1);
                if ((long) mid * mid <= x) {    // 转成long类型防止精度丢失
                    ans = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return ans;
        }

        public int mySqrt2(int x) {
            if (x == 0) {
                return 0;
            }
            int low = 1;
            int high = x / 2;
            while (low <= high) {
                int mid = low + ((high - low) >> 1);
                if (mid * mid == x || mid * mid < x && (mid + 1) * (mid + 1) > x) {
                    return mid;
                } else if (mid * mid > x) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            return low;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}