package com.konb.algorithm.day._2022._08._01;

/**
 * @author konb
 * @version 1.0
 * @date 2022-08-01 17:40
 * leetcode 29 两数相除
 */
public class DivideTwoNumbers {

    public int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        byte flag = 0;
        if (dividend > 0) {
            dividend = -dividend;
            flag ^= 1;
        }
        if (divisor > 0) {
            divisor = -divisor;
            flag ^= 1;
        }

        int count = 0;
        while (dividend <= divisor) {
            dividend -= divisor;
            count ++;
        }

        if (flag == 0) {
            return count;
        }
        return -count;
    }

//    -2147483648
//2
    public static void main(String[] args) {
        DivideTwoNumbers divideTwoNumbers = new DivideTwoNumbers();
        System.out.println(divideTwoNumbers.divide(99, 2));
    }

}
