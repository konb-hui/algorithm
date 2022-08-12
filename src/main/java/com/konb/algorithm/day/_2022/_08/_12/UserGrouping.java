package com.konb.algorithm.day._2022._08._12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author konb
 * @version 1.0
 * @date 2022-08-12 14:53
 * leetcode 1280 用户分组
 */
public class UserGrouping {

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> lists = new ArrayList<>();

        for (int i = 0; i < groupSizes.length; i ++) {
            int a = groupSizes[i];
            List<Integer> list = map.get(a);
            if (list == null) {
                List<Integer> l = new ArrayList<>();
                l.add(i);
                map.put(a, l);

                if (l.size() == a) {
                    lists.add(l);
                    map.put(a, null);
                }
            } else {
                if (list.size() < a) {
                    list.add(i);
                }
                if (list.size() == a) {
                    lists.add(list);
                    map.put(a, null);
                }
            }
        }

        return lists;
    }

    public static void main(String[] args) {
        UserGrouping userGrouping = new UserGrouping();

        System.out.println(userGrouping.groupThePeople(new int[] {3,3,3,3,3,1,3}));
    }

}
