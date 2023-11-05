//给你一个二叉树的根节点 root ， 检查它是否轴对称。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,2,3,4,4,3]
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：root = [1,2,2,null,3,null,3]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [1, 1000] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：你可以运用递归和迭代两种方法解决这个问题吗？ 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 2583 👎 0


package com.zmoyi.leetcode.editor.cn;

import com.zmoyi.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class LC_101_对称二叉树 {
    public static void main(String[] args) {
        Solution solution = new LC_101_对称二叉树().new Solution();
        TreeNode root = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        root.left = n2;
        root.right = n3;

        System.out.println(solution.isSymmetric(root));

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
        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            }
            return symmetric(root.left, root.right);
        }

        /**
         * 思路：后续遍历 递归
         *
         * @param node1
         * @param node2
         * @return
         */
        private boolean symmetric(TreeNode node1, TreeNode node2) {
            if (node1 == null && node2 == null) {
                return true;
            }
            if (node1 == null && node2 != null || node1 != null && node2 == null) {
                return false;
            }
            if (node1.val != node2.val) {
                return false;
            }
            boolean outside = symmetric(node1.left, node2.right);   // 左
            boolean inside = symmetric(node1.right, node2.left);    // 右
            return outside && inside;   // 中
        }

        /**
         * 迭代：使用双端队列，相当于两个栈
         *
         * @param root
         * @return
         */
        public boolean isSymmetric2(TreeNode root) {
            Deque<TreeNode> deque = new LinkedList<>();
            deque.offerFirst(root.left);
            deque.offerLast(root.right);
            while (!deque.isEmpty()) {
                TreeNode left = deque.pollFirst();
                TreeNode right = deque.pollLast();
                if (left == null && right == null) {
                    continue;
                }
                if (left == null && right != null || left != null && right == null) {
                    return false;
                }
                if (left.val != right.val) {
                    return false;
                }
                deque.offerFirst(left.left);
                deque.offerLast(right.right);
                deque.offerFirst(left.right);
                deque.offerLast(right.left);
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}