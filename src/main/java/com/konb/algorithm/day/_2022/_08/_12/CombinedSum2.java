package com.konb.algorithm.day._2022._08._12;

import java.util.*;

/**
 * @author konb
 * @version 1.0
 * @date 2022-08-12 16:42
 * leetcode 40 组合总和 II
 */
public class CombinedSum2 {

    private Set<String> set;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        if (candidates[0] > target) {
            return new ArrayList<>();
        }

        set = new HashSet<>();
        List<List<Integer>> r = new ArrayList<>();
        doSome(r, new ArrayList<>(), 0, candidates, 0, target);
        return r;
    }

    private void doSome(List<List<Integer>> r, List<Integer> list, int index, int[] candidates, int sum, int target) {
        for (int i = index; i < candidates.length; i ++) {
            int a = candidates[i];
            int newSum = sum + a;
            if (newSum == target) {
                List<Integer> l = new ArrayList<>(list);
                l.add(a);
                String hash = myHash(l);
                if (! set.contains(hash)) {
                    r.add(l);
                    set.add(hash);
                }
                return;
            }
            if (newSum > target) {
                return;
            }
            List<Integer> l = new ArrayList<>(list);
            l.add(a);
            doSome(r, l, i + 1, candidates, newSum, target);
        }
    }

    private String myHash(List<Integer> list) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer i : list) {
            stringBuilder.append(i);
        }

        return stringBuilder.toString();
    }

}
