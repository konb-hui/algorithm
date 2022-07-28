package com.konb.algorithm.day._20220728;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author konb
 * @version 1.0
 * @date 2022-07-28 15:15
 * leetcode 18 四数之和
 */
public class SumOfFourNumbers {

    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> list = new ArrayList<>();
        int length = nums.length;
        Arrays.sort(nums);

        if (length < 4) {
            return list;
        }

        for (int i = 0; i < length - 3;i ++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < length - 2; j ++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int left = j + 1;
                int right = length - 1;

                while (left < right) {
                    long num = (long)nums[i] + (long)nums[j] + (long)nums[left] + (long)nums[right];

                    if (num > target) {
                        right --;
                    } else if (num < target) {
                        left ++;
                    } else {
                        list.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        while (left < right && nums[left] == nums[left + 1]) {
                            left ++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right --;
                        }

                        left ++;
                        right --;
                    }
                }

            }
        }

        return list;

    }

//    [-2,-1,-1,1,1,2,2]
//            0

    public static void main(String[] args) {
        SumOfFourNumbers sumOfFourNumbers = new SumOfFourNumbers();
        System.out.println(sumOfFourNumbers.fourSum(new int[] {-2,-1,-1,1,1,2,2}, 0));
    }

}
