//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 请注意 ，必须在不复制数组的情况下原地对数组进行操作。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [0,1,0,3,12]
//输出: [1,3,12,0,0]
// 
//
// 示例 2: 
//
// 
//输入: nums = [0]
//输出: [0] 
//
// 
//
// 提示: 
// 
//
// 
// 1 <= nums.length <= 10⁴ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 
//
// 
//
// 进阶：你能尽量减少完成的操作次数吗？ 
//
// Related Topics 数组 双指针 👍 2212 👎 0


package com.zmoyi.leetcode.editor.cn;

import java.util.Arrays;

public class LC_283_移动零 {
    public static void main(String[] args) {
        Solution solution = new LC_283_移动零().new Solution();
        int[] nums = {0, 1, 0, 3, 12};
        solution.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));

        int[] nums2 = {0};
        solution.moveZeroes(nums2);
        System.out.println(Arrays.toString(nums2));

        int[] nums3 = {1, 0, 1};
        solution.moveZeroes(nums3);
        System.out.println(Arrays.toString(nums3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 双指针
         * @param nums
         */
        public void moveZeroes(int[] nums) {
            int i = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] != 0) {
                    i++;
                } else {
                    if (nums[j] != 0) {
                        nums[i] = nums[j];
                        nums[j] = 0;
                        i++;
                    }
                }
            }
        }

        /**
         * LC解法，更优雅
         * @param nums
         */
        public void moveZeroes2(int[] nums) {
            int i = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] != 0) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    i++;
                }
            }
        }

        /**
         * 双指针
         * @param nums
         */
        public void moveZeroes3(int[] nums) {
            int slow = 0;
            for (int fast = 0; fast < nums.length; fast++) {
                if (nums[fast] != 0) {
                    int temp = nums[fast];
                    nums[fast] = nums[slow];
                    nums[slow] = temp;
                    slow++;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}