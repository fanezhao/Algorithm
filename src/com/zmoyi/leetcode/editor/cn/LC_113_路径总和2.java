//给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。 
//
// 叶子节点 是指没有子节点的节点。 
//
// 
// 
// 
// 
// 
//
// 示例 1： 
// 
// 
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//输出：[[5,4,11,2],[5,8,4,5]]
// 
//
// 示例 2： 
// 
// 
//输入：root = [1,2,3], targetSum = 5
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1,2], targetSum = 0
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点总数在范围 [0, 5000] 内 
// -1000 <= Node.val <= 1000 
// -1000 <= targetSum <= 1000 
// 
//
// Related Topics 树 深度优先搜索 回溯 二叉树 👍 1056 👎 0


package com.zmoyi.leetcode.editor.cn;

import com.zmoyi.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LC_113_路径总和2 {
    public static void main(String[] args) {
        Solution solution = new LC_113_路径总和2().new Solution();
        TreeNode root = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        root.left = n2;
        root.right = n3;

        List<List<Integer>> ret = solution.pathSum(root, 5);
        System.out.println(ret);

        TreeNode root1 = new TreeNode(5);
        TreeNode n4 = new TreeNode(4);
        TreeNode n8 = new TreeNode(8);
        TreeNode n11 = new TreeNode(11);
        TreeNode n13 = new TreeNode(13);
        TreeNode n41 = new TreeNode(4);
        TreeNode n7 = new TreeNode(7);
        TreeNode n21 = new TreeNode(2);
        TreeNode n5 = new TreeNode(5);
        TreeNode n1 = new TreeNode(1);
        root1.left = n4;
        root1.right = n8;

        n4.left = n11;
        n11.left = n7;
        n11.right = n21;

        n8.left = n13;
        n8.right = n41;
        n41.left = n5;
        n41.right = n1;

        System.out.println(solution.pathSum(root1, 22));

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

    List<List<Integer>> ret;
    List<Integer> paths;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ret = new ArrayList<>();
        paths = new ArrayList<>();
        traverse(root, paths, targetSum);
        return ret;
    }

    /**
     * 遍历思路：
     * @param root
     * @param paths
     * @param targetSum
     */
    private void traverse(TreeNode root, List<Integer> paths, Integer targetSum) {
        if (root == null) {
            return;
        }
        paths.add(root.val);
        if (root.left == null && root.right == null) {
            if (targetSum - root.val == 0) {
                ret.add(new ArrayList<>(paths));
            }
        }
        traverse(root.left, paths, targetSum - root.val);
        traverse(root.right, paths, targetSum - root.val);
        paths.remove(paths.size() - 1); // 回溯
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}