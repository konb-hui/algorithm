package com.konb.algorithm.day._2022._08._18;

import java.util.*;

/**
 * @author konb
 * @version 1.0
 * @date 2022-08-18 16:33
 * leetcode 56 合并区间
 */
public class ConsolidationInterval {

    public int[][] merge(int[][] intervals) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        int length = intervals.length;
        for (int i = 0; i < length; i ++) {
            treeMap.put(intervals[i][0], treeMap.getOrDefault(intervals[i][0], 0) + 1);
            treeMap.put(intervals[i][1], treeMap.getOrDefault(intervals[i][1], 0) - 1);
        }

        List<List<Integer>> r = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        int sum = 0;
        int[] temp = new int[2];
        for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if (sum == 0 && value > 0) {
                list = new ArrayList<>();
                list.add(key);
            } else if (sum + value == 0 && value < 0) {
                list.add(key);
                r.add(list);
            } else if (sum == 0 && value == 0) {
                list = new ArrayList<>();
                list.add(key);
                list.add(key);
                r.add(list);
            }
            sum += value;
        }

        int[][] ans = new int[r.size()][2];
        for (int i = 0; i < r.size(); i ++) {
            ans[i][0] = r.get(i).get(0);
            ans[i][1] = r.get(i).get(1);
        }

        return ans;
    }

    public static void main(String[] args) {
        ConsolidationInterval consolidationInterval = new ConsolidationInterval();
        System.out.println(Arrays.deepToString(consolidationInterval.merge(new int[][]{{1, 4}, {4, 5}})));
    }

}
