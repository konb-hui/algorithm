package com.konb.algorithm.day._20220723;

/**
 * @author konb
 * @version 1.0
 * @date 2022-07-23 14:44
 * leetcode 58 最后一个单词的长度
 */
public class LengthOfTheLastWord {

    public int lengthOfLastWord(String s) {
        int length = 0;
        for (int i  = s.length() - 1; i >= 0; i --) {
            if (length ==  0 && s.charAt(i) == ' ') {
                continue;
            } else if(length != 0 && s.charAt(i) == ' ') {
                return length;
            }
            length ++;
        }

        return length;
    }

    public static void main(String[] args) {
        LengthOfTheLastWord lengthOfTheLastWord = new LengthOfTheLastWord();
        System.out.println(lengthOfTheLastWord.lengthOfLastWord("   fly me   to   the moon  "));
    }

}
