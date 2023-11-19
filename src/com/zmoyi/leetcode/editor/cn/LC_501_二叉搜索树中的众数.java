//给你一个含重复值的二叉搜索树（BST）的根节点 root ，找出并返回 BST 中的所有 众数（即，出现频率最高的元素）。 
//
// 如果树中有不止一个众数，可以按 任意顺序 返回。 
//
// 假定 BST 满足如下定义： 
//
// 
// 结点左子树中所含节点的值 小于等于 当前节点的值 
// 结点右子树中所含节点的值 大于等于 当前节点的值 
// 左子树和右子树都是二叉搜索树 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,null,2,2]
//输出：[2]
// 
//
// 示例 2： 
//
// 
//输入：root = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [1, 10⁴] 内 
// -10⁵ <= Node.val <= 10⁵ 
// 
//
// 
//
// 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内） 
//
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 715 👎 0


package com.zmoyi.leetcode.editor.cn;

import com.zmoyi.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LC_501_二叉搜索树中的众数 {
    public static void main(String[] args) {
        Solution solution = new LC_501_二叉搜索树中的众数().new Solution();
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
    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }
        traverse(root);
        int[] ret = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }

    TreeNode pre;
    int count;
    int maxCount;
    List<Integer> list = new ArrayList<>();
    public void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        traverse(root.left);

        // 如果上一个节点为空或上一个节点的值不等于当前节点的值，那对于当前节点的值的计数就为1，否则就累加
        if (pre == null || pre.val != root.val) {
            count = 1;
        } else {
            count++;
        }

        // 如果计数值大于最大值的话，就要把之前的记录全清理，因为对于之前的统计已经都不是众数了。然后重新把当前节点的值统计进来
        if (count > maxCount) {
            list.clear();
            list.add(root.val);
            maxCount = count;
        } else if (count == maxCount) { // 如果计数值等于最大值的话，也要收录进来
            list.add(root.val);
        }
        pre = root; // 更新上一个节点

        traverse(root.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}