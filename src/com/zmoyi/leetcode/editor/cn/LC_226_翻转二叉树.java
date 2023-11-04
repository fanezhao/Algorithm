//给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [4,2,7,1,3,6,9]
//输出：[4,7,2,9,6,3,1]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [2,1,3]
//输出：[2,3,1]
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目范围在 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1721 👎 0


package com.zmoyi.leetcode.editor.cn;

import com.zmoyi.TreeNode;
import com.zmoyi.dataStructure.tree.TraversalUtils;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LC_226_翻转二叉树 {
    public static void main(String[] args) {
        Solution solution = new LC_226_翻转二叉树().new Solution();

        TreeNode root = new TreeNode(4);
        TreeNode n2 = new TreeNode(2);
        TreeNode n7 = new TreeNode(7);
        TreeNode n1 = new TreeNode(1);
        TreeNode n3 = new TreeNode(3);
        TreeNode n6 = new TreeNode(6);
        TreeNode n9 = new TreeNode(9);
        root.left = n2;
        root.right = n7;
        n2.left = n1;
        n2.right = n3;
        n7.left = n6;
        n7.right = n9;

        solution.invertTree3(root);
        TraversalUtils.levelOrder(root);

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
         * DFS 递归 前序
         *
         * @param root
         * @return
         */
        public TreeNode invertTree2(TreeNode root) {
            if (root == null) {
                return null;
            }
            swap(root);
            invertTree(root.left);
            invertTree(root.right);
            return root;
        }

        /**
         * DFS 迭代 前序
         *
         * @param root
         * @return
         */
        public TreeNode invertTree3(TreeNode root) {
            if (root == null) {
                return null;
            }

            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                swap(node);
                if (node.right != null) {
                    stack.push(node.right);
                }
                if (node.left != null) {
                    stack.push(node.left);
                }
            }
            return root;
        }

        /**
         * BSF
         *
         * @param root
         */
        public TreeNode invertTree(TreeNode root) {
            if (root == null) {
                return root;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                while (size-- > 0) {
                    TreeNode node = queue.poll();
                    swap(node);
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
            }
            return root;
        }

        private void swap(TreeNode node) {
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}