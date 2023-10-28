//给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
//如果 needle 不是 haystack 的一部分，则返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：haystack = "sadbutsad", needle = "sad"
//输出：0
//解释："sad" 在下标 0 和 6 处匹配。
//第一个匹配项的下标是 0 ，所以返回 0 。
// 
//
// 示例 2： 
//
// 
//输入：haystack = "leetcode", needle = "leeto"
//输出：-1
//解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= haystack.length, needle.length <= 10⁴ 
// haystack 和 needle 仅由小写英文字符组成 
// 
//
// Related Topics 双指针 字符串 字符串匹配 👍 2059 👎 0


package com.zmoyi.leetcode.editor.cn;

public class LC_28_找出字符串中第一个匹配项的下标 {
    public static void main(String[] args) {
        Solution solution = new LC_28_找出字符串中第一个匹配项的下标().new Solution();
        System.out.println(solution.strStr("sadbutsad", "sad"));
        System.out.println(solution.strStr("leetcode", "leeto"));
        System.out.println(solution.strStr("aaa", "aaaa"));

        System.out.println(solution.strStr2("sadbutsad", "sad"));
        System.out.println(solution.strStr2("leetcode", "leeto"));
        System.out.println(solution.strStr2("aaa", "aaaa"));


        int length = "sadbutsad".length();
        System.out.println(length);
        System.out.println("sadbutsad".substring(1, length));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 取巧办法
         * @param haystack
         * @param needle
         * @return
         */
        public int strStr(String haystack, String needle) {
            for (int i = 0; i < haystack.length(); i++) {
                if (haystack.charAt(i) == needle.charAt(0)) {
                    if (haystack.length() - i < needle.length()) {
                        return -1;
                    }
                    if (needle.equals(haystack.substring(i, i + needle.length()))) {
                        return i;
                    }
                }
            }
            return -1;
        }

        /**
         * 纯字符串匹配
         * @param haystack
         * @param needle
         * @return
         */
        public int strStr2(String haystack, String needle) {
            for (int i = 0; i < haystack.length(); i++) {
                if (haystack.charAt(i) != needle.charAt(0)) {
                    continue;
                }
                int t = i;
                int j = 0;
                while (t < haystack.length() && j < needle.length()) {
                    if (haystack.charAt(t) != needle.charAt(j)) {
                        break;
                    }
                    t++;
                    j++;
                }
                if (j == needle.length()) {
                    return i;
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}