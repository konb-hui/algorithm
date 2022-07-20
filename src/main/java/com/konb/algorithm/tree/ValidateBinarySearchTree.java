package com.konb.algorithm.tree;

import java.util.Stack;
import java.util.TreeMap;

/**
 * @author konb
 * @version 1.0
 * @date 2022-07-01 8:51
 * leetcode 98
 */
public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }

    public boolean isValidBST(TreeNode root, long max, long min) {
        if (root == null) {
            return true;
        }

        if (root.val >= max || root.val <= min) {
            return false;
        }

        return isValidBST(root.left, root.val, min) && isValidBST(root.right, max, root.val);
    }

    /**
     * 中序遍历
     */
    public boolean isValidBST2(TreeNode root) {
        long preValue = Long.MIN_VALUE;
        Stack<TreeNode> stack = new Stack<>();

        while (! stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();

            if (root.val <= preValue) {
                return false;
            }

            preValue = root.val;

            root = root.right;
        }

        return true;
    }

    public static void main(String[] args) {

        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(2);
        TreeNode treeNode4 = null;
        TreeNode treeNode5 = null;
        TreeNode treeNode6 = new TreeNode(3);
        TreeNode treeNode7 = new TreeNode(7);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
//        treeNode2.left = treeNode4;
//        treeNode2.right = treeNode5;
//        treeNode3.left = treeNode6;
//        treeNode3.right = treeNode7;

        ValidateBinarySearchTree validateBinarySearchTree = new ValidateBinarySearchTree();
        System.out.println(validateBinarySearchTree.isValidBST2(treeNode1));

    }

}
