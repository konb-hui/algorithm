package com.konb.algorithm.day._2022._08._10;

/**
 * @author konb
 * @version 1.0
 * @date 2022-08-10 15:40
 * leetcode 36 有效的数独
 */
public class EffectiveSudoku {

    public boolean isValidSudoku(char[][] board) {

        boolean[] row = new boolean[9];
        boolean[][] list = new boolean[9][9];
        boolean[][] square = new boolean[3][9];

        for (int i = 0; i < 9; i ++) {
            for (int j = 0; j < 9; j ++) {
                if (j == 0) {
                    row = new boolean[9];
                }
                if (j == 0 && i % 3 == 0) {
                    square = new boolean[3][9];
                }
                if (board[i][j] == '.') {
                    continue;
                }
                int a = board[i][j] - 49;
                if (row[a] || list[j][a] || square[j / 3][a]) {
                    return false;
                }
                row[a] = true;
                list[j][a] = true;
                square[j / 3][a] = true;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        EffectiveSudoku effectiveSudoku = new EffectiveSudoku();
//        String s = "[[\"5\",\"3\",\".\",\".\",\"7\",\".\",\".\",\".\",\".\"],[\"6\",\".\",\".\",\"1\",\"9\",\"5\",\".\",\".\",\".\"],[\".\",\"9\",\"8\",\".\",\".\",\".\",\".\",\"6\",\".\"],[\"8\",\".\",\".\",\".\",\"6\",\".\",\".\",\".\",\"3\"],[\"4\",\".\",\".\",\"8\",\".\",\"3\",\".\",\".\",\"1\"],[\"7\",\".\",\".\",\".\",\"2\",\".\",\".\",\".\",\"6\"],[\".\",\"6\",\".\",\".\",\".\",\".\",\"2\",\"8\",\".\"],[\".\",\".\",\".\",\"4\",\"1\",\"9\",\".\",\".\",\"5\"],[\".\",\".\",\".\",\".\",\"8\",\".\",\".\",\"7\",\"9\"]]";
//        s = s.replaceAll("\\[", "{").replaceAll("]", "}").replaceAll("\"", "'");
//        System.out.println(s);
        char[][] board = new char[][]{{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        System.out.println(effectiveSudoku.isValidSudoku(board));
    }

}
