package com.zmoyi.dataStructure.tree;

import com.zmoyi.TreeNode;

/**
 * @author zhaofeng
 * @date 2023/11/4 15:56
 */
public class BinarySearchTreeTest {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(33);
        TreeNode n17 = new TreeNode(17);
        TreeNode n50 = new TreeNode(50);
        TreeNode n13 = new TreeNode(13);
        TreeNode n18 = new TreeNode(18);
        TreeNode n34 = new TreeNode(34);
        TreeNode n58 = new TreeNode(58);
        TreeNode n16 = new TreeNode(16);
        TreeNode n25 = new TreeNode(25);
        TreeNode n51 = new TreeNode(51);
        TreeNode n66 = new TreeNode(66);
        TreeNode n19 = new TreeNode(19);
        TreeNode n27 = new TreeNode(27);
        root.left = n17;
        n17.left = n13;
        n17.right = n18;
        n13.right = n16;
        n18.right = n25;
        n25.left = n19;
        n25.right = n27;

        root.right = n50;
        n50.left = n34;
        n50.right = n58;
        n58.left = n51;
        n58.right = n66;

        BinarySearchTree bsTree = new BinarySearchTree();
        bsTree.setRoot(root);

        TraversalUtils.inOrderWithStack(root);

        TreeNode node = bsTree.find(19);
        System.out.println(node.val);

        bsTree.insert(55);
        TraversalUtils.levelOrder2(root);

//        bsTree.del(13);
//        TraversalUtils.levelOrder2(root);

//        bsTree.del(50);
//        TraversalUtils.levelOrder2(root);
    }
}
