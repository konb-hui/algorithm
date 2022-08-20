package com.konb.algorithm.day._2022._08._20;

import java.util.Arrays;

/**
 * @author konb
 * @version 1.0
 * @date 2022-08-20 14:46
 * leetcode 66 加一
 */
public class AddOne {

    public int[] plusOne(int[] digits) {
        int length = digits.length;
        for (int i = length - 1; i >= 0; i --) {
            int sum = digits[i] + 1;
            if (sum == 10) {
                if (i == 0) {
                    int[] r = new int[length + 1];
                    r[0] = 1;
                    return r;
                }
                digits[i] = 0;
            } else {
                digits[i] ++;
                return digits;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        AddOne addOne = new AddOne();
        System.out.println(Arrays.toString(addOne.plusOne(new int[]{1, 9, 9})));
    }

}
