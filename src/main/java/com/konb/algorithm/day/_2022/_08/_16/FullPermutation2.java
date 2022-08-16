package com.konb.algorithm.day._2022._08._16;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author konb
 * @version 1.0
 * @date 2022-08-16 15:07
 */
public class FullPermutation2 {
    private Set<String> set;

    public List<List<Integer>> permuteUnique(int[] nums) {
        set = new HashSet<>();
        List<List<Integer>> r = new ArrayList<>();
        doSome(r, new ArrayList<>(), nums, new ArrayList<>());
        return r;
    }

    private void doSome(List<List<Integer>> r, List<Integer> list, int[] nums, List<Integer> index) {
        for (int i = 0; i < nums.length; i ++) {
            if (! index.contains(i)) {
                List<Integer> l = new ArrayList<>(list);
                l.add(nums[i]);
                List<Integer> newIndex = new ArrayList<>(index);
                newIndex.add(i);

                if (l.size() == nums.length) {
                    String hash = myHash(l);
                    if (! set.contains(hash)) {
                        r.add(l);
                        set.add(hash);
                    }
                    return;
                } else if (list.size() < nums.length) {
                    doSome(r, l, nums, newIndex);
                }
            }
        }
    }

    private String myHash(List<Integer> list) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer i : list) {
            stringBuilder.append(i);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        FullPermutation2 fullPermutation2 = new FullPermutation2();
        System.out.println(fullPermutation2.permuteUnique(new int[]{1, 1, 2}));
    }
}
