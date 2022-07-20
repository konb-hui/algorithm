package com.konb.algorithm.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @author konb
 * @version 1.0
 * @date 2022-06-07 15:03
 *
 * hash表-两数之和
 */
public class TwoNumSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> cache = new HashMap<>();
        int[] result = new int[2];

        for (int i = 0; i < nums.length; i ++) {
            int a = target - nums[i];
            if (cache.containsKey(a)) {
                result[0] = cache.get(a);
                result[1] = i;
            } else {
                cache.put(nums[i], i);
            }
        }

        return result;
    }

}
