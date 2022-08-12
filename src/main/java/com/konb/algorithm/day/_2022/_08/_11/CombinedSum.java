package com.konb.algorithm.day._2022._08._11;

import java.util.*;

/**
 * @author konb
 * @version 1.0
 * @date 2022-08-11 17:39
 * leetcode 39 组合总和
 */
public class CombinedSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);

        if (candidates[0] > target) {
            return new ArrayList<>();
        }

        List<List<Integer>> r = new ArrayList<>();

        doSome(r, new ArrayList<>(), target, candidates, 0);
        return r;
    }

    private void doSome(List<List<Integer>> r, List<Integer> list, int target, int[] candidates, int index) {
        for (int i = index; i < candidates.length; i ++) {
            int a = candidates[i];
            if (a == target) {
                list.add(a);
                r.add(list);
                return;
            } else if (a < target) {
                List<Integer> l = new ArrayList<>(list);
                l.add(a);
                doSome(r, l, target - a, candidates, i);
            } else {
                return;
            }
        }
    }

    public static void main(String[] args) {
        CombinedSum combinedSum = new CombinedSum();
        System.out.println(combinedSum.combinationSum(new int[]{2, 3, 5}, 8));
    }

}
