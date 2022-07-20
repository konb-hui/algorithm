package com.konb.algorithm.day._20220720;

import com.konb.algorithm.day.TreeNode;

/**
 * @author konb
 * @version 1.0
 * @date 2022-07-20 14:07
 * leetcode 100 相同的树
 */
public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p != null && q != null) {
            return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        return false;
    }

}
