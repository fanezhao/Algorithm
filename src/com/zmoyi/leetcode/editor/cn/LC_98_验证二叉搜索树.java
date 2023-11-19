//给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。 
//
// 有效 二叉搜索树定义如下： 
//
// 
// 节点的左子树只包含 小于 当前节点的数。 
// 节点的右子树只包含 大于 当前节点的数。 
// 所有左子树和右子树自身必须也是二叉搜索树。 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [2,1,3]
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：root = [5,1,4,null,null,3,6]
//输出：false
//解释：根节点的值是 5 ，但是右子节点的值是 4 。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目范围在[1, 10⁴] 内 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
//
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 2216 👎 0


package com.zmoyi.leetcode.editor.cn;

import com.zmoyi.TreeNode;

public class LC_98_验证二叉搜索树 {
    public static void main(String[] args) {
        Solution solution = new LC_98_验证二叉搜索树().new Solution();

        TreeNode root = new TreeNode(2);
        TreeNode n1 = new TreeNode(1);
        TreeNode n3 = new TreeNode(3);
        root.left = n1;
        root.right = n3;

        solution.isValidBST(root);
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

        // 记录遍历的上一个节点
        TreeNode pre = null;

        public boolean isValidBST(TreeNode root) {
            if (root == null) {
                return true;
            }

            boolean leftRet = isValidBST(root.left);

            if (pre != null && pre.val >= root.val) {
                return false;
            }
            pre = root;

            boolean rightRet = isValidBST(root.right);
            return leftRet && rightRet;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}