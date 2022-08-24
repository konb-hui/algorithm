package com.konb.algorithm.day._2022._08._24;

/**
 * @author konb
 * @version 1.0
 * @date 2022-08-24 16:35
 * leetcode 74 搜索二维矩阵
 */
public class Search2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int column = matrix[0].length;

        if (target < matrix[0][0] || target > matrix[row - 1][column - 1]) {
            return false;
        }

        for (int i = 0; i < row; i ++) {
            int a = matrix[i][column - 1];
            if (a == target) {
                return true;
            } else if (a > target) {
                int b = matrix[i][0];
                if (b == target) {
                    return true;
                } else if (b < target) {
                    int left = 1;
                    int right = column - 2;
                    while (left <= right) {
                        int mid = (left + right) >> 1;
                        int c = matrix[i][mid];
                        if (c == target) {
                            return true;
                        } else if (c < target) {
                            left = mid + 1;
                        } else {
                            right = mid - 1;
                        }
                    }
                }
            }
        }

        return false;
    }

}
