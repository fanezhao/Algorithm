package com.zmoyi.dataStructure.tree;

import com.zmoyi.TreeNode;

/**
 * @author zhaofeng
 * @date 2023/11/1 16:51
 */
public class TraversalUtilsTest {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;

        TraversalUtils.preOrder(root);
        System.out.println("~~~~~");
        TraversalUtils.inOrder(root);
        System.out.println("~~~~~");
        TraversalUtils.postOrder(root);
        System.out.println("~~~~~");
        TraversalUtils.levelOrder(root);
    }
}
