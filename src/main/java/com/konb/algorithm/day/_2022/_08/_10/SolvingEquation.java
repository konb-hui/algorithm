package com.konb.algorithm.day._2022._08._10;

/**
 * @author konb
 * @version 1.0
 * @date 2022-08-10 18:07
 * leetcode 640 求解方程
 */
public class SolvingEquation {

    public String solveEquation(String s) {
        int x = 0, num = 0, n = s.length();
        char[] cs = s.toCharArray();
        for (int i = 0, op = 1; i < n; ) {
            if (cs[i] == '+') {
                op = 1; i++;
            } else if (cs[i] == '-') {
                op = -1; i++;
            } else if (cs[i] == '=') {
                x *= -1; num *= -1; op = 1; i++;
            } else {
                int j = i;
                while (j < n && cs[j] != '+' && cs[j] != '-' && cs[j] != '=') j++;
                if (cs[j - 1] == 'x') x += (i < j - 1 ? Integer.parseInt(s.substring(i, j - 1)) : 1) * op;
                else num += Integer.parseInt(s.substring(i, j)) * op;
                i = j;
            }
        }
        if (x == 0) return num == 0 ? "Infinite solutions" : "No solution";
        else return "x=" + (num / -x);
    }

}
