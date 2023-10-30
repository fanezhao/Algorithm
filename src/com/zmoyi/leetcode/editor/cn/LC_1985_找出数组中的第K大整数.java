//给你一个字符串数组 nums 和一个整数 k 。nums 中的每个字符串都表示一个不含前导零的整数。 
//
// 返回 nums 中表示第 k 大整数的字符串。 
//
// 注意：重复的数字在统计时会视为不同元素考虑。例如，如果 nums 是 ["1","2","2"]，那么 "2" 是最大的整数，"2" 是第二大的整数，"1
//" 是第三大的整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = ["3","6","7","10"], k = 4
//输出："3"
//解释：
//nums 中的数字按非递减顺序排列为 ["3","6","7","10"]
//其中第 4 大整数是 "3"
// 
//
// 示例 2： 
//
// 
//输入：nums = ["2","21","12","1"], k = 3
//输出："2"
//解释：
//nums 中的数字按非递减顺序排列为 ["1","2","12","21"]
//其中第 3 大整数是 "2"
// 
//
// 示例 3： 
//
// 
//输入：nums = ["0","0"], k = 2
//输出："0"
//解释：
//nums 中的数字按非递减顺序排列为 ["0","0"]
//其中第 2 大整数是 "0"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 10⁴ 
// 1 <= nums[i].length <= 100 
// nums[i] 仅由数字组成 
// nums[i] 不含任何前导零 
// 
//
// Related Topics 数组 字符串 分治 快速选择 排序 堆（优先队列） 👍 49 👎 0


package com.zmoyi.leetcode.editor.cn;

import java.util.Arrays;

public class LC_1985_找出数组中的第K大整数 {
    public static void main(String[] args) {
        Solution solution = new LC_1985_找出数组中的第K大整数().new Solution();

        String[] nums = {"3", "6", "7", "10"};
        System.out.println(solution.kthLargestNumber2(nums, 4));


        System.out.println("66".compareTo("67"));
        System.out.println("67".compareTo("66"));
        System.out.println("66".compareTo("66"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public String kthLargestNumber(String[] nums, int k) {
            Arrays.sort(nums, ((o1, o2) -> {
                if (o1.length() == o2.length()) {
                    return o2.compareTo(o1);
                }
                return o2.length() - o1.length();
            }));
            return nums[k - 1];
        }

        /**
         * 个人思路：每次找出数组中最大的元素放到数组开头，连续执行K次，然后数组中k-1下标对应的元素就是第三大。
         * 但是这种思路提交超时～
         * @param nums
         * @param k
         * @return
         */
        public String kthLargestNumber2(String[] nums, int k) {
            int t = 0;
            while (t < k) {
                int max = t;
                for (int i = t; i < nums.length; i++) {
                    if (nums[max].length() == nums[i].length()) {
                        if (nums[i].compareTo(nums[max]) > 0) {
                            max = i;
                        }
                    } else {
                        if (nums[i].length() > nums[max].length()) {
                            max = i;
                        }
                    }
                }
                String temp = nums[t];
                nums[t] = nums[max];
                nums[max] = temp;
                t++;
            }
            return nums[t - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}