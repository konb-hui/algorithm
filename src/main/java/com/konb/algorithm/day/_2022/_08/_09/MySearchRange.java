package com.konb.algorithm.day._2022._08._09;

/**
 * @author konb
 * @version 1.0
 * @date 2022-08-09 11:06
 * leetcode 34 在排序数组中查找元素的第一个和最后一个位置
 */
public class MySearchRange {

    public int[] searchRange(int[] nums, int target) {
        int[] r = new int[2];
        r[0] = -1;
        r[1] = -1;

        int left = 0;
        int right = nums.length - 1;

        int length = nums.length;

        while (left <= right) {
            int mid = (left + right) >> 1;
            int a = nums[mid];

            if (a == target) {
                r[0] = mid;
                r[1] = mid;

                while (r[0] - 1 >= 0 && nums[r[0] - 1] == target) {
                    r[0] --;
                }

                while (r[1] + 1 < length && nums[r[1] + 1] == target) {
                    r[1] ++;
                }
                break;
            }
            if (a < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return r;
    }

    public static void main(String[] args) {
        MySearchRange mySearchRange = new MySearchRange();
        System.out.println(mySearchRange.searchRange(new int[]{1, 1, 2}, 1));
    }

}
