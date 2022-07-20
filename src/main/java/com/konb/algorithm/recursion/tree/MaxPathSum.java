package com.konb.algorithm.recursion.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author konb
 * @version 1.0
 * @date 2022-06-07 14:15`
 * <p>
 * 递归-二叉树-最大路径和
 */
public class MaxPathSum {

    static int maxSum = Integer.MIN_VALUE;

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    //计算每个节点的最大贡献

    public static int maxDedication(TreeNode root) {

        //空节点，返回0
        if (root == null) {
            return 0;
        }


        //计算左节点的最大贡献
        int leftMaxDedication = Math.max(maxDedication(root.left), 0);
        //计算右节点的最大贡献
        int rightMaxDedication = Math.max(maxDedication(root.right), 0);

        int dedication = leftMaxDedication + rightMaxDedication + root.val;

        //更新最大值
        maxSum = Math.max(maxSum, dedication);

        return Math.max(root.val + leftMaxDedication, root.val + rightMaxDedication);
    }

    public int maxPathSum(TreeNode root) {
        maxDedication(root);
        return maxSum;
    }

}
