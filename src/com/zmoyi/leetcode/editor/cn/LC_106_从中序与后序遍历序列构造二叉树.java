//给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并
//返回这颗 二叉树 。 
//
// 
//
// 示例 1: 
// 
// 
//输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
//输出：[3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//输入：inorder = [-1], postorder = [-1]
//输出：[-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= inorder.length <= 3000 
// postorder.length == inorder.length 
// -3000 <= inorder[i], postorder[i] <= 3000 
// inorder 和 postorder 都由 不同 的值组成 
// postorder 中每一个值都在 inorder 中 
// inorder 保证是树的中序遍历 
// postorder 保证是树的后序遍历 
// 
//
// Related Topics 树 数组 哈希表 分治 二叉树 👍 1139 👎 0


package com.zmoyi.leetcode.editor.cn;

import com.zmoyi.TreeNode;

import java.util.Arrays;

public class LC_106_从中序与后序遍历序列构造二叉树 {
    public static void main(String[] args) {
        Solution solution = new LC_106_从中序与后序遍历序列构造二叉树().new Solution();
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        TreeNode root = solution.buildTree(inorder, postorder);
        System.out.println(root);
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder.length == 0) {
            return null;
        }

        // 后续遍历的最后一个节点一定是中间节点
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);

        // 然后在中序遍历中找到中间节点索引，然后进行切割
        int idx = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == root.val) {
                idx = i;
            }
        }

        // 根据中序遍历切出左中序和右中序（这里都是按前闭后开切割）
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, idx);
        int[] rightInOrder = Arrays.copyOfRange(inorder, idx + 1, inorder.length);

        // 根据后序遍历切出左后序和右后序（这里都是按前闭后开切割）
        int[] leftPostorder = Arrays.copyOfRange(postorder, 0, leftInorder.length);
        int[] rightPostorder = Arrays.copyOfRange(postorder, leftPostorder.length, postorder.length - 1);

        root.left = buildTree(leftInorder, leftPostorder);
        root.right = buildTree(rightInOrder, rightPostorder);

        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}