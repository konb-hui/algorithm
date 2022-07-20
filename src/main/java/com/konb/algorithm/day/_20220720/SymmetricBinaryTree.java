package com.konb.algorithm.day._20220720;

import com.konb.algorithm.day.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author konb
 * @version 1.0
 * @date 2022-07-20 14:21
 * leetcode 101 对称二叉树
 */
public class SymmetricBinaryTree {

    public boolean isSymmetric(TreeNode root) {
        return traverse(root, root);
    }

    public boolean traverse(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        } else if (node1 != null && node2 != null) {
            return node1.val == node2.val && traverse(node1.left, node2.right) && traverse(node1.right, node2.left);
        }
        return false;
    }

}
