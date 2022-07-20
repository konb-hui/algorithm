package com.konb.algorithm.day._20220719;

/**
 * @author konb
 * @version 1.0
 * @date 2022-07-19 15:51
 * leetcode 70 爬楼梯
 */
public class ClimbStairs {

    public int climbStairs(int n) {
        int[] dp = new int[n + 1];

        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i ++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

}
