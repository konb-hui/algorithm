package com.konb.algorithm.day._2022._08._19;

import java.util.LinkedList;
import java.util.List;

/**
 * @author konb
 * @version 1.0
 * @date 2022-08-19 17:23
 * leetcode 60 排列序列
 */
public class ArrangementSequence {

    public String getPermutation(int n, int k) {
        List<Integer> list = init(n);
        StringBuilder stringBuilder = new StringBuilder();
        while (n > 0) {
            int sum = sum(n - 1);
            int a = k / sum;
            if (k % sum == 0) {
                a --;
            }

            stringBuilder.append(list.remove(a));

            n --;
            k -= a * sum;
        }

        return stringBuilder.toString();
    }

    private List<Integer> init(int n) {
        List<Integer> list = new LinkedList<>();
        for (int i = 1; i <= n; i ++) {
            list.add(i);
        }
        return list;
    }

    private int sum(int n) {
        int count = 1;
        for (int i = 2; i <= n; i ++) {
            count *= i;
        }
        return count;
    }

    public static void main(String[] args) {
        ArrangementSequence arrangementSequence = new ArrangementSequence();
        System.out.println(arrangementSequence.getPermutation(4, 1));
        System.out.println(arrangementSequence.getPermutation(4, 2));
        System.out.println(arrangementSequence.getPermutation(4, 3));
        System.out.println(arrangementSequence.getPermutation(4, 4));
        System.out.println(arrangementSequence.getPermutation(4, 5));
        System.out.println(arrangementSequence.getPermutation(4, 6));
    }

}
