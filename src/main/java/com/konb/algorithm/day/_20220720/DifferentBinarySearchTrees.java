package com.konb.algorithm.day._20220720;

import com.konb.algorithm.day.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

/**
 * @author konb
 * @version 1.0
 * @date 2022-07-20 17:45
 * leetcode 95 不同的二叉搜索树 II
 */
public class DifferentBinarySearchTrees {

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<>();
        }
        return generateTrees(1, n);
    }

    public List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> list = new LinkedList<>();
        if (start > end) {
            list.add(null);
            return list;
        }
        for (int i = start; i <= end; i ++) {
            List<TreeNode> leftTree = generateTrees(start, i - 1);
            List<TreeNode> rightTree = generateTrees(i + 1, end);

            for (TreeNode a : leftTree) {
                for (TreeNode b : rightTree) {
                    TreeNode node = new TreeNode(i);
                    node.left = a;
                    node.right = b;
                    list.add(node);
                }
            }
        }
        return list;
    }

}
