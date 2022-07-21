package com.konb.algorithm.day._20220721;

/**
 * @author konb
 * @version 1.0
 * @date 2022-07-21 15:12
 * leetcode 97 交错字符串
 */
public class InterlacedString {

    public boolean isInterleave(String s1, String s2, String s3) {
        int length1 = s1.length();
        int length2 = s2.length();
        int length3 = s3.length();

        if (length1 + length2 != length3) {
            return false;
        }
        boolean[] dp = new boolean[length2 + 1];
        dp[0] = true;
        for (int i = 0; i <= length1; i ++) {
            for (int j = 0; j <= length2; j ++) {
                int k = i + j - 1;
                if (i > 0) {
                    dp[j] = dp[j] && s1.charAt(i - 1) == s3.charAt(k);
                }
                if (j > 0) {
                    dp[j] = dp[j] || (dp[j - 1] && s2.charAt(j - 1) == s3.charAt(k));
                }
            }
        }
        return dp[length2];
    }

    public boolean isInterleave(String s1, String s2, String s3, int index1, int index2, int index3) {
        if (index1 == -1 &&index2 == -1 && index3 == -1) {
            return true;
        } else if (index3 == -1 && (index1 >= 0 || index2 >= 0)) {
            return false;
        }

        boolean r = false;
        if (index1 >= 0 && s1.charAt(index1) == s3.charAt(index3)) {
            r = isInterleave(s1, s2, s3, index1 - 1, index2, index3 - 1);
        }
        if (!r && index2 >= 0 && s2.charAt(index2) == s3.charAt(index3)) {
            r = isInterleave(s1, s2, s3, index1, index2 - 1, index3 - 1);
        }

        return r;
    }

    public static void main(String[] args) {
        InterlacedString interlacedString = new InterlacedString();
        System.out.println(interlacedString.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
    }

}
