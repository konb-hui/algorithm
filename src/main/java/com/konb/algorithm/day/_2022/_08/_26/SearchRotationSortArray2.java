package com.konb.algorithm.day._2022._08._26;

/**
 * @author konb
 * @version 1.0
 * @date 2022-08-26 14:31
 * leetcode 81 搜索旋转排序数组 II
 */
public class SearchRotationSortArray2 {

    public boolean search(int[] nums, int target) {
        int length = nums.length;
        if (nums[0] > target && nums[length - 1] < target) {
            return false;
        }

        int left = 0, right = length - 1;
        boolean flag = target >= nums[0];
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] < target) {
                if (flag) {
                    if (nums[mid] <= nums[length - 1]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] > target) {
                if (flag) {
                    right = mid - 1;
                } else {
                    if (nums[mid] <= nums[length - 1]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        SearchRotationSortArray2 searchRotationSortArray2 = new SearchRotationSortArray2();
        System.out.println(searchRotationSortArray2.search(new int[] {1, 0, 1, 1, 1}, 0));
    }

}
