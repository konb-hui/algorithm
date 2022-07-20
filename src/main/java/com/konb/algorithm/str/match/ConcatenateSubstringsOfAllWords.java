package com.konb.algorithm.str.match;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author konb
 * @version 1.0
 * @date 2022-06-29 9:04
 * leetcode 30 串联所有单词的子串
 */
public class ConcatenateSubstringsOfAllWords {

    public List<Integer> findSubstring(String s, String[] words) {

        if (words.length < 1) {
            return new ArrayList<>();
        }

        //结果
        List<Integer> result = new ArrayList<>();
        //保存单词和对应的值
        HashMap<String, Integer> data = new HashMap<>();
        //每个单词被赋予的值，从1开始
        final Integer count = 1;
        //所有单词都经过一遍后的值
        int num = 0;
        //单词长度
        int length = words[0].length();
        //单词数组长度
        int arrLength = words.length;

        //初始化map和总值
        for(String word : words) {
            if (! data.containsKey(word)) {
                data.put(word, 1);
                continue;
            }
            data.put(word, data.get(word) + 1);
        }

        //计数
        int c = 0;
        int i = 0;
        Map<String, Integer> temp = new HashMap<>(data);
        while (i + length <= s.length()) {
            String s1 = s.substring(i, i + length);
            if (data.containsKey(s1)) {
                c ++;
                i += length;
                int v = temp.get(s1);
                if (v == 0) {
                    i = i - c * length + 1;
                    c = 0;
                    temp = new HashMap<>(data);
                    continue;
                }
                temp.put(s1, temp.get(s1) - 1);
            } else {
                i = i - c * length + 1;
                c = 0;
                temp = new HashMap<>(data);
                continue;
            }

            if (c != 0 && c % arrLength == 0) {
                //如果值相等，则说明找到了
                int first = i - length * arrLength;
                result.add(first);
                i = first + 1;
                c = 0;
                temp = new HashMap<>(data);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        ConcatenateSubstringsOfAllWords concatenateSubstringsOfAllWords = new ConcatenateSubstringsOfAllWords();
        System.out.println(concatenateSubstringsOfAllWords.findSubstring("abaababbaba", new String[]{"ab","ba","ab","ba"}).toString());
    }

}
