package com.konb.algorithm.day._20220719;

import java.util.ArrayList;
import java.util.List;

/**
 * @author konb
 * @version 1.0
 * @date 2022-07-19 16:15
 * leetcode 91 解码方式
 */
public class DecodingMethod {

    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];

        dp[0] = 0;

        if (s.charAt(0) == '0') {
            dp[1] = 0;
        } else {
            dp[1] = 1;
        }

        for (int i = 1; i < n; i ++) {
            int num = 0;
            char a = s.charAt(i);
            char b = s.charAt(i - 1);
            if (a != '0') {
                num += dp[i];
            }
            if (b != '0') {
                if (b == '1' || (b == '2' && a <= '6')) {
                    num += i - 1 == 0 ? 1 : dp[i - 1];
                }
            }
            dp[i + 1] = num;
        }

        return dp[n];
    }

    public static void main(String[] args) {
        DecodingMethod decodingMethod = new DecodingMethod();
        System.out.println(decodingMethod.numDecodings("226"));
    }

}
