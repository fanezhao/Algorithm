//给定一个二叉树，判断它是否是高度平衡的二叉树。 
//
// 本题中，一棵高度平衡二叉树定义为： 
//
// 
// 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：root = [1,2,2,3,3,null,null,4,4]
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数在范围 [0, 5000] 内 
// -10⁴ <= Node.val <= 10⁴ 
// 
//
// Related Topics 树 深度优先搜索 二叉树 👍 1441 👎 0


package com.zmoyi.leetcode.editor.cn;

import com.zmoyi.TreeNode;

public class LC_110_平衡二叉树 {
    public static void main(String[] args) {
        Solution solution = new LC_110_平衡二叉树().new Solution();
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
        public boolean isBalanced(TreeNode root) {
            return getHeight(root) != -1;
        }

        /**
         * 后序求高，前序求深
         *
         * @param root
         * @return
         */
        private int getHeight(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int leftHeight = getHeight(root.left);  // 左
            if (leftHeight == -1) { // 如果左子树不是平衡二叉树就直接返回
                return -1;
            }
            int rightHeight = getHeight(root.right);    // 右
            if (rightHeight == -1) {    // 如果右子树不是平衡二叉树就直接返回
                return -1;
            }
            if (Math.abs(rightHeight - leftHeight) > 1) {   // 如果左子树和右子树的高度差大于1，则说明该节点不是平衡二叉树
                return -1;
            }
            return Math.max(leftHeight, rightHeight) + 1;   // 返回当前节点的高
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}