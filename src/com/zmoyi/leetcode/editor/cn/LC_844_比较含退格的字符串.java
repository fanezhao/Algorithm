//给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，如果两者相等，返回 true 。# 代表退格字符。 
//
// 注意：如果对空文本输入退格字符，文本继续为空。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ab#c", t = "ad#c"
//输出：true
//解释：s 和 t 都会变成 "ac"。
// 
//
// 示例 2： 
//
// 
//输入：s = "ab##", t = "c#d#"
//输出：true
//解释：s 和 t 都会变成 ""。
// 
//
// 示例 3： 
//
// 
//输入：s = "a#c", t = "b"
//输出：false
//解释：s 会变成 "c"，但 t 仍然是 "b"。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 200 
// s 和 t 只含有小写字母以及字符 '#' 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以用 O(n) 的时间复杂度和 O(1) 的空间复杂度解决该问题吗？ 
// 
//
// Related Topics 栈 双指针 字符串 模拟 👍 688 👎 0


package com.zmoyi.leetcode.editor.cn;

public class LC_844_比较含退格的字符串 {
    public static void main(String[] args) {
        Solution solution = new LC_844_比较含退格的字符串().new Solution();

        System.out.println("ab#c".charAt(0));
        System.out.println("ab#c".substring(0, 4));
        System.out.println("ab#c".substring(1));

        System.out.println(solution.clear2("ab#c"));
        System.out.println(solution.clear("ab##"));
        System.out.println(solution.clear("a##c"));
        System.out.println(solution.clear("#a#c"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean backspaceCompare(String s, String t) {
            return clear(s).equals(clear(t));
        }

        /**
         * 个人思路：采用双指针 + 双层循环
         * 快指针用于遍历字符串的每个元素；慢指针用于标识字符串退格后有效的位置。每次退格后需要重建字符串
         * 内层循环用于遍历字符串的每个元素；外层循环用于字符串重建后重新发起循环
         * @param s
         * @return
         */
        private String clear(String s) {
            boolean rebuild;
            do {
                rebuild = false;
                int slow = 0;
                int fast = 0;
                while (fast < s.length()) {
                    if ('#' == s.charAt(fast++)) {  // fast 指针每次都要往前跑
                        if (slow > 0) {
                            slow--;
                        }
                        s = s.substring(0, slow) + s.substring(fast);
                        rebuild = true;
                        break;
                    } else {
                        slow++;
                    }
                }
            } while (rebuild);
            return s;
        }

        private String clear2(String s) {
            char[] arr = s.toCharArray();
            int slow = 0;
            int fast = 0;
            while (fast < arr.length) {
                if ('#' == arr[fast]) {
                    if (slow > 0) {
                        slow--;
                    }
                    fast++;
                } else {
                    arr[slow++] = arr[fast++];
                }
            }
            return new String(arr).substring(0, slow);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}