package com.konb.algorithm.day._20220722;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author konb
 * @version 1.0
 * @date 2022-07-22 9:56
 * leetcode 17 电话号码的字母组合
 */
public class LetterCombinationOfTelephoneNumber {

    Map<Character, List<Character>> data = new HashMap<>(8);

    public void init() {
        List<Character> list1 = new ArrayList<>();
        list1.add('a');
        list1.add('b');
        list1.add('c');
        data.put('2', list1);
        List<Character> list2 = new ArrayList<>();
        list2.add('d');
        list2.add('e');
        list2.add('f');
        data.put('3', list2);
        List<Character> list3 = new ArrayList<>();
        list3.add('g');
        list3.add('h');
        list3.add('i');
        data.put('4', list3);
        List<Character> list4 = new ArrayList<>();
        list4.add('j');
        list4.add('k');
        list4.add('l');
        data.put('5', list4);
        List<Character> list5 = new ArrayList<>();
        list5.add('m');
        list5.add('n');
        list5.add('o');
        data.put('6', list5);
        List<Character> list6 = new ArrayList<>();
        list6.add('p');
        list6.add('q');
        list6.add('r');
        list6.add('s');
        data.put('7', list6);
        List<Character> list7 = new ArrayList<>();
        list7.add('t');
        list7.add('u');
        list7.add('v');
        data.put('8', list7);
        List<Character> list8 = new ArrayList<>();
        list8.add('w');
        list8.add('x');
        list8.add('y');
        list8.add('z');
        data.put('9', list8);
    }

    public List<String> add(List<String> r, List<Character> list) {
        int size = r.size();
        if (size == 0) {
            for (char a : list) {
                r.add(a + "");
            }
            return r;
        }
        List<String> list1 = new ArrayList<>();
        for (int i = 0; i < list.size(); i ++) {
            list1.addAll(r);
        }
        int s = r.size();
        for (int i = 0; i < list.size(); i ++) {
            for (int j = i * s ; j < (i + 1) * s; j ++) {
                list1.set(j, list1.get(j) + list.get(i));
            }
        }

        return list1;
    }

    public List<String> letterCombinations(String digits) {
        init();
        List<String> r = new ArrayList<>();
        for (int i = 0; i < digits.length(); i ++) {
            r = add(r, data.get(digits.charAt(i)));
        }
        return r;
    }

    public static void main(String[] args) {
        LetterCombinationOfTelephoneNumber letterCombinationOfTelephoneNumber = new LetterCombinationOfTelephoneNumber();
        System.out.println(letterCombinationOfTelephoneNumber.letterCombinations("234"));
    }

}
