package com.konb.algorithm.day._20220718;

/**
 * @author konb
 * @version 1.0
 * @date 2022-07-18 14:34
 * leetcode 53 最大子数组和
 */
public class MaximumSubarraySum {

    public int maxSubArray(int[] nums) {
        int pre = 0;
        int max = nums[0];
        for (int x : nums) {
            pre = Math.max(x, pre + x);
            max = Math.max(pre, max);
        }

        return max;
    }

    public static void main(String[] args) {
        MaximumSubarraySum maximumSubarraySum = new MaximumSubarraySum();
        System.out.println(maximumSubarraySum.maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
    }

}
