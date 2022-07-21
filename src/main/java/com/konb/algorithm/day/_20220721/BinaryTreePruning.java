package com.konb.algorithm.day._20220721;

import com.konb.algorithm.day.TreeNode;

/**
 * @author konb
 * @version 1.0
 * @date 2022-07-21 11:43
 * leetcode 814 二叉树剪枝
 */
public class BinaryTreePruning {

    public TreeNode pruneTree(TreeNode root) {
        boolean prune = prune(root);
        return prune ? root : null;
    }

    public boolean prune(TreeNode treeNode) {
        if (treeNode == null) {
            return false;
        }
        if (treeNode.left != null) {
            if (! prune(treeNode.left)) {
                treeNode.left = null;
            }
        }
        if (treeNode.right != null) {
            if (! prune(treeNode.right)) {
                treeNode.right = null;
            }
        }

        return treeNode.left != null || treeNode.right != null || treeNode.val == 1;
    }

}
