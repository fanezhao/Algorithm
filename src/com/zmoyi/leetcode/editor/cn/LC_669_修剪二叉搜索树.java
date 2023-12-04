//给你二叉搜索树的根节点 root ，同时给定最小边界low 和最大边界 high。通过修剪二叉搜索树，使得所有节点的值在[low, high]中。修剪树 不
//应该 改变保留在树中的元素的相对结构 (即，如果没有被移除，原有的父代子代关系都应当保留)。 可以证明，存在 唯一的答案 。 
//
// 所以结果应当返回修剪好的二叉搜索树的新的根节点。注意，根节点可能会根据给定的边界发生改变。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,0,2], low = 1, high = 2
//输出：[1,null,2]
// 
//
// 示例 2： 
// 
// 
//输入：root = [3,0,4,null,2,null,null,1], low = 1, high = 3
//输出：[3,2,null,1]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数在范围 [1, 10⁴] 内 
// 0 <= Node.val <= 10⁴ 
// 树中每个节点的值都是 唯一 的 
// 题目数据保证输入是一棵有效的二叉搜索树 
// 0 <= low <= high <= 10⁴ 
// 
//
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 892 👎 0


package com.zmoyi.leetcode.editor.cn;

import com.zmoyi.TreeNode;

public class LC_669_修剪二叉搜索树 {
    public static void main(String[] args) {
        Solution solution = new LC_669_修剪二叉搜索树().new Solution();
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

    /**
     * 代码随想录
     * @param root
     * @param low
     * @param high
     * @return
     */
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        // 当前节点值如果小于边界最小值，那这个时候只有当前节点的右子树中可能还有不符合条件的节点，所以要向右遍历，返回右子树的结果给上一层;
        // 此时当前节点的左子树一定都是不符合条件的，所以不用向左进行遍历了
        if (root.val < low) {
            return trimBST(root.right, low, high);
        }
        // 当前节点值如果大于边界最大值，那这个时候只有当前节点的左子树中可能还有不符合条件的节点，所以要向左遍历，返回左子树的结果给上一层;
        // 此时当前节点的右子树一定都是不符合条件的，所以不用向右进行遍历了
        if (root.val > high) {
            return trimBST(root.left, low, high);
        }
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }

    /**
     * 自己的实现，没做出来
     * @param root
     * @param low
     * @param high
     * @return
     */
    public TreeNode trimBST2(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        if (root.val < low || root.val > high) {
            if (root.left == null && root.right == null) {
                return null;
            }
            if (root.left == null && root.right != null) {
                return root.right;
            }
            if (root.left != null && root.right == null) {
                return root.left;
            }
            TreeNode curr = root.right;
            while (curr.left != null) {
                curr = curr.left;
            }
            curr.left = root.left;
            return root.right;
        }
        if (root.val < low) {
            root.right = trimBST2(root.right, low, high);
        } else if (root.val > high) {
            root.left = trimBST2(root.left, low, high);
        } else {
            root.left = trimBST2(root.left, low, high);
            root.right = trimBST2(root.right, low, high);
        }
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}