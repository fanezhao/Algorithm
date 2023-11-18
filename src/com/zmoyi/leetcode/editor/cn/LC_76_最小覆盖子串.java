//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。 
//
// 
//
// 注意： 
//
// 
// 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。 
// 如果 s 中存在这样的子串，我们保证它是唯一的答案。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
//解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
//解释：整个字符串 s 是最小覆盖子串。
// 
//
// 示例 3: 
//
// 
//输入: s = "a", t = "aa"
//输出: ""
//解释: t 中两个字符 'a' 均应包含在 s 的子串中，
//因此没有符合条件的子字符串，返回空字符串。 
//
// 
//
// 提示： 
//
// 
// m == s.length 
// n == t.length 
// 1 <= m, n <= 10⁵ 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 
//o(m+n) 时间内解决此问题的算法吗？
//
// Related Topics 哈希表 字符串 滑动窗口 👍 2748 👎 0


package com.zmoyi.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class LC_76_最小覆盖子串 {
    public static void main(String[] args) {
        Solution solution = new LC_76_最小覆盖子串().new Solution();
        String s = "ADOBECODEBANC";
        String t = "ABC";

        String ret = solution.minWindow(s, t);
        System.out.println(ret);

        System.out.println(solution.minWindow("aa", "aa"));

        System.out.println(solution.minWindow("cabwefgewcwaefgcf", "cae"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minWindow(String s, String t) {
        // 用于记录目标字符串中每个字符需要多少个
        Map<Character, Integer> needMap = new HashMap<>();
        // 记录当前窗口中每个字符当前的个数
        Map<Character, Integer> windowsMap = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            needMap.put(c, needMap.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int right = 0;
        int valid = 0;  // 符合条件的字母个数
        int start = 0;
        int len = Integer.MAX_VALUE;
        while (right < s.length()) {
            char rightChar = s.charAt(right);
            right++;

            if (needMap.containsKey(rightChar)) {   // 更新窗口信息
                windowsMap.put(rightChar, windowsMap.getOrDefault(rightChar, 0) + 1);
                Integer rightCharCount = windowsMap.get(rightChar);
                if (rightCharCount.equals(needMap.get(rightChar))) {
                    valid++;
                }
            }

            while (valid == needMap.size()) {   // 满足条件，压缩左指针，直到不满足条件
                if (right - left < len) {   // 条件满足时，更新一下最小长度
                    len = right - left;
                    start = left;
                }
                char leftChar = s.charAt(left);
                left++;

                if (needMap.containsKey(leftChar)) {    // 更新窗口信息
                    Integer leftCharCount = windowsMap.get(leftChar);
                    if (leftCharCount.equals(needMap.get(leftChar))) {
                        valid--;
                    }
                    if (leftCharCount == 1) {
                        windowsMap.remove(leftChar);
                    } else {
                        windowsMap.put(leftChar, leftCharCount - 1);
                    }
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}