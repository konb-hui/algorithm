package com.konb.algorithm.day._20220720;

import com.konb.algorithm.day.TreeNode;

/**
 * @author konb
 * @version 1.0
 * @date 2022-07-20 16:37
 * leetcode 111 二叉树的最小深度
 */
public class MinimumDepthOfBinaryTree {

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) {
            return 1;
        }
        Integer min = null;
        if (root.left != null) {
            min = minDepth(root.left);
        }
        if (root.right != null) {
            int temp = minDepth(root.right);
            min = min == null ? temp : Math.min(min, temp);
        }

        return min + 1;
    }


}
