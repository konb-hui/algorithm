package com.konb.algorithm.path;

/**
 * @author konb
 * @version 1.0
 * @date 2022-07-12 14:10 田
 */
public class Solution {

    public static int countPath(int m, int n) {
        int[][] dp = new int[m][n];

        for (int i = 1; i < m; i ++) {
            dp[i][0] = 1;
        }
        for (int j = 1; j < n; j ++) {
            dp[0][j] = 1;
        }

        int a = 1;

        for (int i = 1; i < m; i ++) {
            for (int j = 1; j < n; j ++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        int b = 2;

        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(countPath(3, 2));
    }

}
