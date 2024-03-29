//给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。 
//
// 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。 
//
// 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。 
//
// 
//
// 说明: 
//
// 为什么返回数值是整数，但输出的答案是数组呢? 
//
// 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。 
//
// 你可以想象内部操作如下: 
//
// 
//// nums 是以“引用”方式传递的。也就是说，不对实参作任何拷贝
//int len = removeElement(nums, val);
//
//// 在函数里修改输入数组对于调用者是可见的。
//// 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
//for (int i = 0; i < len; i++) {
//    print(nums[i]);
//}
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,2,2,3], val = 3
//输出：2, nums = [2,2]
//解释：函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。你不需要考虑数组中超出新长度后面的元素。例如，函数返回的新长度为 2 ，而 
//nums = [2,2,3,3] 或 nums = [2,2,0,0]，也会被视作正确答案。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,2,2,3,0,4,2], val = 2
//输出：5, nums = [0,1,4,0,3]
//解释：函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。注意这五个元素可为任意顺序。你不需要考虑数组中超出新长度后面
//的元素。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 100 
// 0 <= nums[i] <= 50 
// 0 <= val <= 100 
// 
//
// Related Topics 数组 双指针 👍 2013 👎 0


package com.zmoyi.leetcode.editor.cn;

import java.util.Arrays;

public class LC_27_移除元素 {
    public static void main(String[] args) {
        Solution solution = new LC_27_移除元素().new Solution();
//        int[] nums = {3, 2, 2, 3};
//        System.out.println(solution.removeElement2(nums, 3));
//        System.out.println(Arrays.toString(nums));
//
//        int[] nums1 = {0, 1, 2, 2, 3, 0, 4, 2};
//        System.out.println(solution.removeElement2(nums1, 2));
//        System.out.println(Arrays.toString(nums1));

        int[] nums2 = {3, 2, 2, 3};
        System.out.println(solution.removeElement3(nums2, 3));
        System.out.println(Arrays.toString(nums2));

        int[] nums3 = {0, 1, 2, 2, 3, 0, 4, 2};
        System.out.println(solution.removeElement3(nums3, 2));
        System.out.println(Arrays.toString(nums3));

        int[] nums4 = {2};
        System.out.println(solution.removeElement3(nums4, 3));
        System.out.println(Arrays.toString(nums4));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 官方解法：快慢指针，这题和 @see LC_26_删除有序数组中的重复项 解题思路类似。
         * 区别就是 LC_26_删除有序数组中的重复项 中已快指针和快指针的前一个元素对比；本题是快指针和 val 对比
         *
         * @param nums
         * @param val
         * @return
         */
        public int removeElement2(int[] nums, int val) {
            int left = 0;
            for (int right = 0; right < nums.length; right++) {
                if (nums[right] != val) {
                    nums[left++] = nums[right];
                }
            }
            return left;
        }

        /**
         * 因为不用考虑超出数组中新长度后面的元素，所以可以将前面等于val的元素用后面不等于val的元素覆盖，所以可以使用双指针。
         * <p>
         * head指针：
         * 如果nums[head] == val；这个时候前进指针不动，再判断tail指针指向的元素是否等于val，
         * 如果等于，就把tail指针往前移动一个，因为tail指针是从后往前的，所以不用数组尾部等于val的元素；
         * 如果不等于，就把head和tail指针指向的元素交换位置，这个时间head指向的位置不等于val了，所以需要把head指针往前推进。
         * 如果nums[head] != val；直接把head指针往前推进。
         * 最后当head等于tail的时候，它俩同时指向第一个等于val的元素，值就是要返回的长度。
         *
         * @param nums
         * @param val
         * @return
         */
        public int removeElement(int[] nums, int val) {
            if (nums.length == 0) {
                return 0;
            }

            int head = 0;
            int tail = nums.length - 1;

            while (head <= tail) {
                if (nums[head] == val) {
                    if (nums[tail] == val) {
                        tail--;
                    } else {
                        int temp = nums[head];
                        nums[head] = nums[tail];
                        nums[tail] = temp;
                        head++;
                    }
                } else {
                    head++;
                }
            }
            return head;
        }

        /**
         * 快指针：用于寻找新数组中的元素，也就是不等于目标值的元素
         * 慢指针：用于表示新数组中要被更新的下标
         * @param nums
         * @param val
         * @return
         */
        public int removeElement3(int[] nums, int val) {
            int slow = 0;
            for (int fast = 0; fast < nums.length; fast++) {
                if (nums[fast] != val) {
                    nums[slow++] = nums[fast];
                }
            }
            return slow;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}