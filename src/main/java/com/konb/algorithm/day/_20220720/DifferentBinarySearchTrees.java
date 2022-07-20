package com.konb.algorithm.day._20220720;

import com.konb.algorithm.day.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author konb
 * @version 1.0
 * @date 2022-07-20 17:45
 * leetcode 95 不同的二叉搜索树 II
 */
public class DifferentBinarySearchTrees {

    public List<TreeNode> generateTrees(int n) {
        List<List<TreeNode>> dp = new ArrayList<>();

        List<TreeNode> list0 = new ArrayList<>();
        list0.add(null);
        dp.add(list0);

        List<TreeNode> list1 = new ArrayList<>();
        list1.add(new TreeNode(1));
        dp.add(list1);

        for (int i = 2; i <= n; i ++) {
            List<TreeNode> list = new ArrayList<>();
            for (int j = 0; j <= i; j ++) {
                int k = i - j - 1;
                List<TreeNode> treeNodes = dp.get(j);
                for (int l = 0; l < treeNodes.size(); l ++) {
                    if (l == 0 && treeNodes.get(l) == null) {
                        break;
                    } else {

                    }
                }
            }
        }

        return dp.get(n);
    }

}
