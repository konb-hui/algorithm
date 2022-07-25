package com.konb.algorithm.day._20220725;

/**
 * @author konb
 * @version 1.0
 * @date 2022-07-25 14:16
 * leetcode 65 有效数字
 */
public class SignificantFigures {

    public boolean isNumber(String s) {
        int index = -1;
        int length = s.length();
        for (int i = 0; i < length; i ++) {
            char a = s.charAt(i);
            if (a == 'e' || a == 'E') {
                if (index == -1) {
                    index = i;
                } else {
                    return false;
                }
            }
        }
        boolean r = true;

        if (index != -1) {
            r = check(s, 0, index - 1, false);
            r &= check(s, index + 1, length - 1, true);
        } else {
            r = check(s, 0, length - 1, false);
        }

        return r;

    }

    public boolean check(String s, int start, int end, boolean isInteger) {
        if (start - end > 0) {
            return false;
        }
        if (s.charAt(start) == '+' || s.charAt(start) == '-') {
            start ++;
        }

        boolean hasDot = false;
        boolean hasNum = false;

        for (int i = start; i <= end; i ++) {
            char a = s.charAt(i);
            if (a == '.') {
                if (isInteger || hasDot) {
                    return false;
                }
                hasDot = true;
            } else if (a >= '0' && a <= '9') {
                hasNum = true;
            } else {
                return false;
            }
        }
        return hasNum;
    }

    public static void main(String[] args) {
        SignificantFigures significantFigures = new SignificantFigures();
        System.out.println(significantFigures.isNumber("-.12e+3.1"));
    }

}
