package com.konb.algorithm.linear;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author konb
 * @version 1.0
 * @date 2022-06-30 14:28
 * leetcode 732 我的日程安排表 III
 */
public class MyCalendarThree {

    private TreeMap<Integer, Integer> cnt;

    public MyCalendarThree() {
        cnt = new TreeMap<>();
    }

    public int book(int start, int end) {
        int r = 0;
        int num = 0;
        cnt.put(start, cnt.getOrDefault(start, 0) + 1);
        cnt.put(end, cnt.getOrDefault(end, 0) - 1);

        for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
            num += entry.getValue();
            r = Math.max(r, num);
        }

        return r;
    }

    public static void main(String[] args) {
        MyCalendarThree myCalendarThree = new MyCalendarThree();

        System.out.println(myCalendarThree.book(10, 30));
    }

}
