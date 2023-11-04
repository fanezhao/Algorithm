package com.zmoyi.dataStructure.tree;

import com.zmoyi.TreeNode;

/**
 * @author zhaofeng
 * @date 2023/11/1 16:51
 */
public class TraversalUtilsTest {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        root.left = two;
        root.right = three;
        two.left = four;
        two.right = five;
        three.right = six;

        TraversalUtils.preOrder(root);
        TraversalUtils.preOrderWithStack(root);
        System.out.println("~~~~~");
        TraversalUtils.inOrder(root);
        TraversalUtils.inOrderWithStack(root);
        System.out.println("~~~~~");
        TraversalUtils.postOrder(root);
        TraversalUtils.postOrderWithStack(root);
        System.out.println("~~~~~");
        TraversalUtils.levelOrder(root);
        TraversalUtils.levelOrder2(root);
    }
}
