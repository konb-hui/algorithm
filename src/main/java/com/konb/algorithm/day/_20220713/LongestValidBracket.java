package com.konb.algorithm.day._20220713;

import java.util.Stack;

/**
 * @author konb
 * @version 1.0
 * @date 2022-07-13 17:05
 * leetcode 32 最长有效括号
 */
public class LongestValidBracket {

    public int longestValidParentheses(String s) {
        int max = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i ++) {
            char a = s.charAt(i);
            char b = s.charAt(i - 1);
            if (a == ')') {
                if (b == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                }
                else if (i -dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    int index = i - dp[i - 1] - 2;
                    dp[i] = (index >= 0 ? dp[index] : 0)+ dp[i - 1] + 2;
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public int longestValidParenthesesByStack(String s) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        stack.push(-1);

        for (int i = 0; i < s.length(); i ++) {
            if (s.charAt(i) == ')') {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                    continue;
                }
                max = Math.max(max, i - stack.peek());
                continue;
            }
            stack.push(i);
        }

        return max;
    }

    public int longestValidParentheses2(String s) {
        int left = 0;
        int right = 0;
        int max = 0;

        for (int i = 0;i < s.length(); i ++) {
            if (s.charAt(i) == '(') {
                left ++;
            }else {
                right ++;
            }
            if (left < right) {
                left = 0;
                right = 0;
                continue;
            }
            if (left == right) {
                max = Math.max(max, left * 2);
                left = 0;
                right = 0;
            }
        }

        left = 0;
        right = 0;

        for (int i = s.length() - 1;i >= 0; i --) {
            if (s.charAt(i) == '(') {
                left ++;
            }else {
                right ++;
            }
            if (left > right) {
                left = 0;
                right = 0;
                continue;
            }
            if (left == right) {
                max = Math.max(max, left * 2);
                left = 0;
                right = 0;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        LongestValidBracket longestValidBracket = new LongestValidBracket();
        System.out.println(longestValidBracket.longestValidParentheses2("))()"));
        //i = 4
    }

}
