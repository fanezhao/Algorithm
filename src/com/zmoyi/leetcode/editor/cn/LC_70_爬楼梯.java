//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2
//输出：2
//解释：有两种方法可以爬到楼顶。
//1. 1 阶 + 1 阶
//2. 2 阶 
//
// 示例 2： 
//
// 
//输入：n = 3
//输出：3
//解释：有三种方法可以爬到楼顶。
//1. 1 阶 + 1 阶 + 1 阶
//2. 1 阶 + 2 阶
//3. 2 阶 + 1 阶
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 45 
// 
//
// Related Topics 记忆化搜索 数学 动态规划 👍 3303 👎 0


package com.zmoyi.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class LC_70_爬楼梯 {
    public static void main(String[] args) {
        Solution solution = new LC_70_爬楼梯().new Solution();
        System.out.println(solution.climbStairs(3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private Map<Integer, Integer> map = new HashMap<>();

        /**
         * 递归实现：比较low
         * @param n
         * @return
         */
        public int climbStairs(int n) {
            if (n == 1) {
                return 1;
            }
            if (n == 2) {
                return 2;
            }
            if (map.containsKey(n)) {
                return map.get(n);
            }
            int ret = climbStairs(n - 1) + climbStairs(n - 2);
            map.put(n, ret);
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}