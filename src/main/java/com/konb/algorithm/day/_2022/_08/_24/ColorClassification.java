package com.konb.algorithm.day._2022._08._24;

/**
 * @author konb
 * @version 1.0
 * @date 2022-08-24 18:17
 * leetcode 75 颜色分类
 */
public class ColorClassification {

    public void sortColors(int[] nums) {
        int a = 0, b = 0, c = 0;
        for (int i = 0; i < nums.length; i ++) {
            switch (nums[i]) {
                case 0 : a ++;break;
                case 1 : b ++;break;
                case 2 : c ++;break;
                default: break;
            }
        }

        for (int i = 0; i < a; i ++) {
            nums[i] = 0;
        }
        for (int i = a; i < a + b; i ++) {
            nums[i] = 1;
        }
        for (int i = a + b; i < a + b + c; i ++) {
            nums[i] = 2;
        }
    }

}
