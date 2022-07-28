package com.konb.algorithm.day._20220728;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author konb
 * @version 1.0
 * @date 2022-07-28 10:51
 * leetcode 1331 数组序号转换
 */
public class ArraySequenceNumberConversion {

    public int[] arrayRankTransform(int[] arr) {

        int[] a = Arrays.copyOf(arr, arr.length);

        Arrays.sort(a);

        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int value : a) {
            Integer b = map.get(value);
            if (b == null) {
                map.put(value, ++count);
            }
        }

        for (int i = 0; i < arr.length; i ++) {
            a[i] = map.get(arr[i]);
        }

        return a;

    }

}
