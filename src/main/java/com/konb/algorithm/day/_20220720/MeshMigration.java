package com.konb.algorithm.day._20220720;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author konb
 * @version 1.0
 * @date 2022-07-20 9:32
 * leetcode 1260 二维网格迁移
 */
public class MeshMigration {

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int all = n * m;

        int step = k % all;
        int[][] temp = new int[n][m];
        if (step == 0) {
            return arrayToList(grid);
        } else {
            for (int i = 0; i < n; i ++) {
                for (int j = 0; j < m; j ++) {
                    int l = i * m + j + step;
                    l = l >= all ? l - all : l;
                    temp[l / m][l % m] = grid[i][j];
                }
            }
            return arrayToList(temp);
         }
    }

    public List<List<Integer>> arrayToList(int[][] arrays) {
        List<List<Integer>> result = new ArrayList<>();
        for (int[] arr : arrays) {
            List<Integer> list = new ArrayList<>();
            for (int a : arr) {
                list.add(a);
            }
            result.add(list);
        }
        return result;
    }

    public static void main(String[] args) {
        MeshMigration meshMigration = new MeshMigration();
        final List<List<Integer>> lists = meshMigration.shiftGrid(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 2);
        System.out.println(lists.toString());
    }

}
