package com.konb.algorithm.day._20220714;

import java.util.HashMap;
import java.util.Map;

/**
 * @author konb
 * @version 1.0
 * @date 2022-07-14 11:12
 * leetcode 745 前缀和后缀搜索
 */
public class WordFilter {
    Trie trie;
    String weightKey;

    public static void main(String[] args) {
        WordFilter wordFilter = new WordFilter(new String[]{"apple", "pear"});
    }

    public WordFilter(String[] words) {
        trie = new Trie();
        weightKey = "##";
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            Trie cur = trie;
            int m = word.length();
            for (int j = 0; j < m; j++) {
                Trie tmp = cur;
                for (int k = j; k < m; k++) {
                    String key = new StringBuilder().append(word.charAt(k)).append('#').toString();
                    if (!tmp.children.containsKey(key)) {
                        tmp.children.put(key, new Trie());
                    }
                    tmp = tmp.children.get(key);
                    tmp.weight.put(weightKey, i);
                }
                tmp = cur;
                for (int k = j; k < m; k++) {
                    String key = new StringBuilder().append('#').append(word.charAt(m - k - 1)).toString();
                    if (!tmp.children.containsKey(key)) {
                        tmp.children.put(key, new Trie());
                    }
                    tmp = tmp.children.get(key);
                    tmp.weight.put(weightKey, i);
                }
                String key = new StringBuilder().append(word.charAt(j)).append(word.charAt(m - j - 1)).toString();
                if (!cur.children.containsKey(key)) {
                    cur.children.put(key, new Trie());
                }
                cur = cur.children.get(key);
                cur.weight.put(weightKey, i);
            }
        }
    }

    public int f(String pref, String suff) {
        Trie cur = trie;
        int m = Math.max(pref.length(), suff.length());
        for (int i = 0; i < m; i++) {
            char c1 = i < pref.length() ? pref.charAt(i) : '#';
            char c2 = i < suff.length() ? suff.charAt(suff.length() - 1 - i) : '#';
            String key = new StringBuilder().append(c1).append(c2).toString();
            if (!cur.children.containsKey(key)) {
                return -1;
            }
            cur = cur.children.get(key);
        }
        return cur.weight.get(weightKey);
    }
}

class Trie {
    Map<String, Trie> children;
    Map<String, Integer> weight;

    public Trie() {
        children = new HashMap<String, Trie>();
        weight = new HashMap<String, Integer>();
    }
}
