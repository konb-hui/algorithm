package com.konb.algorithm.day._2022._08._04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author konb
 * @version 1.0
 * @date 2022-08-04 11:06
 * leetcode 1403 非递增顺序的最小子序列
 */
public class MinimalSubsequenceOfNonIncreasingOrder {


//    输入：nums = [4,3,10,9,8]
//    输出：[10,9]

    public List<Integer> minSubsequence(int[] nums) {
        int num = 0;
        for (int i : nums) {
            num += i;
        }
        int half = num >> 1;
        List<Integer> list = new ArrayList<>();
        int n = 0;

        Arrays.sort(nums);

        for (int j = nums.length - 1; j >= 0; j --) {
            n += nums[j];
            if (n > half) {
                list.add(nums[j]);
                break;
            }
            list.add(nums[j]);
        }

        return list;
    }

}
