//给你一个 非严格递增排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 
//一致 。然后返回 nums 中唯一元素的个数。 
//
// 考虑 nums 的唯一元素的数量为 k ，你需要做以下事情确保你的题解可以被通过： 
//
// 
// 更改数组 nums ，使 nums 的前 k 个元素包含唯一元素，并按照它们最初在 nums 中出现的顺序排列。nums 的其余元素与 nums 的大小不
//重要。 
// 返回 k 。 
// 
//
// 判题标准: 
//
// 系统会用下面的代码来测试你的题解: 
//
// 
//int[] nums = [...]; // 输入数组
//int[] expectedNums = [...]; // 长度正确的期望答案
//
//int k = removeDuplicates(nums); // 调用
//
//assert k == expectedNums.length;
//for (int i = 0; i < k; i++) {
//    assert nums[i] == expectedNums[i];
//} 
//
// 如果所有断言都通过，那么您的题解将被 通过。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：2, nums = [1,2,_]
//解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,0,1,1,1,2,2,3,3,4]
//输出：5, nums = [0,1,2,3,4]
//解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。不需要考虑数组中超出新长度后面的元素。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// nums 已按 非严格递增 排列 
// 
//
// Related Topics 数组 双指针 👍 3354 👎 0


package com.zmoyi.leetcode.editor.cn;

import java.util.Arrays;

public class LC_26_删除有序数组中的重复项 {
    public static void main(String[] args) {
        Solution solution = new LC_26_删除有序数组中的重复项().new Solution();
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(solution.removeDuplicates1(nums));
        System.out.println(solution.removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));

        int[] nums1 = {1,1,2};
        System.out.println(solution.removeDuplicates1(nums1));
        System.out.println(solution.removeDuplicates(nums1));
        System.out.println(Arrays.toString(nums1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 快慢指针。当nums有0个或者只有1个元素时，结果都是确定的。
         * 快指针用于扫描数组，并且对比nums[fast]和nums[fast-1]是否相等，如果nums[fast]和nums[fast-1]不相等则说明nums[fast]和之前的元素都不相等。
         * 慢指针用于记录要被替换的下标，当此位置被替换后，需要+1。
         * @param nums
         * @return
         */
        public int removeDuplicates(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }

            int fast = 1, slow = 1;
            while (fast < nums.length) {
                if (nums[fast] != nums[fast - 1]) {
                    nums[slow++] = nums[fast];
                }
                fast++;
            }
            return slow;
        }

        /**
         * 暴力解法，用一个新数组来承接不重复的元素，时间复杂度和空间复杂度都是O(n)
         * @param nums
         * @return
         */
        public int removeDuplicates1(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }

            int[] newNums = new int[nums.length];
            newNums[0] = nums[0];
            int p = 1;
            int lastNum = newNums[0];
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] != lastNum) {
                    newNums[p++] = nums[i];
                    lastNum = nums[i];
                }
            }
            return p;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}