package com.konb.algorithm.day._20220726;

/**
 * @author konb
 * @version 1.0
 * @date 2022-07-26 16:11
 * leetcode 72 编辑距离
 */
public class EditDistance {

    public int minDistance(String word1, String word2) {
        int length1 = word1.length();
        int length2 = word2.length();

        int[][] dp = new int[length1 + 1][length2 + 1];

        dp[0][0] = 0;

        for (int i = 1; i <= length1; i ++) {
            dp[i][0] = i;
        }

        for (int i = 1; i <= length2; i ++) {
            dp[0][i] = i;
        }

        for (int i = 0; i < length1; i ++) {
            for (int j = 0; j < length2; j ++) {
                char a = word1.charAt(i);
                char b = word2.charAt(j);

                if (a == b) {
                    dp[i + 1][j + 1] = dp[i][j];
                } else {
                    dp[i + 1][j + 1] = Math.min(Math.min(dp[i][j + 1], dp[i + 1][j]), dp[i][j]) + 1;
                }

                out(word1, word2, dp);
            }
        }

        return dp[length1][length2];
    }

    private void out(String a, String b, int[][] dp) {
        System.out.println("-----------------------------------------------------------");
        for (int i = a.length() - 1; i >= 0; i --) {
            System.out.print(a.charAt(i) + "   ");
            for (int j = 0; j <= b.length(); j ++) {
                System.out.print((dp[i + 1][j] < 10 ? "0" + dp[i + 1][j] : dp[i + 1][j]) + "   ");
            }
            System.out.println();
        }

        System.out.print("0" + "   ");
        for (int j = 0; j <= b.length(); j ++) {
            System.out.print((dp[0][j] < 10 ? "0" + dp[0][j] : dp[0][j]) + "   ");
        }
        System.out.println();

        System.out.print("/" + "   ");
        System.out.print("00" + "   ");
        for (int i = 0; i < b.length(); i ++) {
            System.out.print(b.charAt(i) + "0   ");
        }
        System.out.println();
    }


//    "zoologicoarchaeologist"
//            "zoogeologist"
    public static void main(String[] args) {
        EditDistance distance = new EditDistance();
        System.out.println(distance.minDistance("zoologicoarchaeologist", "zoogeologist"));
    }

}
