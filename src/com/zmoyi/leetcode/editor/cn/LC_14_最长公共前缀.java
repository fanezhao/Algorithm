//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
//
// Related Topics 字典树 字符串 👍 2965 👎 0


package com.zmoyi.leetcode.editor.cn;

public class LC_14_最长公共前缀 {
    public static void main(String[] args) {
        Solution solution = new LC_14_最长公共前缀().new Solution();
        System.out.println(solution.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));

        System.out.println(solution.longestCommonPrefix(new String[]{"dog", "rececar", "car"}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 把数组的第一个元素当前默认前缀，然后拿这个前缀和剩下的元素逐个对比，取当前前缀和剩下元素的前缀，最后得到最终公共前缀
         * @param strs
         * @return
         */
        public String longestCommonPrefix(String[] strs) {
            String prefix = strs[0];
            for (int i = 1; i < strs.length; i++) {
                if (prefix.isEmpty()) {
                    break;
                }
                prefix = prefix(prefix, strs[i]);
            }
            return prefix;
        }

        private String prefix(String str1, String str2) {
            int n = Math.min(str1.length(), str2.length());
            for (int i = 0; i < n; i++) {
                if (str1.charAt(i) != str2.charAt(i)) {
                    return str1.substring(0, i);
                }
            }
            return str1.substring(0, n);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}