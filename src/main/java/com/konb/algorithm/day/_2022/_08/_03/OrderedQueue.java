package com.konb.algorithm.day._2022._08._03;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author konb
 * @version 1.0
 * @date 2022-08-03 10:06
 * leetcode 899 有序队列
 */
public class OrderedQueue {

    public String orderlyQueue(String s, int k) {
        int length = s.length();

        if (k == 1) {
            String smallest = s;
            StringBuilder sb = new StringBuilder(s);
            int n = s.length();
            for (int i = 1; i < n; i++) {
                char c = sb.charAt(0);
                sb.deleteCharAt(0);
                sb.append(c);
                if (sb.toString().compareTo(smallest) < 0) {
                    smallest = sb.toString();
                }
            }
            return smallest;
        }else {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        }
    }

    public static void main(String[] args) {
        OrderedQueue orderedQueue = new OrderedQueue();
        System.out.println(orderedQueue.orderlyQueue("benb", 2));
    }

}
