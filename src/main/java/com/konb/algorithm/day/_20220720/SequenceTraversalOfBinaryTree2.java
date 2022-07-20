package com.konb.algorithm.day._20220720;

import com.konb.algorithm.day.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author konb
 * @version 1.0
 * @date 2022-07-20 16:29
 * leetcode 107 二叉树的层序遍历 II
 */
public class SequenceTraversalOfBinaryTree2 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        traver(list, root, 0);
        for (int i = 0; i < list.size() / 2; i ++) {
            List<Integer> temp = list.get(i);
            int index = list.size() - i - 1;
            list.set(i, list.get(index));
            list.set(index, temp);
        }
        return list;
    }

    public void traver(List<List<Integer>> list, TreeNode node, int index) {

        if (node == null) {
            return;
        }

        int nextIndex = index + 1;
        while (list.size() < nextIndex) {
            list.add(new ArrayList<>());
        }
        List<Integer> l = list.get(index);
        l.add(node.val);

        traver(list, node.left, nextIndex);
        traver(list, node.right, nextIndex);
    }

    public static void main(String[] args) {
        SequenceTraversalOfBinaryTree2 sequenceTraversalOfBinaryTree2 = new SequenceTraversalOfBinaryTree2();
        sequenceTraversalOfBinaryTree2.levelOrderBottom(new TreeNode(1));
    }

}
