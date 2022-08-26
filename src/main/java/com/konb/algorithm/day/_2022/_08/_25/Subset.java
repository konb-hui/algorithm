package com.konb.algorithm.day._2022._08._25;

import java.util.ArrayList;
import java.util.List;

/**
 * @author konb
 * @version 1.0
 * @date 2022-08-25 15:20
 * leetcode 78 子集
 */
public class Subset {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> r = new ArrayList<>();
        r.add(new ArrayList<>());
        for (int num : nums) {
            List<List<Integer>> temp = new ArrayList<>();
            for (List<Integer> list : r) {
                List<Integer> l = new ArrayList<>(list);
                l.add(num);
                temp.add(l);
            }
            r.addAll(temp);
        }

        return r;
    }

}
