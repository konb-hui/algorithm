package com.konb.algorithm.day._2022._08._24;

import java.util.Arrays;

/**
 * @author konb
 * @version 1.0
 * @date 2022-08-24 16:09
 * leetcode
 */
public class MatrixZeroing {

    public void setZeroes(int[][] matrix) {
        boolean r0 = false;
        boolean l0 = false;

        for (int i = 0; i < matrix[0].length; i ++) {
            if (matrix[0][i] == 0) {
                r0 = true;
                break;
            }
        }

        for (int[] ints : matrix) {
            if (ints[0] == 0) {
                l0 = true;
                break;
            }
        }

        for (int i = 1; i < matrix.length; i ++) {
            for (int j = 1; j < matrix[i].length; j ++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < matrix[0].length; i ++) {
            if (matrix[0][i] == 0) {
                for (int j = 1; j < matrix.length; j ++) {
                    matrix[j][i] = 0;
                }
            }
        }

        for (int i = 1; i < matrix.length; i ++) {
            if (matrix[i][0] == 0) {
                Arrays.fill(matrix[i], 0);
            }
        }

        if (r0) {
            Arrays.fill(matrix[0], 0);
        }

        if (l0) {
            for (int[] ints : matrix) {
                ints[0] = 0;
            }
        }

    }

}
