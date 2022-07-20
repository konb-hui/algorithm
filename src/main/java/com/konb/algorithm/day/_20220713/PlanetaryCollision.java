package com.konb.algorithm.day._20220713;

import java.util.Stack;

/**
 * @author konb
 * @version 1.0
 * @date 2022-07-13 9:06
 * leetcode 735 行星碰撞
 */
public class PlanetaryCollision {

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while (i < asteroids.length) {
            //如果栈是空的，直接入栈
            if (stack.isEmpty()) {
                stack.push(asteroids[i ++]);
                continue;
            }
            //获取栈顶元素
            int a = stack.peek();
            //获取当前遍历的数组元素
            int b = asteroids[i];
            //如果栈顶元素小于0，往左运动，不管下一位是往左还是往右都碰不到，直接入栈
            if (a < 0) {
                stack.push(b);
                i ++;
                continue;
            }
            //如果栈顶元素大于0，往右移分情况讨论
            if (a > 0) {
                //如果当前数组元素也大于0，则直接入栈
                if (b > 0) {
                    stack.push(b);
                    i ++;
                    continue;
                }
                //如果当前数组元素小于0
                if (b < 0) {
                    int num = a + b;
                    //和小于0，栈顶出栈，并且继续和下一个栈顶元素比较
                    if (num < 0) {
                        stack.pop();
                        continue;
                    }
                    //如果和大于0，则
                    if (num > 0) {
                        i ++;
                        continue;
                    }
                    //如果和等于0，则
                    stack.pop();
                    i ++;
                }
            }
        }
        int[] r = new int[stack.size()];
        for (int j = r.length - 1; j >= 0; j --) {
            r[j] = stack.pop();
        }
        return r;
    }

    public static void main(String[] args) {
        PlanetaryCollision planetaryCollision = new PlanetaryCollision();
        int[] a = planetaryCollision.asteroidCollision(new int[]{10, 2, -5});
    }

}
