package com.konb.algorithm.day._2022._08._09;

/**
 * @author konb
 * @version 1.0
 * @date 2022-08-09 10:20
 * leetcode 1413 逐步求和得到正数的最小值
 */
public class SumStepByStepToObtainTheMinimumValue {

    public int minStartValue(int[] nums) {
        int sum = 0;
        int r = 1;

        for (int i = 0; i < nums.length; i ++) {
            sum += nums[i];
            int temp = r + sum;

            if (temp < 1) {
                r = Math.max(1 - sum, r);
            }
        }

        return r;
    }

    public static void main(String[] args) {
        SumStepByStepToObtainTheMinimumValue sumStepByStepToObtainTheMinimumValue = new SumStepByStepToObtainTheMinimumValue();
        System.out.println(sumStepByStepToObtainTheMinimumValue.minStartValue(new int[] {-3, 2, -3, 4, 2}));
    }

}
