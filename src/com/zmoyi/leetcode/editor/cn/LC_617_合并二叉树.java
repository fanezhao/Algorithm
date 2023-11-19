//给你两棵二叉树： root1 和 root2 。 
//
// 想象一下，当你将其中一棵覆盖到另一棵之上时，两棵树上的一些节点将会重叠（而另一些不会）。你需要将这两棵树合并成一棵新二叉树。合并的规则是：如果两个节点重叠
//，那么将这两个节点的值相加作为合并后节点的新值；否则，不为 null 的节点将直接作为新二叉树的节点。 
//
// 返回合并后的二叉树。 
//
// 注意: 合并过程必须从两个树的根节点开始。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
//输出：[3,4,5,5,4,null,7]
// 
//
// 示例 2： 
//
// 
//输入：root1 = [1], root2 = [1,2]
//输出：[2,2]
// 
//
// 
//
// 提示： 
//
// 
// 两棵树中的节点数目在范围 [0, 2000] 内 
// -10⁴ <= Node.val <= 10⁴ 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1351 👎 0


package com.zmoyi.leetcode.editor.cn;

import com.zmoyi.TreeNode;

public class LC_617_合并二叉树 {
    public static void main(String[] args) {
        Solution solution = new LC_617_合并二叉树().new Solution();
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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }

        TreeNode root = new TreeNode();
        if (root1 == null) {
            root.val = root2.val;
        } else if (root2 == null) {
            root.val = root1.val;
        } else {
            root.val = root1.val + root2.val;
        }

        root.left = mergeTrees(root1 == null ? null : root1.left, root2 == null ? null : root2.left);
        root.right = mergeTrees(root1 == null ? null : root1.right, root2 == null ? null : root2.right);
        return root;
    }

    /**
     * 优化版本
     * @param root1
     * @param root2
     * @return
     */
    public TreeNode mergeTrees2(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }

        root1.val += root2.val;
        root1.left = mergeTrees2(root1.left, root2.left);
        root1.right = mergeTrees2(root1.right, root2.right);
        return root1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}