package com.konb.algorithm.day._2022._08._01;

/**
 * @author konb
 * @version 1.0
 * @date 2022-08-01 10:41
 * leetcode 26 删除有序数组中的重复项
 */
public class RemoveDuplicatesFromAnOrderedArray {

    public int removeDuplicates(int[] nums) {

        int length = nums.length;
        if (length <= 1) {
            return length;
        }

        int count = 0, left = 0, right = 1;

        while (right < length) {
            if (nums[right] <= nums[left]) {
                count ++;
            } else if (right == left + 1) {
                left ++;
            } else {
                nums[++ left] = nums[right];
            }
            right ++;
        }

        return length - count;
    }

    public static void main(String[] args) {
        System.out.println(1024 >> 1);
    }

}
