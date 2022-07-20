package com.konb.algorithm.str.match;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author konb
 * @version 1.0
 * @date 2022-06-29 15:55
 * leetcode 49 字母异位词分组
 */
public class GroupingOfAlphabeticWords {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();



        return result;
    }

    public List<List<String>> sort(String[] strs) {
        List<List<String>> result = new ArrayList<>();

        Map<Integer, List<String>> map = new HashMap<>();

        for (String s : strs) {
            int hash = getSortHash(s);
            if (map.containsKey(hash)) {
                map.get(hash).add(s);
                continue;
            }
            List<String> list = new ArrayList<>();
            list.add(s);
            map.put(hash, list);
        }

        map.forEach((key, value) -> {
            result.add(value);
        });

        return result;
    }

    public int getSortHash(String s) {
        char[] chars = s.toCharArray();
        quickSort(chars, 0, chars.length);

        return String.valueOf(chars).hashCode();
    }

    public void quickSort(char[] chars, int begin, int end) {
        int num = end - begin;

        if (num < 2) {
            return;
        }
        char base = chars[begin];
        int baseIndex = begin;
        for (int i = begin + 1; i < end; i ++) {
            if (chars[i] <= base) {
                chars[baseIndex] = chars[i];
                baseIndex ++;
                chars[i] = chars[baseIndex];
            }
        }
        chars[baseIndex] = base;

        quickSort(chars, 0, baseIndex);
        quickSort(chars, baseIndex + 1, end);
    }

    public List<List<String>> count(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            int[] counts = new int[26];
            int length = str.length();
            for (int i = 0; i < length; i++) {
                counts[str.charAt(i) - 'a']++;
            }
            // 将每个出现次数大于 0 的字母和出现次数按顺序拼接成字符串，作为哈希表的键
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < 26; i++) {
                if (counts[i] != 0) {
                    sb.append((char) ('a' + i));
                    sb.append(counts[i]);
                }
            }
            String key = sb.toString();
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }

    public static void main(String[] args) {
        GroupingOfAlphabeticWords groupingOfAlphabeticWords = new GroupingOfAlphabeticWords();
        System.out.println(groupingOfAlphabeticWords.sort(new String[]{"bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb","zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz"}).toString());
    }

}
