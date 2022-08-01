package com.konb.algorithm.day._2022._08._01;

/**
 * @author konb
 * @version 1.0
 * @date 2022-08-01 11:22
 * leetcode 1374 生成每种字符都是奇数个的字符串
 */
public class MyGenerateTheString {

    public String generateTheString(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        boolean flag = false;
        if (n % 2 == 0) {
            n --;
            flag = true;
        }

        for (int i = 0; i < n; i ++) {
            stringBuilder.append("a");
        }

        if (flag) {
            stringBuilder.append("b");
        }

        return stringBuilder.toString();
    }
}
