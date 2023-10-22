//给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。 
//
// 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。 
//
// 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并
//的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
//输出：[1,2,2,3,5,6]
//解释：需要合并 [1,2,3] 和 [2,5,6] 。
//合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1], m = 1, nums2 = [], n = 0
//输出：[1]
//解释：需要合并 [1] 和 [] 。
//合并结果是 [1] 。
// 
//
// 示例 3： 
//
// 
//输入：nums1 = [0], m = 0, nums2 = [1], n = 1
//输出：[1]
//解释：需要合并的数组是 [] 和 [1] 。
//合并结果是 [1] 。
//注意，因为 m = 0 ，所以 nums1 中没有元素。nums1 中仅存的 0 仅仅是为了确保合并结果可以顺利存放到 nums1 中。
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m + n 
// nums2.length == n 
// 0 <= m, n <= 200 
// 1 <= m + n <= 200 
// -10⁹ <= nums1[i], nums2[j] <= 10⁹ 
// 
//
// 
//
// 进阶：你可以设计实现一个时间复杂度为 O(m + n) 的算法解决此问题吗？ 
//
// Related Topics 数组 双指针 排序 👍 2181 👎 0


package com.zmoyi.leetcode.editor.cn;

import java.util.Arrays;

public class LC_88_合并两个有序数组 {
    public static void main(String[] args) {
        Solution solution = new LC_88_合并两个有序数组().new Solution();
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        solution.merge(nums1, 3, nums2, 3);
        solution.merge(new int[]{2, 0}, 1, new int[]{1}, 1);
        solution.merge(new int[]{0}, 0, new int[]{1}, 1);
        System.out.println(Arrays.toString(nums1));
        System.out.println("----");
        System.out.println(Arrays.toString(nums2));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 个人思路：用双指针。如果nums1的指针在m之前如果大于nums2的元素，刚替换两个位置的值；
         * 在超出m之后把nums2全部合到nums1里面即可，因为这个时候nums2里面都是最大的。（有问题）
         * @param nums1
         * @param m
         * @param nums2
         * @param n
         */
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int p1 = m - 1;
            int p2 = n - 1;
            int curr = m + n - 1;
            while (curr >= 0) {
                if (p1 < 0) {
                    nums1[curr--] = nums2[p2--];
                    continue;
                }
                if (p2 < 0) {
                    nums1[curr--] = nums1[p1--];
                    continue;
                }
                if (nums1[p1] > nums2[p2]) {
                    nums1[curr--] = nums1[p1--];
                } else {
                    nums1[curr--] = nums2[p2--];
                }
            }
        }

        /**
         * 做法1：把nums2合并到nums1的后半部分，然后排序即可
         * @param nums1
         * @param m
         * @param nums2
         * @param n
         */
        public void merge1(int[] nums1, int m, int[] nums2, int n) {
            for (int i = 0; i < n; i++) {
                nums1[m + i] = nums2[i];
            }
            Arrays.sort(nums1);
        }

        /**
         * 双指针：准备一个新数据，依次把nums1和nums2的元素按从小到大放进去
         * @param nums1
         * @param m
         * @param nums2
         * @param n
         */
        public void merge2(int[] nums1, int m, int[] nums2, int n) {
            int[] sorted = new int[m + n];
            if (n == 0) {
                return;
            }
            int p = 0, p1 = 0, p2 = 0;
            while (p < m + n) {
                if (p1 >= m) {  // 防止数组越界
                    sorted[p++] = nums2[p2++];
                    continue;
                }
                if (p2 >= n) {  // 防止数组越界
                    sorted[p++] = nums1[p1++];
                    continue;
                }
                if (nums1[p1] <= nums2[p2]) {
                    sorted[p++] = nums1[p1++];
                } else {
                    sorted[p++] = nums2[p2++];
                }
            }
            for (int i = 0; i < m + n; i++) {
                nums1[i] = sorted[i];
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}