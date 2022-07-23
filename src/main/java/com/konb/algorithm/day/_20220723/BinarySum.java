package com.konb.algorithm.day._20220723;

/**
 * @author konb
 * @version 1.0
 * @date 2022-07-23 14:58
 * leetcode 67 二进制求和
 */
public class BinarySum {

    public String addBinary(String a, String b) {

        int i = a.length() - 1;
        int j = b.length() - 1;

        int carry = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            int num = 0;
            if (i < 0 && j < 0) {
                break;
            }
            if (i >= 0 && a.charAt(i) == '1') {
                num ++;
            }
            if (j >= 0 && b.charAt(j) == '1') {
                num ++;
            }
            i --;
            j --;
            num += carry;
            carry = num / 2;
            stringBuilder.append(num % 2);
        }

        if (carry == 1) {
            stringBuilder.append(1);
        }

        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        BinarySum binarySum = new BinarySum();
        System.out.println(binarySum.addBinary("11", "1"));
    }

}
