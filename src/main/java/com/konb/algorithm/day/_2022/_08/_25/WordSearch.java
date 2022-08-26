package com.konb.algorithm.day._2022._08._25;

import java.util.HashSet;
import java.util.Set;

/**
 * @author konb
 * @version 1.0
 * @date 2022-08-25 16:34
 * leetcode 79 单词搜索
 */
public class WordSearch {

    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int column = board[0].length;
        boolean[][] visited = new boolean[row][column];
        for (int i = 0; i < row; i ++) {
            for (int j = 0; j < column; j ++) {
                boolean r = doSome(board, new HashSet<>(), i, j, word, 0);
                if (r) {
                    return r;
                }
            }
        }

        return false;
    }

    private boolean doSome(char[][] board, Set<String> visited, int i, int j, String word, int k) {
        int row = board.length;
        int column = board[0].length;
        if (board[i][j] != word.charAt(k)) {
            return false;
        } else {

            if (visited.contains(i + "" + j)) {
                return false;
            }

            if (k == word.length() - 1) {
                return true;
            }

            visited.add(i + "" + j);
            boolean r = false;
            if (i + 1 < row) {
                r = doSome(board, new HashSet<>(visited), i + 1, j, word, k + 1);
            }
            if (i - 1 >= 0) {
                r |= doSome(board, new HashSet<>(visited), i - 1, j, word, k + 1);
            }
            if (j + 1 < column) {
                r |= doSome(board, new HashSet<>(visited), i, j + 1, word, k + 1);
            }
            if (j - 1 >= 0) {
                r |= doSome(board, new HashSet<>(visited), i, j - 1, word, k + 1);
            }

            return r;

        }
    }

}
