package com.konb.algorithm.tree;

/**
 * @author konb
 * @version 1.0
 * @date 2022-07-01 14:29
 * leetcode 112 路径总和
 */
public class PathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        int val = root.val;
        if (targetSum == val && root.left == null && root.right == null) {
            return true;
        }
        int remaining = targetSum - val;
        return hasPathSum(root.left ,remaining) || hasPathSum(root.right, remaining);
    }

}
