//给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。 
//
// 假设二叉树中至少有一个节点。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: root = [2,1,3]
//输出: 1
// 
//
// 示例 2: 
//
// 
//
// 
//输入: [1,2,3,4,null,5,6,null,null,7]
//输出: 7
// 
//
// 
//
// 提示: 
//
// 
// 二叉树的节点个数的范围是 [1,10⁴] 
// 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 544 👎 0


package com.zmoyi.leetcode.editor.cn;

import com.zmoyi.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LC_513_找树左下角的值 {
    public static void main(String[] args) {
        Solution solution = new LC_513_找树左下角的值().new Solution();
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

        /**
         * 层序遍历，遍历第一层的时间第一个元素就是当前层的最左元素，最后一层的时候就是最左下角的值
         *
         * @param root
         * @return
         */
        public int findBottomLeftValue2(TreeNode root) {
            int ret = 0;
            if (root == null) {
                return ret;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    if (i == 0) {
                        ret = node.val;
                    }
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


        /**
         * 递归法：当最大深度时，不管是前、中、后序遍历，都是先遍历左节点。
         * 所以当到达叶子节点时判断是不是最大深度，如果是更新结果值即可。
         *
         * @param root
         * @return
         */
        public int findBottomLeftValue(TreeNode root) {
            traverse(root);
            return ret;
        }

        int depth = 0;
        int maxDepth = 0;
        int ret = 0;

        private void traverse(TreeNode root) {
            if (root == null) {
                return;
            }
            depth++;
            if (root.left == null && root.right == null) {
                if (depth > maxDepth) {
                    maxDepth = depth;
                    ret = root.val;
                }
            }
            traverse(root.left);
            traverse(root.right);
            depth--;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}