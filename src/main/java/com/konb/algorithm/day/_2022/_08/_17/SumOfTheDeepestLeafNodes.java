package com.konb.algorithm.day._2022._08._17;

import com.konb.algorithm.day.TreeNode;

/**
 * @author konb
 * @version 1.0
 * @date 2022-08-17 9:13
 * leetcode 1302 层数最深叶子节点的和
 */
public class SumOfTheDeepestLeafNodes {

    private int maxDeep;

    private int sum;

    public int deepestLeavesSum(TreeNode root) {
        maxDeep = 0;
        sum = 0;
        traverse(0, root);
        return sum;
    }

    private void traverse(int start, TreeNode root) {
        if (root.right == null && root.left == null) {
            if (start + 1 == maxDeep) {
                sum += root.val;
            } else if (start + 1 > maxDeep) {
                maxDeep = start + 1;
                sum = root.val;
            }
            return;
        }
        if (root.left != null) {
            traverse(start + 1, root.left);
        }
        if (root.right != null) {
            traverse(start + 1, root.right);
        }
    }

}
