package com.konb.algorithm.day._2022._08._06;

import java.util.*;

/**
 * @author konb
 * @version 1.0
 * @date 2022-08-06 16:11
 * leetcode 1408 数组中的字符串匹配
 */
public class StringMatchingInArray {

    public List<String> stringMatching(String[] words) {

        Set<String> set = new HashSet<>();

        int length = words.length;

        for (int i = 0; i < length - 1; i ++) {
            for (int j = i + 1;j < length; j ++) {
                String a = words[i];
                String b = words[j];

                if (a.length() >= b.length()) {
                    if (a.contains(b)) {
                        set.add(b);
                    }
                } else {
                    if (b.contains(a)) {
                        set.add(a);
                    }
                }
            }
        }

        return new ArrayList<>(set);

    }

}
