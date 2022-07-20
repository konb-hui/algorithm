package com.konb.algorithm.day._20220719;

import java.util.*;

/**
 * @author konb
 * @version 1.0
 * @date 2022-07-19 11:17
 * leetcode 731 我的日程安排表 II
 */
public class MySchedule2 {

    Map<Integer, int[]> tree;

    public MySchedule2() {
        tree = new HashMap<Integer, int[]>();
    }

    public boolean book(int start, int end) {
        update(start, end - 1, 1, 0, 1000000000, 1);
        tree.putIfAbsent(1, new int[2]);
        if (tree.get(1)[0] > 2) {
            update(start, end - 1, -1, 0, 1000000000, 1);
            return false;
        }
        return true;
    }

    public void update(int start, int end, int val, int l, int r, int idx) {
        if (r < start || end < l) {
            return;
        }
        tree.putIfAbsent(idx, new int[2]);
        if (start <= l && r <= end) {
            tree.get(idx)[0] += val;
            tree.get(idx)[1] += val;
        } else {
            int mid = (l + r) >> 1;
            update(start, end, val, l, mid, 2 * idx);
            update(start, end, val, mid + 1, r, 2 * idx + 1);
            tree.putIfAbsent(2 * idx, new int[2]);
            tree.putIfAbsent(2 * idx + 1, new int[2]);
            tree.get(idx)[0] = tree.get(idx)[1] + Math.max(tree.get(2 * idx)[0], tree.get(2 * idx + 1)[0]);
        }
    }

    public static void main(String[] args) {
        MySchedule2 mySchedule2 = new MySchedule2();
        System.out.println(mySchedule2.book(10, 20));
        System.out.println(mySchedule2.book(50, 60));
        System.out.println(mySchedule2.book(10, 40));
        System.out.println(mySchedule2.book(5, 15));
        System.out.println(mySchedule2.book(5, 10));
        System.out.println(mySchedule2.book(25, 55));
    }

}
