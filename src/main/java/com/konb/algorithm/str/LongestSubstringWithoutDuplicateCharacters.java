package com.konb.algorithm.str;

import java.util.HashMap;
import java.util.Map;

/**
 * @author konb
 * @version 1.0
 * @date 2022-06-29 17:06
 * leetcode 3 无重复字符的最长子串
 */
public class LongestSubstringWithoutDuplicateCharacters {

    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> data = new HashMap<>();

        int max = 0;
        int index = 0;
        for (int i = 0; i < chars.length; i ++) {
            char c = chars[i];
            if (data.containsKey(c)) {
                max = Math.max(max, i - index);
                index = Math.max(index, data.get(c) + 1);
            }
            data.put(chars[i], i);
        }

        return Math.max(s.length() - index, max);
    }

    public static void main(String[] args) {
        LongestSubstringWithoutDuplicateCharacters longestSubstringWithoutDuplicateCharacters = new LongestSubstringWithoutDuplicateCharacters();
        System.out.println(longestSubstringWithoutDuplicateCharacters.lengthOfLongestSubstring("abba"));
    }

}
