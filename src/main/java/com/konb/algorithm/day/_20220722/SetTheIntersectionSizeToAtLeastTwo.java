package com.konb.algorithm.day._20220722;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * @author konb
 * @version 1.0
 * @date 2022-07-22 11:35
 * leetcode 757 设置交集大小至少为2
 * 1 3 1 4 2 5 3 5
 */
public class SetTheIntersectionSizeToAtLeastTwo {

    public int intersectionSizeTwo(int[][] ins) {
        Arrays.sort(ins, (a, b)->{
            return a[1] != b[1] ? a[1] - b[1] : b[0] - a[0];
        });
        int a = -1, b = -1, ans = 0;
        for (int[] i : ins) {
            if (i[0] > b) {
                a = i[1] - 1; b = i[1];
                ans += 2;
            } else if (i[0] > a) {
                a = b; b = i[1];
                ans++;
            }
        }
        return ans;
    }

}
