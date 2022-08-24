package com.konb.algorithm.day._2022._08._22;

import com.konb.algorithm.day.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author konb
 * @version 1.0
 * @date 2022-08-22 10:03
 * leetcode 655 输出二叉树
 */
public class OutputBinaryTree {

    private final static String EMPTY = "";

    public List<List<String>> printTree(TreeNode root) {
        int height = height(root) - 1;

        List<List<String>> r = new ArrayList<>();

        if (root != null) {
            int row = 0;
            int c = (int) Math.pow(2, height + 1) - 1;
            int column = (c - 1) / 2;
            List<String> list = new ArrayList<>();
            for (int i = 0; i < column; i ++) {
                list.add(EMPTY);
            }
            list.add(root.val + EMPTY);
            for (int i = column + 1; i < c; i ++) {
                list.add(EMPTY);
            }
            r.add(list);
            setList(r, row, column, root, height, c);
        }
        return r;
    }

    private void setList(List<List<String>> r, int row, int column, TreeNode root, int height, int c) {
        if (root.left != null) {
            int newRow = row + 1;
            int newColumn = column - (int) Math.pow(2, height - row - 1);

            if (newRow >= r.size()) {
                for (int i = r.size(); i <= newRow; i ++) {
                    r.add(new ArrayList<>());
                }
            }
            List<String> list = r.get(newRow);
            if (list.size() - 1 < newColumn) {
                for (int i = Math.max(list.size() - 1, 0); i < newColumn; i ++) {
                    list.add(EMPTY);
                }
                list.add(root.left.val + EMPTY);
                for (int i = newColumn + 1; i < c; i ++) {
                    list.add(EMPTY);
                }
            } else {
                list.set(newColumn, root.left.val + EMPTY);
            }
            setList(r, newRow, newColumn, root.left, height, c);
        }

        if (root.right != null) {
            int newRow = row + 1;
            int newColumn = column + (int) Math.pow(2, height - row - 1);

            if (newRow >= r.size()) {
                for (int i = r.size(); i <= newRow; i ++) {
                    r.add(new ArrayList<>());
                }
            }
            List<String> list = r.get(newRow);
            if (list.size() - 1 < newColumn) {
                for (int i = Math.max(list.size() - 1, 0); i < newColumn; i ++) {
                    list.add(EMPTY);
                }
                list.add(root.right.val + EMPTY);
                for (int i = newColumn + 1; i < c; i ++) {
                    list.add(EMPTY);
                }
            } else {
                list.set(newColumn, root.right.val + EMPTY);
            }
            setList(r, newRow, newColumn, root.right, height, c);
        }
    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(height(root.right), height(root.left));
    }

    public static void main(String[] args) {
        OutputBinaryTree outputBinaryTree = new OutputBinaryTree();
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        treeNode1.left = treeNode2;
        System.out.println(outputBinaryTree.printTree(treeNode1));
    }

}
