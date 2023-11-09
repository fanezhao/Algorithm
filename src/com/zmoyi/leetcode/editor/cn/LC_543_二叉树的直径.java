//给你一棵二叉树的根节点，返回该树的 直径 。 
//
// 二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。这条路径可能经过也可能不经过根节点 root 。 
//
// 两节点之间路径的 长度 由它们之间边数表示。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,3,4,5]
//输出：3
//解释：3 ，取路径 [4,2,1,3] 或 [5,2,1,3] 的长度。
// 
//
// 示例 2： 
//
// 
//输入：root = [1,2]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [1, 10⁴] 内 
// -100 <= Node.val <= 100 
// 
//
// Related Topics 树 深度优先搜索 二叉树 👍 1434 👎 0


package com.zmoyi.leetcode.editor.cn;

import com.zmoyi.TreeNode;

public class LC_543_二叉树的直径 {
    public static void main(String[] args) {
        Solution solution = new LC_543_二叉树的直径().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    Integer maxDiameter = 0;

    /**
     * 思路：二叉树的最大直径其实就是等于左右子树的最大深度，所以我们可以在求最大深度的时候同时更新树的直径
     * 思维模式：问题分解
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return maxDiameter;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = maxDepth(root.left);    // 先计算左子树的最大深度
        int rightDepth = maxDepth(root.right);  // 再计算右子树的最大深度

        // 然后根据左右子树深度算出当前节点的最大直径
        int currDiameter = leftDepth + rightDepth;
        // 判断此时的直径是否是最大直径，并更新
        maxDiameter = Math.max(currDiameter, maxDiameter);

        return Math.max(leftDepth, rightDepth) + 1;
    }

    /**
     * 思维模式：遍历
     * @param root
     * @return
     */
    public int diameterOfBinaryTree2(TreeNode root) {
        traverse(root);
        return maxDiameter;
    }

    /**
     * 思维模式：遍历
     * @param root
     */
    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        // 进入节点的时候，先分别计算当前节点的左右子树最大深度，重而计算当前节点的最大直径，最后更新整个树的最大直径
        int leftDepth = maxDepth2(root.left);
        int rightDepth = maxDepth2(root.right);
        int currDiameter = leftDepth + rightDepth;
        maxDiameter = Math.max(currDiameter, maxDiameter);

        // 然后再遍历左右子树
        traverse(root.left);
        traverse(root.right);
    }

    private int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth2(root.left);
        int rightDepth = maxDepth2(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}