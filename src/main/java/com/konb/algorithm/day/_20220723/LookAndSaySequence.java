package com.konb.algorithm.day._20220723;


/**
 * @author konb
 * @version 1.0
 * @date 2022-07-23 14:27
 * leetcode 38 外观数列
 */
public class LookAndSaySequence {

    public String countAndSay(int n) {
        String prevString = "1";

        for (int i = 1; i < n; i ++) {
            prevString = parse(prevString);
        }

        return prevString;
    }

    public String parse(String prev) {
        char now = '*';
        int count = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < prev.length(); i ++) {
            char a = prev.charAt(i);
            if (now == '*') {
                now = a;
                count ++;
                continue;
            }
            if (a == now) {
                count ++;
            } else {
                stringBuilder.append(count).append(now);
                now = a;
                count = 1;
            }
        }

        stringBuilder.append(count).append(now);

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        LookAndSaySequence lookAndSaySequence = new LookAndSaySequence();
        lookAndSaySequence.countAndSay(8);
    }

}
