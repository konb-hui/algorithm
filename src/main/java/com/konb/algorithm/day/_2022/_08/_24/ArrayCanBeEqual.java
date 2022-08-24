package com.konb.algorithm.day._2022._08._24;

import java.util.HashMap;
import java.util.Map;

/**
 * @author konb
 * @version 1.0
 * @date 2022-08-24 11:11
 * leetcode 1460 通过翻转子数组使两个数组相等
 */
public class ArrayCanBeEqual {

    public boolean canBeEqual(int[] target, int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < target.length; i ++) {
            map.put(target[i], map.getOrDefault(target[i], 0) + 1);
        }

        for (int i = 0; i < arr.length; i ++) {
            int a = arr[i];
            Integer num = map.get(a);
            if (num == null) {
                return false;
            }
            if (num == 1) {
                map.remove(a);
            } else {
                map.put(a, num - 1);
            }
        }

        return map.size() == 0;
    }

}
