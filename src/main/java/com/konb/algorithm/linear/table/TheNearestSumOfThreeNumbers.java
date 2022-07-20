package com.konb.algorithm.linear.table;

import java.util.Arrays;

/**
 * @author konb
 * @version 1.0
 * @date 2022-06-30 9:12
 * leetcode 16 最接近的三数之和
 */
public class TheNearestSumOfThreeNumbers {

    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);

        int result = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; i ++) {

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {

                int min = nums[i] + nums[left] + nums[left + 1];
                if (target <= min) {
                    if (Math.abs(min - target) < Math.abs(result - target)) {
                        result = min;
                    }
                    break;
                }

                int max = nums[i] + nums[right] + nums[right - 1];
                if (target >= max) {
                    if (Math.abs(max - target) < Math.abs(result - target)) {
                        result = max;
                    }
                    break;
                }

                int value = nums[i] + nums[left] + nums[right];

                if (value == target) {
                    return value;
                }

                if (Math.abs(value - target) < Math.abs(result - target)) {
                    result = value;
                }

                if (value < target) {
                    left ++;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left ++;
                    }
                } else {
                    right --;
                    while (left < right && nums[right] == nums[right + 1]) {
                        right --;
                    }
                }
            }

        }

        return result;

    }

    public static void main(String[] args) {
        TheNearestSumOfThreeNumbers theNearestSumOfThreeNumbers = new TheNearestSumOfThreeNumbers();
        System.out.println(theNearestSumOfThreeNumbers.threeSumClosest(new int[]{1, 1, -1, -1, 3}, 1));
    }

}
