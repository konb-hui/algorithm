package com.konb.algorithm.day._2022._08._26;

import java.util.Arrays;

/**
 * @author konb
 * @version 1.0
 * @date 2022-08-26 11:33
 * leetcode 1464 数组中两元素的最大乘积
 */
public class MaximumProductArray {

    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        return (nums[length - 1] - 1) * (nums[length - 2] - 1);
    }

}
