package com.konb.algorithm.day._2022._07._29;

import java.util.HashMap;
import java.util.Map;

/**
 * @author konb
 * @version 1.0
 * @date 2022-07-29 14:54
 * leetcode 593 有效的正方形
 */
public class ValidSquare {

    public long len = -1;

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        return cal(p1, p2, p3) && cal(p1, p2, p4) && cal(p2, p3, p4) && cal(p1, p3, p4);
    }

    public boolean cal(int[] a, int[] b, int[] c) {

        long l1 = (a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]);
        long l2 = (a[0] - c[0]) * (a[0] - c[0]) + (a[1] - c[1]) * (a[1] - c[1]);
        long l3 = (c[0] - b[0]) * (c[0] - b[0]) + (c[1] - b[1]) * (c[1] - b[1]);

        boolean ok = (l1 == l2 && l1 + l2 == l3) || (l1 == l3 && l1 + l3 == l2) || (l2 == l3 && l2 + l3 == l1);

        if (! ok) {
            return false;
        }

        if (len == -1) {
            len = Math.min(l1, l2);
        } else if (len == 0 || len != Math.min(l1, l2)) {
            return false;
        }

        return true;

    }

}
