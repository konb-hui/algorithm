package com.konb.algorithm.day._2022._08._25;

import java.util.ArrayList;
import java.util.List;

/**
 * @author konb
 * @version 1.0
 * @date 2022-08-25 11:36
 * leetcode 77 组合
 */
public class Combination {

    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> r = new ArrayList<>();
        doSome(r, 1, n, new ArrayList<>(), k);

        return r;
    }

    private void doSome(List<List<Integer>> r, int start, int end, List<Integer> list, int k) {
        for (int i = start; i <= end; i ++) {
            List<Integer> l = new ArrayList<>(list);
            l.add(i);
            if (l.size() == k) {
                r.add(l);
            } else if (l.size() < k) {
                doSome(r, i + 1, end, l, k);
            }
        }
    }

    public static void main(String[] args) {
        Combination combination = new Combination();
        System.out.println(combination.combine(4, 3));
    }

}
