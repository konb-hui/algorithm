package com.konb.algorithm.day._2022._08._18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author konb
 * @version 1.0
 * @date 2022-08-18 17:47
 * leetcode 57 插入区间
 */
public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length < 1) {
            int[][] r = new int[1][2];
            r[0][0] = newInterval[0];
            r[0][1] = newInterval[1];
            return r;
        }

        List<List<Integer>> lists = new ArrayList<>();
        boolean flag = false;
        for (int i = 0; i < intervals.length; i ++) {
            List<Integer> list = new ArrayList<>();
            if (intervals[i][1] < newInterval[0] || flag) {
                list.add(intervals[i][0]);
                list.add(intervals[i][1]);
                lists.add(list);

                if (i == intervals.length - 1 && ! flag) {
                    list = new ArrayList<>();
                    list.add(newInterval[0]);
                    list.add(newInterval[1]);
                    lists.add(list);
                }
                continue;
            }
            if (newInterval[1] < intervals[i][0]) {
                list.add(newInterval[0]);
                list.add(newInterval[1]);
                lists.add(list);
                i --;
                flag = true;
                continue;
            }
            if (intervals[i][1] >= newInterval[0]) {
                list.add(Math.min(intervals[i][0], newInterval[0]));

                while (intervals[i][1] < newInterval[1]) {
                    i ++;
                    if (i >= intervals.length) {
                        list.add(newInterval[1]);
                        break;
                    }
                }
                if (i >= intervals.length) {
                    lists.add(list);
                    break;
                }
                if (intervals[i][0] > newInterval[1]) {
                    list.add(newInterval[1]);
                    i --;
                } else {
                    list.add(intervals[i][1]);
                }
                flag = true;
                lists.add(list);
            }

        }

        int[][] r = new int[lists.size()][2];
        int a = 0;
        for (List<Integer> l : lists) {
            int[] t = new int[2];
            t[0] = l.get(0);
            t[1] = l.get(1);
            r[a] = t;
            a ++;
        }

        return r;
    }

    public static void main(String[] args) {
        InsertInterval insertInterval = new InsertInterval();
        System.out.println(Arrays.deepToString(insertInterval.insert(new int[][]{{1, 5}}, new int[]{0, 0})));
    }

}
