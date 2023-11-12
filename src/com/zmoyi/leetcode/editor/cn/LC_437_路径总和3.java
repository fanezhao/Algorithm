//给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。 
//
// 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
//输出：3
//解释：和等于 8 的路径有 3 条，如图所示。
// 
//
// 示例 2： 
//
// 
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//输出：3
// 
//
// 
//
// 提示: 
//
// 
// 二叉树的节点个数的范围是 [0,1000] 
// 
// -10⁹ <= Node.val <= 10⁹ 
// -1000 <= targetSum <= 1000 
// 
//
// Related Topics 树 深度优先搜索 二叉树 👍 1751 👎 0


package com.zmoyi.leetcode.editor.cn;

import com.zmoyi.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LC_437_路径总和3 {
    public static void main(String[] args) {
        Solution solution = new LC_437_路径总和3().new Solution();
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

    int ret = 0;
    int targetSum;

    /**
     * 版本一：BFS+DFS。前一个BFS为第一步，后一个DFS为第二步。
     * @param root
     * @param targetSum
     * @return
     */
    public int pathSum1(TreeNode root, int targetSum) {
        this.targetSum = targetSum;
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                dfs1(node, 0);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return ret;
    }

    private void dfs1(TreeNode root, Integer sum) {
        if (root == null) {
            return;
        }
        sum += root.val;
        if (sum == targetSum) {
            ret++;
        }
        dfs1(root.left, sum);
        dfs1(root.right, sum);
    }

    /**
     * 版本二：DFS+DFS。将第一步考察每一个结点的动作用DFS实现，后一个DFS作用不变。
     * @param root
     * @param targetSum
     * @return
     */
    public int pathSum2(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        this.targetSum = targetSum;
        dfs2(root, 0);
        return ret;
    }

    private void dfs2(TreeNode root, Integer sum) {
        if (root == null) {
            return;
        }
        dfs1(root, 0);
        dfs2(root.left, sum);
        dfs2(root.right, sum);
    }

    /**
     * 版本三：带返回值的DFS+DFS。
     * @param root
     * @param targetSum
     * @return
     */
    public int pathSum3(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        this.targetSum = targetSum;
        dfs3(root);
        return ret;
    }

    private void dfs3(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs4(root, 0);
        dfs3(root.left);
        dfs3(root.right);
    }

    private int dfs4(TreeNode root, Integer sum) {
        if (root == null) {
            return 0;
        }
        int curr = 0;
        sum += root.val;
        if (sum == targetSum) {
            curr = 1;
        }
        int leftCount = dfs4(root.left, sum);
        int rightCount = dfs4(root.right, sum);
        return curr + leftCount + rightCount;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}