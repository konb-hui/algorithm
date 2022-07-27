package com.konb.algorithm.day._20220727;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author konb
 * @version 1.0
 * @date 2022-07-27 17:44
 * leetcode 87 扰乱字符串
 */
public class ScrambleString {

    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }

        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();

        set1.add(s1.charAt(0) + "");

        for (int i = 1; i < s1.length(); i ++) {
            char a = s1.charAt(i);
            for (String s : set1) {
                set2.add(s + a);
                set2.add(a + s);
            }
            set1.clear();
            set1.addAll(set2);
            set2.clear();
        }

        System.out.println(set1.contains(s1));
        return set1.contains(s2);
    }

//    "abcdbdacbdac"
//            "bdacabcdbdac"
    public static void main(String[] args) {
        ScrambleString scrambleString = new ScrambleString();
        System.out.println(scrambleString.isScramble("abcdbdacbdac", "bdacabcdbdac"));
    }

}
