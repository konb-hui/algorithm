package com.konb.algorithm.day._20220720;

import com.konb.algorithm.day.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author konb
 * @version 1.0
 * @date 2022-07-20 15:44
 * leetcode 102 二叉树的层序遍历
 */
public class SequenceTraversalOfBinaryTree {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        traver(list, root, 0);
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

}
