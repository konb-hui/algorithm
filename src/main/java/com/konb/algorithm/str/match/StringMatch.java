package com.konb.algorithm.str.match;

import java.util.Arrays;
import java.util.Random;

/**
 * @author konb
 * @version 1.0
 * @date 2022-06-14 9:41
 */
public class StringMatch {

    /**
     * 暴力破解法 BF
     * 时间复杂度 O(mn)
     * 空间复杂度 O(m + N)
     */
    public static int bruteForce(String target, String pattern) {

        int targetLength = target.length();
        int patternLength = pattern.length();

        if (targetLength < patternLength || targetLength < 1 || patternLength < 1) {
            return -1;
        }

        char[] targetArray = target.toCharArray();
        char[] patternArray = pattern.toCharArray();

        int i = 0, j = 0, k = 0;
        boolean flag = false;
        while (true) {
            if (targetArray[i] != patternArray[j]) {
                //优化项：如果剩余长度小于匹配字符串长度，直接返回
                if (targetLength - i <= patternLength) {
                    return -1;
                }
                if (! flag) {
                    i ++;
                } else {
                    flag = false;
                }
                j = 0;
            } else {
                flag = true;
                i ++;
                j ++;
                if (j == patternLength) {
                    return i - patternLength;
                }
            }
            if (i >= targetLength) {
                return -1;
            }
        }
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Rabin-Karp算法 RK 拆分成多个和匹配字符串长度相同的子字符串，再计算hash值，hash值一致再匹配
     * 速度反而比暴力还慢，时间应该都花在substring上了,应该需要想其他方法替代substring
     * 也可能是我写的不对
     * 时间复杂度 O(mn)
     * 空间复杂度 O(m + n)
     */
    public static int rabinKrap(String target, String pattern) {

        int targetLength = target.length();
        int patternLength = pattern.length();

        if (targetLength < patternLength || targetLength < 1 || patternLength < 1) {
            return -1;
        }

        int patternHashCode = pattern.hashCode();

        if (target.hashCode() == patternHashCode) {
            return 0;
        }

        int i = 0, j = patternLength;

        while (j <= targetLength) {
            String temp = target.substring(i, j);
            int hash = temp.hashCode();
            if (hash == patternHashCode && pattern.equals(temp)) {
                return i;
            }
            i ++;
            j ++;
        }

        return -1;
    }

    /**
     * 判断两个字符串是否相同，相当于equals
     * @param str1 字符串1
     * @param str2 字符串2
     * @return 匹配结果
     */
    private static boolean compareTwoIsometricArray(String str1, String str2) {
        char[] a = str1.toCharArray();
        char[] b = str2.toCharArray();
        int length1 = a.length;
        int length2 = b.length;
        if (length1 != length2) {
            return false;
        }
        for (int i = 0; i < length1; i ++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }

    private static boolean compareTwoIsometricArray(char[] a, char[] b, int start1, int end1, int start2, int end2) {
        int length1 = end1 - start1 + 1;
        int length2 = end2 - start2 + 1;
        if (length1 != length2) {
            return false;
        }
        while (start1 <= end1) {
            if (a[start1 ++] != b[start2 ++]) {
                return false;
            }
        }
        return true;
    }


    /////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Boyer-Moore字符串搜索算法 BM
     * 该算法是从右到左对比字符，若不等，通过最坏字符规则和最好后缀规则确定需要移动的最大位数
     * 最坏是O(mn)，最好是O(n/m)
     * 空间复杂度是O(M）
     * 速度比较快 BM>BF>KR,一般文档的Ctrl+F是使用这种算法
     */
    public static int boyerMoore(String target, String pattern) {

        char[] a = target.toCharArray();
        char[] b = pattern.toCharArray();

        goodSuffixInit(b);

        int length1 = a.length;
        int length2 = b.length;

        int i = length2 - 1;
        int j = i;
        int k = 0;

        while (i < length1) {
            //字符匹配，位置-1，若匹配字符串的位置-1后小于0则匹配完成，返回结果
            if (a[i] == b[j]) {
                if (-- j < 0) {
                    return i;
                }
                -- i;
                //字符不匹配
            } else {
                //获取不匹配字符在匹配字符串的位置
                int moveNum = Math.max(badCharacterMoveNum(b, a[i], j), goodSuffixMoveNum(b, j + 1));
                //获取移动后pattern最左边的位置
                k += moveNum;
                //获取移动后pattern最右边的位置
                i = k + length2 - 1;
                //j初始化为开始值，重新开始匹配
                j = length2 - 1;
            }
        }

        return -1;
    }

    /**
     * 获取当前字符在当前字符串通过坏字符规则需要移动的位数
     * @param p 字符串
     * @param c 字符
     * @return 字符所在字符串最右位置
     */
    private static int badCharacterMoveNum(char[] p, char c, int index) {
        int a = -1;
        for (int i = index - 1; i >= 0; i --) {
            if (p[i] == c) {
                a = i;
                break;
            }
        }
        return index - a;
    }

    /**
     * 好后缀规则数组，初始化所有后缀对应的重复部分的下标
     */
    static int[] isMatch;

    /**
     * 初始化好后缀规则数组
     * @param pattern 目标字符串
     */
    private static void goodSuffixInit(char[] pattern) {
        int length = pattern.length;
        int half = length / 2;
        int maxIndex = length - 1;
        isMatch = new int[half];
        for (int i = maxIndex; i >= length - half; i --) {
            for (int j = half - 1; j >= 0; j -= length - i) {
                int inc = maxIndex - i;
                if (compareTwoIsometricArray(pattern, pattern, i, maxIndex, j, j + inc)) {
                    isMatch[maxIndex - i] = j + 1;
                    break;
                }
            }
        }
    }

    /**
     * 获取字符串好后缀能移动的位数
     * @param p 目标字符串
     * @param index 好后缀首个字符下标
     * @return 移动位数
     */
    private static int goodSuffixMoveNum(char[] p, int index) {

        if (index >= p.length) {
            return -1;
        }

        if (index < p.length - (p.length / 2)) {
            return isMatch[isMatch.length - 1];
        }

        int num = isMatch[p.length - 1 - index];

        if (num == 0) {
            return p.length;
        }

        return index - num + 1;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////


    /**
     * Sunday算法
     * 时间复杂度，最差O(MN),最好O(N)
     * 空间复杂度O(1)
     * 速度：Sunday>BM>BF>RK
     */
    public static int sunday(String target, String pattern) {

        char[] a = target.toCharArray();
        char[] b = pattern.toCharArray();

        int length1 = a.length;
        int length2 = b.length;
        int i = 0, j = 0;
        int k = i;
        while (i < length1) {
            //字符匹配，则下标分别往后移动一位
            if (a[i] == b[j]) {
                //移位后超出pattern长度，说明匹配成功，返回结果
                if (++ j >= length2) {
                    return k;
                }
                ++ i;
            } else {
                //不匹配获取当前匹配中的字符的下一位字符的下标
                int indexA = k + length2;
                //超出target的长度，说明匹配失败，直接返回target匹配的起始位置
                if (indexA >= length1) {
                    return -1;
                }
                //获取target需要往后移动的位数
                int moveNum = length2 - indexOf(b, a[indexA]);
                //更新target起始位置
                k += moveNum;
                i = k;
                j = 0;
            }
        }

        return -1;
    }

    private static int indexOf(char[] pattern, char a) {
        for (int i = pattern.length - 1; i >= 0; i --) {
            if (pattern[i] == a) {
                return i;
            }
        }
        return -1;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////


    /**
     * KMP算法
     * 很复杂
     * 时间复杂度O(N) 但实际速度并没有非常好，只比RK好
     * 空间复杂度O(M)
     */
    private static int kmp(String target, String pattern) {
        char[] a = target.toCharArray();
        char[] b = pattern.toCharArray();
        int length1 = a.length;
        int length2 = b.length;

        int i = 0, j = 0;

        int[] next = initMatchTable(b);
        while (i < length1 && j < length2) {

            // 当j为-1时，要移动的是i，当然j也要归0
            if (j == -1 || a[i] == b[j]) {

                i++;

                j++;

            } else {

                // i不需要回溯了

                // i = i - j + 1;

                // j回到指定位置

                j = next[j];

            }

        }

        if (j == length2) {

            return i - j;

        } else {

            return -1;

        }
    }






    private static int[] initMatchTable(char[] pattern) {
        int length = pattern.length;
        int[] next = new int[length];

        next[0] = -1;

        int j = 0;

        int k = -1;

        while (j < length - 1) {

            if (k == -1 || pattern[j] == pattern[k]) {

                next[++j] = ++k;

            } else {

                k = next[k];

            }

        }

        return next;
    }


    /////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static void main(String[] args) {

        int i1 = -1;
        int count = 0;

        while (i1 == -1) {

            String target = getRandomStr(10000000);
            String pattern = getRandomStr(5);

//            String target = "awa";
//            String pattern = "wa";

//            System.out.println(target);
//            System.out.println(pattern);

            long time1 = System.currentTimeMillis();
            i1 = bruteForce(target, pattern);
            long time2 = System.currentTimeMillis();
            System.out.println("暴力破解法：位置：" + i1 + " 耗时：" + (time2 - time1) + "毫秒");

            long time3 = System.currentTimeMillis();
            int i2 = rabinKrap(target, pattern);
            long time4 = System.currentTimeMillis();
            System.out.println("Rabin-Karp法：位置：" + i2 + " 耗时：" + (time4 - time3) + "毫秒");

            long time5 = System.currentTimeMillis();
            int i3 = boyerMoore(target, pattern);
            long time6 = System.currentTimeMillis();
            System.out.println("Boyer-Moore法：位置：" + i3 + " 耗时：" + (time6 - time5) + "毫秒");

            long time7 = System.currentTimeMillis();
            int i4 = sunday(target, pattern);
            long time8 = System.currentTimeMillis();
            System.out.println("Sunday算法：位置：" + i4 + " 耗时：" + (time8 - time7) + "毫秒");

            long time9 = System.currentTimeMillis();
            int i5 = kmp(target, pattern);
            long time10 = System.currentTimeMillis();
            System.out.println("kmp算法：位置：" + i5 + " 耗时：" + (time10 - time9) + "毫秒");


            System.out.println("第" + ++count + "次");
            System.out.println("===========================================");
        }
    }

    public static String getRandomStr(int n) {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        //创建random对象
        Random r = new Random();
        StringBuilder stringBuffer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            //使用random生成[0,62)之间的随机数,不包括62
            int it = r.nextInt(62);
            // 把int下标 转为 str中随机字符(数字，大写字母或者小写字母)
            stringBuffer.append(str.charAt(it));

        }
        return stringBuffer.toString();
    }
}
