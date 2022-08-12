package com.konb.algorithm.day._2022._08._10;

import java.util.ArrayList;
import java.util.List;

/**
 * @author konb
 * @version 1.0
 * @date 2022-08-11 11:13
 * leetcode 1417 重新格式化字符串
 */
public class ReformatString {

    public String reformat(String s) {
        List<Character> letter = new ArrayList<>();
        List<Character> number = new ArrayList<>();

        for (int i = 0; i < s.length(); i ++) {
            char a = s.charAt(i);
            if (a >= '0' && a <= '9') {
                number.add(a);
            }else {
                letter.add(a);
            }
        }

        int length1 = letter.size();
        int length2 = number.size();

        if (Math.abs(length1 - length2) > 1) {
            return "";
        }

        List<Character> first = length1 > length2 ? letter : number;
        List<Character> last = length1 <= length2 ? letter : number;

        int i = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (i < first.size()) {
            stringBuilder.append(first.get(i));
            if (i <last.size()) {
                stringBuilder.append(last.get(i));
            }
            i ++;
        }

        return stringBuilder.toString();
    }

}
