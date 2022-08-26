package com.konb.algorithm.day._2022._08._26;

import java.util.Arrays;

/**
 * @author konb
 * @version 1.0
 * @date 2022-08-26 13:52
 * leetcode 80 删除有序数组中的重复项 II
 */
public class DeleteDuplicateItems2 {

    public int removeDuplicates(int[] nums) {
        int v = nums[0], count = 1, last = nums.length - 1, r = 1;
        for (int i = 1; i <= last; i ++) {
            r ++;
            if (v == nums[i]) {
                count ++;
            } else {
                v = nums[i];
                count = 1;
            }

            if (count > 2) {
                move(nums, i, last);
                last --;
                i --;
                count --;
                r --;
            }
        }
        System.out.println(Arrays.toString(nums));
        return r;
    }

    private void move(int[] arr, int first, int last) {
        int v = arr[first];
        if (last - 1 - first >= 0) {
            System.arraycopy(arr, first + 1, arr, first, last - first);
        }
        arr[last] = v;
    }

    public static void main(String[] args) {
        DeleteDuplicateItems2 deleteDuplicateItems2 = new DeleteDuplicateItems2();
        System.out.println(deleteDuplicateItems2.removeDuplicates(new int[] {0, 0, 1, 1, 1, 1, 2, 3}));
    }

}
