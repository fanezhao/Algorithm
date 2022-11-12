package com.zmoyi.data_structure.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class BinaryTreeUtils {

    /**
     * 构建二叉树
     * @return
     */
    public static TreeNode createBinaryTree(LinkedList<Integer> inputList) {
        TreeNode node = null;

        if (inputList == null || inputList.isEmpty()) {
            return node;
        }

        Integer data = inputList.removeFirst();
        if (data != null) {
            node = new TreeNode(data);
            node.leftChild = createBinaryTree(inputList);
            node.rightChild = createBinaryTree(inputList);
        }

        return node;
    }

    /**
     * 二叉树前序遍历
     * 根节点 -> 左子树 -> 右子树
     * @param node
     */
    public static void preOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.data);
        preOrderTraversal(node.leftChild);
        preOrderTraversal(node.rightChild);
    }

    /**
     * 非递归的形式前序遍历
     * @param root
     */
    public static void preOrderTraversalWithStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode treeNode = root;
        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                System.out.println(treeNode.data);
                stack.push(treeNode);
                treeNode = treeNode.leftChild;
            }

            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                treeNode = treeNode.rightChild;
            }
        }
    }

    /**
     * 二叉树中序遍历
     * 左 -> 根 -> 右
     * @param node
     */
    public static void inOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }

        inOrderTraversal(node.leftChild);
        System.out.println(node.data);
        inOrderTraversal(node.rightChild);
    }

    /**
     * 二叉树后序遍历
     * 左 -> 右 -> 根
     * @param node
     */
    public static void postOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }

        postOrderTraversal(node.leftChild);
        postOrderTraversal(node.rightChild);
        System.out.println(node.data);
    }

    /**
     * 层序遍历
     * @param node
     */
    public static void levelOrderTraversal(TreeNode node) {
        LinkedList<TreeNode> list = new LinkedList<>();
        list.offer(node);

        while (!list.isEmpty()) {
            TreeNode poll = list.poll();
            System.out.println(poll.data);
            if (poll.leftChild != null) {
                list.offer(poll.leftChild);
            }
            if (poll.rightChild != null) {
                list.offer(poll.rightChild);
            }
        }
    }

    public static void main(String[] args) {

        /**
         *          3
         *       2      8
         *     9  10       4
         */
        LinkedList<Integer> inputList = new LinkedList<>(Arrays.asList(new Integer[]{3, 2, 9, null, null, 10, null, null, 8, null, 4}));

        TreeNode binaryTree = createBinaryTree(inputList);
        System.out.println("前序遍历：");
        preOrderTraversal(binaryTree);
        System.out.println("非递归前序遍历：");
        preOrderTraversalWithStack(binaryTree);
        System.out.println("中序遍历：");
        inOrderTraversal(binaryTree);
        System.out.println("后序遍历：");
        postOrderTraversal(binaryTree);
        System.out.println("层序遍历");
        levelOrderTraversal(binaryTree);
    }
}
