package com.konb.algorithm.day._20220727;

import java.util.HashMap;
import java.util.Map;

/**
 * @author konb
 * @version 1.0
 * @date 2022-07-27 11:25
 * leetcode 76 最小覆盖子串
 */
public class MinimumCoveringSubstring {

    public String minWindow(String s, String t) {
        int length1 = s.length();
        int length2 = t.length();

        if (length1 < length2) {
            return "";
        }

        Map<Character, Integer> map = new HashMap<>();
        int l = 0, r = 0, count = 0;

        for (int i = 0; i < length2; i ++) {
            char a = t.charAt(i);
            map.put(a, map.getOrDefault(a, 0) + 1);
            count ++;
        }

        int start = 0, end = length1;
        while (r < length1) {
            char a = s.charAt(r);
            Integer c1 = map.get(a);
            if (c1 != null) {
                if (c1 > 0) {
                    count --;
                }
                map.put(a, c1 - 1);
            }

            if (count == 0) {
                while (true) {
                    char b = s.charAt(l);
                    Integer c2 = map.get(b);
                    if (c2 != null) {
                        if (c2 == 0 || count == 1) {
                            if (count == 1) {
                                break;
                            }
                            count ++;
                            if (end - start > r - l) {
                                start = l;
                                end = r;
                                if (end - start + 1 == length2) {
                                    return s.substring(start, end + 1);
                                }
                            }
                        }
                        map.put(b, c2 + 1);
                    }
                    l ++;
                }
            }

            r ++;
        }

        if (end - start >= length1) {
            return "";
        }
        return s.substring(start, end + 1);
    }


//    "aaflslflsldkalskaaa"
//            "aaa
    public static void main(String[] args) {
        MinimumCoveringSubstring minimumCoveringSubstring = new MinimumCoveringSubstring();
        System.out.println(minimumCoveringSubstring.minWindow("aaflslflsldkalskaaa", "aaa"));
    }

}
