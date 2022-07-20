package com.konb.algorithm.day._20220720;

import com.konb.algorithm.day.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author konb
 * @version 1.0
 * @date 2022-07-20 16:01
 * leetcode 103 二叉树的锯齿形层序遍历
 */
public class ZigzagSequenceTraversalOfBinaryTree {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        traver(list, root, 0);

        for (int i = 1; i < list.size(); i += 2) {
            final List<Integer> list1 = list.get(i);
            for (int j = 0; j < list1.size() / 2; j ++) {
                int temp = list1.get(j);
                int index = list1.size() - j - 1;
                list1.set(j, list1.get(index));
                list1.set(index, temp);
            }
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

}
