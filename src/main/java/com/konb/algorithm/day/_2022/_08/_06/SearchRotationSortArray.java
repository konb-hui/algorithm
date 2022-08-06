package com.konb.algorithm.day._2022._08._06;

/**
 * @author konb
 * @version 1.0
 * @date 2022-08-06 16:36
 * leetcode 33 搜索旋转排序数组
 */
public class SearchRotationSortArray {

    public int search(int[] nums, int target) {
        if (nums[0] == target) {
            return 0;
        }

        boolean flag = nums[0] > target;

        int left = 0;
        int right = nums.length;

        while (left <= right) {
            int mid = (right + left) >> 1;
            int a = nums[mid];
            if (a == target) {
                return mid;
            }else if (a < target) {
                if (flag) {
                    left = mid;
                } else {
                    if (a < nums[0]) {
                        right = mid;
                    } else {
                        left = mid;
                    }
                }
            } else {
                if (flag) {
                    if (a < nums[0]) {
                        right = mid;
                    } else {
                        left = mid;
                    }
                } else {
                    left = mid;
                }
            }
        }

        return  -1;
    }

    public static void main(String[] args) {
        SearchRotationSortArray searchRotationSortArray = new SearchRotationSortArray();
        System.out.println(searchRotationSortArray.search(new int[] {4,5,6,7,0,1,2}, 3));
    }

}
