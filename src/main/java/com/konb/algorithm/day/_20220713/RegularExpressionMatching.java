package com.konb.algorithm.day._20220713;

/**
 * @author konb
 * @version 1.0
 * @date 2022-07-13 14:30
 * leetcode 10 正则表达式匹配
 */
public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        if (".*".equals(p)) {
            return true;
        }
        int length1 = s.length();
        int length2 = p.length();
        boolean[][] dp = new boolean[length1 + 1][length2 + 1];
        dp[0][0] = true;

        for (int i = 0; i <= length1; i ++) {
            for (int j = 1; j <= length2; j ++) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2];
                    if (match(s, p, i, j - 1)){
                        dp[i][j] = dp[i - 1][j] || dp[i][j];
                    }
                } else {
                    if (match(s, p, i, j)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }
        return dp[length1][length2];
    }

    public boolean match(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        return p.charAt(j - 1) == '.' || s.charAt(i - 1) == p.charAt(j - 1);
    }

    public static void main(String[] args) {
        RegularExpressionMatching regularExpressionMatching = new RegularExpressionMatching();
        System.out.println(regularExpressionMatching.isMatch("aab", "c*a*b*"));
    }
}
