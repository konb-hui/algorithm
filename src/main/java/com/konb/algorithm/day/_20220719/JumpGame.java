package com.konb.algorithm.day._20220719;

/**
 * @author konb
 * @version 1.0
 * @date 2022-07-19 14:37
 * leetcode 55 跳跃游戏
 */
public class JumpGame {

    public boolean canJump(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; ++i) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        JumpGame jumpGame = new JumpGame();
        System.out.println(jumpGame.canJump(new int[] {3,2,1,0,4}));
    }

}
