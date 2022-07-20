package com.konb.algorithm.day._20220715;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author konb
 * @version 1.0
 * @date 2022-07-15 16:15
 * leetcode 42 接雨水
 */
public class ConnectRainwater {

    //动态规划
    public int trap(int[] height) {
        int length = height.length;

        if (length < 3) {
            return 0;
        }

        int[] leftMax = new int[length];
        int[] rightMax = new int[length];

        leftMax[0] = height[0];
        rightMax[length - 1] = height[length - 1];

        for (int i = 1; i < length; i ++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        for (int i = length - 2; i >= 0; i --) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int max = 0;
        for (int i = 1; i < length - 1; i ++) {
            max = max + (Math.min(leftMax[i], rightMax[i]) - height[i]);
        }

        return max;
    }

    //单调栈
    public int trapByStack(int[] height) {
        Deque<Integer> stack = new LinkedList<>();

        int max = 0;

        for (int i = 0; i < height.length; i ++) {
            while (! stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }

                int left = stack.peek();
                int width = i - left - 1;
                int h = Math.min(height[left], height[i]) - height[top];
                max += width * h;
            }
            stack.push(i);
        }
        return max;
    }

    //双指针
    public int trapTwoPoint(int[] height) {
        int max = 0;
        int length = height.length;
        int leftMax = height[0];
        int rightMax = height[length - 1];

        int i = 0;
        int j = length - 1;

        while (i < j) {
            if (leftMax < rightMax) {
                i ++;
                int left = height[i];
                if (left < leftMax) {
                    max += leftMax - left;
                } else {
                    leftMax = left;
                }
            } else {
                j --;
                int right = height[j];
                if (right < rightMax) {
                    max += rightMax - right;
                } else {
                    rightMax = right;
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        ConnectRainwater connectRainwater = new ConnectRainwater();

        System.out.println(connectRainwater.trapTwoPoint(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));
    }

}
