package com.konb.algorithm.day._20220720;

import com.konb.algorithm.day.TreeNode;

/**
 * @author konb
 * @version 1.0
 * @date 2022-07-20 16:21
 * leetcode 104 二叉树的最大深度
 */
public class MaximumDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

}
