package com.konb.algorithm.dynamic_programming;

/**
 * @author konb
 * @version 1.0
 * @date 2022-06-07 9:41
 *
 * 动态规划-01背包问题
 */
public class Bag01 {

    public static int dynamicProgramming(int[] weight, int[] value, int size) {

        int weightLength = weight.length;
        int valueLength = value.length;
        int[] dp = new int[size + 1];

        //初始化dp,即dp[0][i],其他都为0
        for (int i = 1; i <= size; i ++) {
            if (weight[0] > i) {
                continue;
            }
            dp[i] = value[0];
        }

        //动态规划
        for (int i = 1; i < weightLength; i ++) {
            for (int j = 0; j <= size; j ++) {
                if(j >= weight[i]) dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }


        return dp[size];
    }

    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int size = 4;

        System.out.println(dynamicProgramming(weight, value, size));
    }

}
