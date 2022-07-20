package com.konb.algorithm.day._20220720;

import com.konb.algorithm.day.TreeNode;

import java.util.List;

/**
 * @author konb
 * @version 1.0
 * @date 2022-07-20 11:23
 * leetcode 99 恢复二叉搜索树
 */
public class RestoreBinarySearchTree {

    public void recoverTree(TreeNode root) {
        TreeNode[] tree = new TreeNode[2];
        recoverTree(root, tree);
        int temp = tree[0].val;
        tree[0].val= tree[1].val;
        tree[1].val = temp;
    }

    public void recoverTree(TreeNode root, TreeNode[] tree) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            recoverTree(root.left, tree);
        }

        if ((tree[0] == null || root.val > tree[0].val) && tree[1] == null) {
            tree[0] = root;
        } else if (root.val < tree[0].val) {
            tree[1] = root;
        }

        if (root.right != null) {
            recoverTree(root.right, tree);
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(4);
        TreeNode treeNode3 = new TreeNode(2);

        treeNode2.left = treeNode3;
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;

        RestoreBinarySearchTree restoreBinarySearchTree = new RestoreBinarySearchTree();
        restoreBinarySearchTree.recoverTree(treeNode);
    }

}
