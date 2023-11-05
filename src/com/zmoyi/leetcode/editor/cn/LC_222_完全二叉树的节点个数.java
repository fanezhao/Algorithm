//给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。 
//
// 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层
//为第 h 层，则该层包含 1~ 2ʰ 个节点。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,3,4,5,6]
//输出：6
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目范围是[0, 5 * 10⁴] 
// 0 <= Node.val <= 5 * 10⁴ 
// 题目数据保证输入的树是 完全二叉树 
// 
//
// 
//
// 进阶：遍历树来统计节点是一种时间复杂度为 O(n) 的简单解决方案。你可以设计一个更快的算法吗？ 
//
// Related Topics 位运算 树 二分查找 二叉树 👍 1050 👎 0


package com.zmoyi.leetcode.editor.cn;

import com.zmoyi.TreeNode;

import java.util.Stack;

public class LC_222_完全二叉树的节点个数 {
    public static void main(String[] args) {
        Solution solution = new LC_222_完全二叉树的节点个数().new Solution();
        TreeNode root = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        root.left = n2;
        root.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;

        solution.countNodes(root);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {

        /**
         * 非完全二叉树做法，只需要遍历一遍统计一下节点数量即可，前序遍历，迭代法
         * 但是这种不是最优做法，需要把树中的每个节点都是需要遍历一遍
         *
         * @param root
         * @return
         */
        public int countNodes2(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int count = 0;
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                count++;
                if (node.right != null) {
                    stack.push(node.right);
                }
                if (node.left != null) {
                    stack.push(node.left);
                }
            }
            return count;
        }

        /**
         * 非完全二叉树做法，只需要遍历一遍统计一下节点数量即可，前序遍历，递归法
         * 但是这种不是最优做法，需要把树中的每个节点都是需要遍历一遍
         *
         * @param root
         * @return
         */
        public int countNodes3(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return countNodes3(root.left) + countNodes3(root.right) + 1;
        }

        /**
         * 针对完全二叉树的解法。满二叉树的结点数为：2^depth - 1
         *
         * @param root
         */
        public int countNodes(TreeNode root) {
            if (root == null) {
                return 0;
            }
            TreeNode left = root.left;
            TreeNode right = root.right;
            int leftDepth = 0;
            int rightDepth = 0;
            while (left != null) {  // 计算左子树深度
                left = left.left;
                leftDepth++;
            }
            while (right != null) { // 计算右子树深度
                right = right.right;
                rightDepth++;
            }
            if (leftDepth == rightDepth) {  // 如果左子树深度等于右子树深度说明是一颗满二叉树
                return (2 << leftDepth) - 1;    // 2 << n 等于 2^n
            }
            int leftCount = countNodes(root.left);  // 左
            int rightCount = countNodes(root.right);    // 右
            return leftCount + rightCount + 1;  // 中
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}