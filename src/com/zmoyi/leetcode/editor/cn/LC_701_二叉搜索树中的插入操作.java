//给定二叉搜索树（BST）的根节点
// root 和要插入树中的值
// value ，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。 输入数据 保证 ，新值和原始二叉搜索树中的任意节点值都不同。 
//
// 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回 任意有效的结果 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [4,2,7,1,3], val = 5
//输出：[4,2,7,1,3,5]
//解释：另一个满足题目要求可以通过的树是：
//
// 
//
// 示例 2： 
//
// 
//输入：root = [40,20,60,10,30,50,70], val = 25
//输出：[40,20,60,10,30,50,70,null,null,25]
// 
//
// 示例 3： 
//
// 
//输入：root = [4,2,7,1,3,null,null,null,null,null,null], val = 5
//输出：[4,2,7,1,3,5]
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数将在
// [0, 10⁴]的范围内。
// 
// -10⁸ <= Node.val <= 10⁸ 
// 所有值 
// Node.val 是 独一无二 的。 
// -10⁸ <= val <= 10⁸ 
// 保证 val 在原始BST中不存在。 
// 
//
// Related Topics 树 二叉搜索树 二叉树 👍 540 👎 0


package com.zmoyi.leetcode.editor.cn;

import com.zmoyi.TreeNode;

public class LC_701_二叉搜索树中的插入操作 {
    public static void main(String[] args) {
        Solution solution = new LC_701_二叉搜索树中的插入操作().new Solution();
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
     * 代码随想录：分解思路。
     * @param root
     * @param val
     * @return
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST2(root.right, val);
        }
        return root;
    }

    public TreeNode insertIntoBST2(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        traversal(root, null, val);
        return root;
    }

    /**
     * 个人思路：遍历思维模式。遍历整个二叉树，当遍历要点为空时需要生成一个新的节点，并且将这个新生成的节点赋值给他的上一层节点，
     * 通过和上一层节点值的对比来判断是赋值左节点还是右节点
     * @param root
     * @param pre
     * @param val
     */
    private void traversal(TreeNode root, TreeNode pre, int val) {
        if (root == null) {
            root = new TreeNode(val);
            if (pre != null) {
                if (pre.val > val) {
                    pre.left = root;
                } else {
                    pre.right = root;
                }
            }
            return;
        }
        if (root.val > val) {
            traversal(root.left, root, val);
        } else {
            traversal(root.right, root, val);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}