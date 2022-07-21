package com.konb.algorithm.day._20220721;

/**
 * @author konb
 * @version 1.0
 * @date 2022-07-21 14:43
 * leetcode 96 不同的二叉搜索树
 */
public class DifferentBinarySearchTrees {

    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        if (n == 1) {
            return 1;
        }

        for (int i = 2; i <= n; i ++) {
            int num = 0;
            for (int j = 0; j < i; j ++) {
                int k = i - j - 1;
                num += dp[j] * dp[k];
            }
            dp[i] = num;
        }

        return dp[n];
    }

}
