package com.konb.algorithm.day._2022._08._18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author konb
 * @version 1.0
 * @date 2022-08-18 10:52
 * leetcode 51 N 皇后
 */
public class NQueen {

    public List<List<String>> solveNQueens(int n) {
        int[][] map = new int[n][n];
        List<List<String>> r = new ArrayList<>();
        doSome(new int[n][n], 0, n, r, new ArrayList<>());
        return r;
    }

    private void doSome(int[][] map, int index, int n, List<List<String>> r, List<String> list) {
        for (int i = 0; i < n; i ++) {
            if (index == 0 && i == 1) {
                int x = 1;
            }
            if (map[index][i] == 0) {
                if (index == n - 1) {
                    list.add(getString(i, n));
                    r.add(list);
                    return;
                } else if (index < n - 1){
                    int[][] newMap = map.clone();
                    newMap[index][i] = 1;
                    int a = i - 1, b = i + 1, c = index + 1;
                    while (a >= 0 && c < n) {
                        newMap[c ++][a --] = -1;
                    }
                    c = index + 1;
                    while (b < n && c < n) {
                        newMap[c ++][b ++] = -1;
                    }

                    c = index + 1;
                    while (c < n) {
                        newMap[c ++][i] = -1;
                    }
                    List<String> l = new ArrayList<>(list);
                    l.add(getString(i, n));
                    doSome(newMap, index + 1, n, r, l);
                }

            }
        }
    }

    private String getString(int i, int n) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int j = 0; j < i; j ++) {
            stringBuilder.append(".");
        }
        stringBuilder.append("Q");
        for (int j = i + 1; j < n; j ++) {
            stringBuilder.append(".");
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
//        NQueen nQueen = new NQueen();
//        System.out.println(nQueen.solveNQueens(4));
        int[][] m = new int[1][1];
        int[][] a = m.clone();
        System.out.println(m[0][0]);
        a[0][0] = 1;
        System.out.println(m[0][0]);
    }
}
