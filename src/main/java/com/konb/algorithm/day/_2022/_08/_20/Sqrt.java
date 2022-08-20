package com.konb.algorithm.day._2022._08._20;

/**
 * @author konb
 * @version 1.0
 * @date 2022-08-20 15:03
 * leetcode 69 x 的平方根
 */
public class Sqrt {

    public int mySqrt(int x) {
        if (x < 4) {
            return Math.min(x, 1);
        }

        for (int i = 2; i < x; i ++) {
            int a = i * i;
            if (a == x) {
                return i;
            }
            if (a < x && (i + 1) * (i + 1) > x) {
                return i;
            }
        }

        return 0;
    }

}
