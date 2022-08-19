package com.konb.algorithm.day._2022._08._19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author konb
 * @version 1.0
 * @date 2022-08-19 17:13
 * leetcode 59 螺旋矩阵 II
 */
public class HelixMatrix2 {

    public int[][] generateMatrix(int n) {
        int[][] r = new int[n][n];
        int start1 = 0;
        int end1 = n - 1;
        int start2 = 0;
        int end2 = n - 1;

        int count = 1;
        while (start1 <= end1 && start2 <= end2) {
            for (int i = start2; i <= end2; i ++) {
                r[start1][i] = count ++;
            }

            for (int i = start1 + 1; i <= end1; i ++) {
                r[i][end2] = count ++;
            }

            for (int i = end2 - 1; i >= start2; i --) {
                if (end1 > start1) {
                    r[end1][i] = count ++;
                }
            }

            for (int i = end1 - 1; i > start1; i --) {
                if (start2 < end2) {
                    r[i][start2] = count ++;
                }
            }

            start1 ++;
            end1 --;
            start2 ++;
            end2 --;
        }

        return r;
    }

    public static void main(String[] args) {
        HelixMatrix2 helixMatrix2 = new HelixMatrix2();
        System.out.println(Arrays.deepToString(helixMatrix2.generateMatrix(4)));
    }

}
