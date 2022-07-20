package com.konb.algorithm.day._20220719;

/**
 * @author konb
 * @version 1.0
 * @date 2022-07-19 15:31
 * leetcode 64 最小路径和
 */
public class MinimumPathSum {

    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        for (int i = 1; i < n; i ++) {
            grid[i][0] = grid[i - 1][0] + grid[i][0];
        }

        for (int i = 1; i < m; i ++) {
            grid[0][i] = grid[0][i - 1] + grid[0][i];
        }

        for (int i = 1; i < n; i ++) {
            for (int j = 1; j < m; j ++) {
                grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
            }
        }

        return grid[n - 1][m - 1];
    }

    public static void main(String[] args) {
        MinimumPathSum minimumPathSum = new MinimumPathSum();
        System.out.println(minimumPathSum.minPathSum(new int[][] {{1,3,1},{1,5,1},{4,2,1}}));
    }

}
