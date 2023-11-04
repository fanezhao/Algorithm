package com.zmoyi.dataStructure.tree;

import com.zmoyi.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 树的遍历
 *
 * @author zhaofeng
 * @date 2023/11/1 16:45
 */
public class TraversalUtils {

    /**
     * 前序遍历（递归版）
     *
     * @param root
     */
    public static void preOrder(TreeNode root) {
        if (root == null) {
            System.out.println("null");
            return;
        }
        List<Integer> ret = new ArrayList<>();
        pre(root, ret);
        System.out.println(ret.stream().map(String::valueOf).collect(Collectors.joining(", ")));
    }

    private static void pre(TreeNode root, List<Integer> ret) {
        if (root == null) {
            return;
        }
        ret.add(root.val);
        pre(root.left, ret);
        pre(root.right, ret);
    }

    /**
     * 前序遍历（迭代版）
     *
     * @param root
     */
    public static void preOrderWithStack(TreeNode root) {
        if (root == null) {
            System.out.println("null");
            return;
        }
        List<Integer> ret = new ArrayList<>();
        preWithStack(root, ret);
        System.out.println(ret.stream().map(String::valueOf).collect(Collectors.joining(", ")));
    }

    private static void preWithStack(TreeNode root, List<Integer> ret) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            ret.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    /**
     * 中序遍历（递归版）
     *
     * @param root
     */
    public static void inOrder(TreeNode root) {
        if (root == null) {
            System.out.println("null");
            return;
        }
        List<Integer> ret = new ArrayList<>();
        in(root, ret);
        System.out.println(ret.stream().map(String::valueOf).collect(Collectors.joining(", ")));
    }

    private static void in(TreeNode root, List<Integer> ret) {
        if (root == null) {
            return;
        }
        in(root.left, ret);
        ret.add(root.val);
        in(root.right, ret);
    }

    /**
     * 中序遍历（迭代版）
     *
     * @param root
     */
    public static void inOrderWithStack(TreeNode root) {
        if (root == null) {
            System.out.println("null");
            return;
        }
        List<Integer> ret = new ArrayList<>();
        inWithStack(root, ret);
        System.out.println(ret.stream().map(String::valueOf).collect(Collectors.joining(", ")));
    }

    private static void inWithStack(TreeNode root, List<Integer> ret) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            if (!stack.isEmpty()) {
                node = stack.pop();
                ret.add(node.val);
                node = node.right;
            }
        }
    }

    /**
     * 后续遍历（递归版）
     *
     * @param root
     */
    public static void postOrder(TreeNode root) {
        if (root == null) {
            System.out.println("null");
            return;
        }
        List<Integer> ret = new ArrayList<>();
        post(root, ret);
        System.out.println(ret.stream().map(String::valueOf).collect(Collectors.joining(", ")));
    }

    private static void post(TreeNode root, List<Integer> ret) {
        if (root == null) {
            return;
        }
        post(root.left, ret);
        post(root.right, ret);
        ret.add(root.val);
    }

    /**
     * 后续遍历（迭代版）
     *
     * @param root
     */
    public static void postOrderWithStack(TreeNode root) {
        if (root == null) {
            System.out.println("null");
            return;
        }
        List<Integer> ret = new ArrayList<>();
        postWithStack(root, ret);
        System.out.println(ret.stream().map(String::valueOf).collect(Collectors.joining(", ")));
    }

    private static void postWithStack(TreeNode root, List<Integer> ret) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            ret.add(node.val);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        Collections.reverse(ret);
    }

    /**
     * 层序遍历（迭代法）
     *
     * @param root
     */
    public static void levelOrder(TreeNode root) {
        if (root == null) {
            System.out.println("null");
            return;
        }
        List<Integer> ret = new ArrayList<>();
        level(root, ret);
        System.out.println(ret.stream().map(String::valueOf).collect(Collectors.joining(", ")));
    }

    private static void level(TreeNode root, List<Integer> ret) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            ret.add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }

    /**
     * 层序遍历（迭代法）：二维数组
     * @param root
     */
    public static void levelOrder2(TreeNode root) {
        if (root == null) {
            System.out.println("null");
            return;
        }
        List<List<Integer>> ret = new ArrayList<>();
        level2(root, ret);
        System.out.println(ret.stream().map(l -> l.stream().map(String::valueOf).collect(Collectors.joining(", "))).collect(Collectors.joining(" | ")));
    }

    /**
     * @param root
     * @param ret
     */
    private static void level2(TreeNode root, List<List<Integer>> ret) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> levelList = new ArrayList<>();
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                levelList.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
            ret.add(levelList);
        }
    }
}
