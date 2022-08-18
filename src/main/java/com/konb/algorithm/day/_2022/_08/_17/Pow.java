package com.konb.algorithm.day._2022._08._17;

/**
 * @author konb
 * @version 1.0
 * @date 2022-08-17 14:07
 */
public class Pow {

    public double myPow(double x, int n) {
        return n < 0 ? 1.0 / f(x, -n) : f(x, n);
    }

    private double f(double x, int n) {
        if (n == 0) {
            return 1.0;
        }

        double s = f(x, n / 2);
        return n % 2 == 0 ? s * s : s * s * x;
    }

}
