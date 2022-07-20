package com.konb.algorithm.linear.table;

/**
 * @author konb
 * @version 1.0
 * @date 2022-06-30 10:07
 * leetcode 27 移除元素
 */
public class RemovingElements {

    public int removeElement(int[] nums, int val) {

        int length = nums.length;
        int count = length;
        int left = 0;
        int right = length - 1;

        if (length == 0) {
            return 0;
        }

        while (left <= right) {
            while (left <= right && nums[left] != val) {
                left ++;
            }
            while (left <= right && nums[right] == val) {
                right --;
                count --;
            }
            if (left <= right) {
                nums[left] = nums[right];
                right --;
                left ++;
                count --;
            }

        }

        return count;

    }

}
