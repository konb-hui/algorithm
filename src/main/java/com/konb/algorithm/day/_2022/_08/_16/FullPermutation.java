package com.konb.algorithm.day._2022._08._16;

import java.util.ArrayList;
import java.util.List;

/**
 * @author konb
 * @version 1.0
 * @date 2022-08-16 11:35
 * leetcode 46 全排列
 */
public class FullPermutation {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> r = new ArrayList<>();
        doSome(r, new ArrayList<>(), nums);
        return r;
    }

    private void doSome(List<List<Integer>> r, List<Integer> list, int[] nums) {
        for (int i : nums) {
            if (! list.contains(i)) {
                List<Integer> l = new ArrayList<>(list);
                l.add(i);

                if (l.size() == nums.length) {
                    r.add(l);
                    return;
                } else if (list.size() < nums.length) {
                    doSome(r, l, nums);
                }
            }
        }
    }

    public static void main(String[] args) {
        FullPermutation fullPermutation = new FullPermutation();
        System.out.println(fullPermutation.permute(new int[]{1, 2, 3}));
    }

}
