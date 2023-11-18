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

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LC_437_路径总和3 {
    public static void main(String[] args) {
        Solution solution = new LC_437_路径总和3().new Solution();
        TreeNode root = new TreeNode(10);
        TreeNode n5 = new TreeNode(5);
        TreeNode n_3 = new TreeNode(-3);
        TreeNode n3 = new TreeNode(3);
        TreeNode n2 = new TreeNode(2);
        TreeNode n11 = new TreeNode(11);
        TreeNode n32 = new TreeNode(3);
        TreeNode n_2 = new TreeNode(-2);
        TreeNode n1 = new TreeNode(1);

        root.left = n5;
        root.right = n_3;
        n5.left = n3;
        n5.right = n2;
        n3.left = n32;
        n3.right = n_2;
        n2.right = n1;

        n_3.right = n11;

        System.out.println(solution.pathSum(root, 8));
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
     * 回溯 + 前缀和
     *
     * 前缀和的概念：
     * 一个节点的前缀和就是该节点到根之间的路径和。
     * 前缀和的意义：
     * 因为对于同一路径上的两个节点，上面的节点是下面节点的祖先节点，所以其前缀和之差即是这两个节点间的路径和（不包含祖先节点的值）。
     * 哈希map的使用：
     * key是前缀和， value是该前缀和的节点数量，记录数量是因为有出现复数路径的可能。
     * 回溯的意义：
     * 因为只有同一条路径上的节点间（节点和其某一祖先节点间）的前缀和做差才有意义。所以当前节点处理完之后，需要从map中移除这一个前缀和，然后再进入下一个分支路径。
     *
     * @param root
     * @param targetSum
     * @return
     */
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        prefix.put(0L, 1);
        traverse(root, targetSum, 0);
        return count;
    }

    Map<Long, Integer> prefix = new HashMap<>();
    int count = 0;

    private void traverse(TreeNode root, long targetSum, long currSum) {
        if (root == null) {
            return;
        }
        currSum += root.val;

        count += prefix.getOrDefault(currSum - targetSum, 0);
        prefix.put(currSum, prefix.getOrDefault(currSum, 0) + 1);

        traverse(root.left, targetSum, currSum);
        traverse(root.right, targetSum, currSum);
        prefix.put(currSum, prefix.getOrDefault(currSum, 0) - 1);
    }

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

    private void dfs1(TreeNode root, long sum) {
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

    private void dfs2(TreeNode root, long sum) {
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

    private int dfs4(TreeNode root, long sum) {
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