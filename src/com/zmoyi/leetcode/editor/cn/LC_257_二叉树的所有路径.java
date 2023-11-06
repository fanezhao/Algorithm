//给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。 
//
// 叶子节点 是指没有子节点的节点。 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,3,null,5]
//输出：["1->2->5","1->3"]
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：["1"]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [1, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// Related Topics 树 深度优先搜索 字符串 回溯 二叉树 👍 1055 👎 0


package com.zmoyi.leetcode.editor.cn;

import com.zmoyi.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LC_257_二叉树的所有路径 {
    public static void main(String[] args) {
        Solution solution = new LC_257_二叉树的所有路径().new Solution();
        TreeNode root = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n5 = new TreeNode(5);
        root.left = n2;
        root.right = n3;
        n2.right = n5;
        solution.binaryTreePaths(root);

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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        List<Integer> path = new ArrayList<>();
        calcPath(root, path, ret);
        return ret;
    }

    /**
     * 递归，前序遍历
     * @param node
     * @param path
     * @param ret
     */
    private void calcPath(TreeNode node, List<Integer> path, List<String> ret) {
        path.add(node.val); // 中。中为什么要写在这里，因为最后一个节点也要加到路径中
        if (node.left == null && node.right == null) {  // 终止条件：到叶子节点之后把记录的路径转成字符串放到结果集中，然后返回
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < path.size() - 1; i++) {
                sb.append(path.get(i)).append("->");
            }
            sb.append(path.get(path.size() - 1));
            ret.add(sb.toString());
            return;
        }

        if (node.left != null) {    // 左
            calcPath(node.left, path, ret);
            path.remove(path.size() - 1);   // 回溯
        }

        if (node.right != null) {   // 右
            calcPath(node.right, path, ret);    // 回溯
            path.remove(path.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}