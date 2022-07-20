package com.konb.algorithm.greedy;

/**
 * @author konb
 * @version 1.0
 * @date 2022-06-28 17:28
 */
public class JumpGame2 {

    public int jump(int[] nums) {

        if (nums.length < 2) {
            return 0;
        }

        int step = 0;
        int count = 0;

        if (step + nums[step] >= nums.length - 1) {
            return ++count;
        }
        while (true) {
            int index = max(nums, step + 1, step + nums[step]);
            ++ count;
            if (index + nums[index] >= nums.length - 1) {
                return ++count;
            }
            step = index;
        }
    }

    public int max(int[] a, int i, int j) {
        int index = i;
        int max = 0;
        for (int k = i; k <= j; k ++) {
            int step = a[k] + k - i;
            if (step > max) {
                max = step;
                index = k;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        JumpGame2 jumpGame2 = new JumpGame2();
        System.out.println(jumpGame2.jump(new int[]{2,3,1,1,4,1,2,2,1}));
    }
}
