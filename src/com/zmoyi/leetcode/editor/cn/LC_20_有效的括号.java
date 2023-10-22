//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 每个右括号都有一个对应的相同类型的左括号。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由括号 '()[]{}' 组成 
// 
//
// Related Topics 栈 字符串 👍 4213 👎 0


package com.zmoyi.leetcode.editor.cn;

import java.util.Stack;

public class LC_20_有效的括号 {
    public static void main(String[] args) {
        Solution solution = new LC_20_有效的括号().new Solution();
        System.out.println(solution.isValid("()"));
        System.out.println(solution.isValid("([)]"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            char[] array = s.toCharArray();
            for (int i = 0; i < array.length; i++) {
                if (!stack.isEmpty() && getChar(stack.peek()) == array[i]) {
                    stack.pop();
                } else {
                    stack.push(array[i]);
                }
            }
            return stack.size() == 0;
        }

        private char getChar(char c) {
            if (c == '(') {
                return ')';
            }
            if (c == '[') {
                return ']';
            }
            if (c == '{') {
                return '}';
            }
            return 'n';
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}