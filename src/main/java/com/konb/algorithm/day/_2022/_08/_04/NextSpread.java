package com.konb.algorithm.day._2022._08._04;

/**
 * @author konb
 * @version 1.0
 * @date 2022-08-04 16:40
 * leetcode 31 下一个排列
 */
public class NextSpread {

    //[1, 2, 3, 4]
    //[1, 3, 2, 4]
    //[4, 3, 2, 1]
    //[1, 3, 4, 2]
    //[2, 1, 4, 3]

    public void nextPermutation(int[] nums) {
        int length = nums.length;
        for (int i = length - 1; i > 0; i --) {
            if (nums[i - 1] < nums[i]) {
                for (int j = length - 1; j >= i; j --) {
                    if (nums[j] > nums[i - 1]) {
                        swap(nums, i - 1, j);
                        sort(nums, i, length - 1);
                        return;
                    }
                }
            }
            if (i == 1) {
                sort(nums, 0, length - 1);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void sort(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start ++;
            end --;
        }
    }

}
