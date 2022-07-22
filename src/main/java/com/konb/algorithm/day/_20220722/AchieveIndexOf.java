package com.konb.algorithm.day._20220722;

/**
 * @author konb
 * @version 1.0
 * @date 2022-07-22 18:34
 * leetcode 28 实现 strStr()
 */
public class AchieveIndexOf {

    public int strStr(String haystack, String needle) {
        int length1 = haystack.length();
        int length2 = needle.length();

        int i = 0, j = 0;
        int k = i;

        while (true) {
            if (haystack.charAt(i ++) == needle.charAt(j ++)) {
                if (j >= length2) {
                    break;
                }
            } else {
                int index = k + length2;
                if (index >= length1) {
                    return -1;
                }
                int moveNum = length2 - indexOf(needle, haystack.charAt(index));
                i = i + moveNum;
                k = i;
                j = 0;
            }
        }
        return k;
    }

    public int indexOf(String needle, char a) {
        for (int i = needle.length() - 1; i >= 0; i --) {
            if (a == needle.charAt(i)) {
                return i;
            }
        }

        return -1;
    }
//"mississippi"
//        "issipi"
    public static void main(String[] args) {
        AchieveIndexOf achieveIndexOf = new AchieveIndexOf();
        System.out.println(achieveIndexOf.strStr("abc", "c"));
    }

}
