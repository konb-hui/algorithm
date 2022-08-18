package com.konb.algorithm.day._2022._08._18;

import java.util.ArrayList;
import java.util.List;

/**
 * @author konb
 * @version 1.0
 * @date 2022-08-18 15:27
 * leetcode 54 螺旋矩阵
 */
public class HelixMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        int start1 = 0;
        int end1 = matrix.length - 1;
        int start2 = 0;
        int end2 = matrix[0].length - 1;
        List<Integer> r = new ArrayList<>();

        while (start1 <= end1 && start2 <= end2) {
            for (int i = start2; i <= end2; i ++) {
                r.add(matrix[start1][i]);
            }

            for (int i = start1 + 1; i <= end1; i ++) {
                r.add(matrix[i][end2]);
            }

            for (int i = end2 - 1; i >= start2; i --) {
                if (end1 > start1) {
                    r.add(matrix[end1][i]);
                }
            }

            for (int i = end1 - 1; i > start1; i --) {
                if (start2 < end2) {
                    r.add(matrix[i][start2]);
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
        HelixMatrix helixMatrix = new HelixMatrix();
        System.out.println(helixMatrix.spiralOrder(new int[][] {{7}, {9}, {6}}));
    }

}
