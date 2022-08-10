package com.konb.algorithm.day._2022._08._09;

/**
 * @author konb
 * @version 1.0
 * @date 2022-08-09 11:23
 * leetcode 35 搜索插入位置
 */
public class SearchInsertLocation {

    public int searchInsert(int[] nums, int target) {
        int length = nums.length;

        int left = 0;
        int right = length - 1;

        while (left <= right) {

            int mid = (left + right) >> 1;
            int a = nums[mid];

            if (a == target) {
                return mid;
            }

            if (a > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }

        return right + 1;
    }

    public static void main(String[] args) {
        SearchInsertLocation searchInsertLocation = new SearchInsertLocation();
        System.out.println(searchInsertLocation.searchInsert(new int[]{3, 5, 7, 9, 10}, 8));
    }

}
