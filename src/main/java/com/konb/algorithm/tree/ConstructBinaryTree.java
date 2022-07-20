package com.konb.algorithm.tree;

/**
 * @author konb
 * @version 1.0
 * @date 2022-07-01 15:46
 * leetcode 105 从前序与中序遍历序列构造二叉树
 */
public class ConstructBinaryTree {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder, int begin1, int end1, int begin2, int end2) {

        if (begin1 > end1) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[begin1]);
        if (begin1 == end1) {
            return root;
        }

        int rootIndex = begin2;
        for (int i = begin2; i <= end2; i ++) {
            if (preorder[begin1] == inorder[i]) {
                rootIndex = i;
                break;
            }
        }
        int leftBegin1 = begin1 + 1;
        int leftEnd1 = leftBegin1 + rootIndex - begin2 - 1;
        root.left = buildTree(preorder, inorder, leftBegin1, leftEnd1, begin2, rootIndex - 1);
        root.right = buildTree(preorder, inorder, leftEnd1 + 1, end1, rootIndex + 1, end2);

        return root;
    }

    public static void main(String[] args) {
        ConstructBinaryTree constructBinaryTree = new ConstructBinaryTree();
        constructBinaryTree.buildTree(new int[]{1,2}, new int[]{2,1});
    }

}
