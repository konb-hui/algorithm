package com.konb.algorithm.dynamic_programming;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author konb
 * @version 1.0
 * @date 2022-06-21 11:23
 */
public class BracketGenerating {

//    数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
//
//             
//
//    示例 1：
//
//    输入：n = 3
//    输出：["((()))","(()())","(())()","()(())","()()()"]
//    示例 2：
//
//    输入：n = 1
//    输出：["()"]
//             
//
//    提示：
//
//            1 <= n <= 8

    /**
     * 暴力法
     */
    public static List<String> generateParenthesis(int n) {
        List<String> combinations = new ArrayList<String>();
        //generateAll(new char[2 * n], 0, combinations);
        backtrack(combinations, new StringBuilder(), 0, 0, n);
        return combinations;
    }

    public static void generateAll(char[] current, int pos, List<String> result) {
        if (pos == current.length) {
            if (valid(current)) {
                result.add(new String(current));
            }
        } else {
            current[pos] = '(';
            generateAll(current, pos + 1, result);
            current[pos] = ')';
            generateAll(current, pos + 1, result);
        }
    }

    public static boolean valid(char[] current) {
        int balance = 0;
        for (char c: current) {
            if (c == '(') {
                ++balance;
            } else {
                --balance;
            }
            if (balance < 0) {
                return false;
            }
        }
        return balance == 0;
    }

    public static void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }
        if (open < max) {
            cur.append('(');
            backtrack(ans, cur, open + 1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close < open) {
            cur.append(')');
            backtrack(ans, cur, open, close + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }

    public static List<String> generateParenthesisDp(int n) {
        List<List<String>> dp = new ArrayList<>();
        List<String> list0 = new ArrayList<>(1);
        list0.add("");
        dp.add(list0);
        if (n < 1) {
            return dp.get(0);
        }

        List<String> list1 = new ArrayList<>(1);
        list1.add("()");
        dp.add(list1);

        for (int a = 2; a <= n; a ++) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < a; i ++) {
                for (String s1 : dp.get(i)) {
                    for (String s2 : dp.get(a - i - 1)) {
                        list.add(s1 + "(" + s2 + ")");
                    }
                }
            }
            dp.add(list);
        }
        return dp.get(n);
    }

    public static void main(String[] args) {

        int n = 20;

        long time1 = System.currentTimeMillis();
        final List<String> list1 = generateParenthesisDp(n);
        long time2 = System.currentTimeMillis();
        //System.out.println(list1.toString());
        System.out.println("花费时间：" + (time2 - time1) + "毫秒");

        long time3 = System.currentTimeMillis();
        final List<String> list2 = generateParenthesis(n);
        long time4 = System.currentTimeMillis();
        //System.out.println(list2.toString());
        System.out.println("花费时间：" + (time4 - time3) + "毫秒");
    }

}
