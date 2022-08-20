package com.konb.algorithm.day._2022._08._20;

import com.konb.algorithm.day.TreeNode;

/**
 * @author konb
 * @version 1.0
 * @date 2022-08-20 11:02
 * leetcode 654 最大二叉树
 */
public class MaximumBinaryTree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return getTreeNode(nums, 0, nums.length - 1);
    }

    private TreeNode getTreeNode(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            return new TreeNode(nums[start]);
        }

        int max = nums[start];
        int maxIndex = start;

        for (int i = start + 1; i <= end; i ++) {
            if (max < nums[i]) {
                max = nums[i];
                maxIndex = i;
            }
        }

        TreeNode treeNode = new TreeNode(max);
        treeNode.left = getTreeNode(nums, start, maxIndex - 1);
        treeNode.right = getTreeNode(nums, maxIndex + 1, end);

        return treeNode;

    }

    public static void main(String[] args) {
        MaximumBinaryTree maximumBinaryTree = new MaximumBinaryTree();
        System.out.println(maximumBinaryTree.constructMaximumBinaryTree(new int[] {3, 2, 1, 6, 0, 5}));
    }

}
