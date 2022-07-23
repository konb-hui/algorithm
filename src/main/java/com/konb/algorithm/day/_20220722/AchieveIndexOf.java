package com.konb.algorithm.day._20220722;

import java.util.HashMap;
import java.util.Map;

/**
 * @author konb
 * @version 1.0
 * @date 2022-07-22 18:34
 * leetcode 28 实现 strStr()
 */
public class AchieveIndexOf {

    public int strStr(String haystack, String needle) {
        int length1 = haystack.length();
        int length2 = needle.length();

        if (length2 > length1) {
            return -1;
        }

        Map<Character, Integer> map = init(needle);

        int i = length2 - 1, j = i;
        int k = 0;

        while (true) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                if (-- j < 0) {
                    break;
                }
                -- i;
            } else {
                int index = k + length2;
                if (index >= length1) {
                    return -1;
                }
                Integer temp = map.get(haystack.charAt(index));
                int moveNum = length2 - (temp == null ? -1 : temp);
                k = k + moveNum;
                i = k + length2 - 1;
                j = length2 - 1;

                if (i >= length1) {
                    return -1;
                }
            }
        }
        return k;
    }

    public Map<Character, Integer> init(String needle) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < needle.length(); i ++) {
            map.put(needle.charAt(i), i);
        }

        return map;
    }
//"mississippi"
//        "issipi"
    public static void main(String[] args) {
        AchieveIndexOf achieveIndexOf = new AchieveIndexOf();
        System.out.println(achieveIndexOf.strStr("mississipii", "issipi"));
    }

}
