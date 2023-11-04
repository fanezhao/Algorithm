package com.zmoyi.dataStructure.tree;

import com.zmoyi.TreeNode;

/**
 * 二叉查找树：又叫二叉搜索树，是为了快速查找而生的。
 * 二叉树要求：在树中的任意一个节点，其左子树中的每个节点的值都要小于这个节点的值；其右子树的每个节点的值都是大于这个节点的值。
 *
 * @author zhaofeng
 * @date 2023/11/4 15:20
 */
public class BinarySearchTree {

    private TreeNode root;

    /**
     * 查找
     *
     * @param data
     * @return
     */
    public TreeNode find(int data) {
        TreeNode node = root;
        while (node != null) {
            if (node.val == data) {
                return node;
            }
            if (node.val > data) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return null;
    }

    /**
     * 插入操作
     * @param data
     */
    public void insert(int data) {
        if (root == null) {
            root = new TreeNode(data);
            return;
        }

        TreeNode node = root;
        while (node != null) {
            if (data > node.val) {
                if (node.right == null) {
                    node.right = new TreeNode(data);
                    return;
                }
                node = node.right;
            } else {
                if (node.left == null) {
                    node.left = new TreeNode(data);
                    return;
                }
                node = node.left;
            }
        }
    }

    /**
     * 删除操作
     * @param data 
     */
    public void del(int data) {
        if (root == null) {
            return;
        }
        TreeNode node = root;   // node 指向要删除的节点，初始化指向要节点
        TreeNode pNode = null; // pNode 指向要删除节点的父节点
        while (node != null && data != node.val) {
            pNode = node;
            if (data > node.val) {
                node = node.right;
            } else {
                node = node.left;
            } 
        }
        if (node == null) {
            return;
        }

        // 要删除的节点有两个子节点
        if (node.left != null && node.right != null) {  // 查找右子树中的最小节点
            TreeNode minNode = node.right;
            TreeNode minPNode = node;  // minPNode 表示最小节点的父节点
            while (minNode.left != null) {
                minPNode = minNode;
                minNode = minNode.left;
            }
            node.val = minNode.val; // 将最小节点的值替换到要删除节点中
            node = minNode; // 下面就变成删除最小节点了
            pNode = minPNode;
        }

        //  删除节点是叶子节点或仅有一个子节点
        TreeNode child; // node 的子节点
        if (node.left != null) {
            child = node.left;
        } else if (node.right != null) {
            child = node.right;
        } else {
            child = null;
        }

        if (pNode == null) {    // 删除的是根节点
            root = child;
        } else if (pNode.left == node) {
            pNode.left = child;
        } else {
            pNode.right = child;
        }
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }
}
