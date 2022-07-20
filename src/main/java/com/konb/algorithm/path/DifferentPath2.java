package com.konb.algorithm.path;

/**
 * @author konb
 * @version 1.0
 * @date 2022-07-12 15:35
 */
public class DifferentPath2 {

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;

        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        if (n < 2 && obstacleGrid[0][m - 1] != 1) {
            return 1;
        }

        if (m < 2 && obstacleGrid[n - 1][0] != 1) {
            return 1;
        }

        if (obstacleGrid[n - 1][m - 1] == 1) {
            return 0;
        }

        boolean flag = false;
        for (int i = 0; i < n; i ++) {
            if (obstacleGrid[i][0] == 1) {
                obstacleGrid[i][0] = 0;
                flag = true;
                continue;
            }
            if (flag) {
                obstacleGrid[i][0] = 0;
                continue;
            }
            obstacleGrid[i][0] = 1;
        }

        flag = false;
        for (int j = 1; j < m; j ++) {
            if (obstacleGrid[0][j] == 1) {
                obstacleGrid[0][j] = 0;
                flag = true;
                continue;
            }
            if (flag) {
                obstacleGrid[0][j] = 0;
                continue;
            }
            obstacleGrid[0][j] = 1;
        }

        int a = 0;

        for (int i = 1; i < n; i ++) {
            for (int j = 1; j < m; j ++) {
                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = 0;
                    continue;
                }
                obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
            }
        }

        return obstacleGrid[n - 1][m - 1];
    }

    public static void main(String[] args) {

        int[][] a = new int[3][3];
        a[1][1] = 1;
        System.out.println(uniquePathsWithObstacles(a));

    }

}
