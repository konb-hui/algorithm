package com.konb.algorithm.day._20220720;

import com.konb.algorithm.day.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author konb
 * @version 1.0
 * @date 2022-07-20 11:02
 * leetcode 94 二叉树的中序遍历
 */
public class MiddleOrderTraversalOfBinaryTree {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traver(list, root);
        return list;
    }

    public void traver(List<Integer> list, TreeNode node) {
        if (node == null) {
            return;
        }

        if (node.left != null) {
            traver(list, node.left);
        }

        list.add(node.val);

        if (node.right != null) {
            traver(list, node.right);
        }

    }

}
