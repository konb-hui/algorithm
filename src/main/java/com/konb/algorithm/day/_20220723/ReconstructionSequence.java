package com.konb.algorithm.day._20220723;

import java.util.*;

/**
 * @author konb
 * @version 1.0
 * @date 2022-07-23 11:00
 * leetcode 115 重建序列
 */
public class ReconstructionSequence {

    int N = 10010, M = N, idx;
    int[] he = new int[N], e = new int[M], ne = new int[M], in = new int[N];
    void add(int a, int b) {
        e[idx] = b;
        ne[idx] = he[a];
        he[a] = idx++;
        in[b]++;
    }
    public boolean sequenceReconstruction(int[] nums, int[][] ss) {
        int n = nums.length;
        Arrays.fill(he, -1);
        for (int[] s : ss) {
            for (int i = 1; i < s.length; i++) add(s[i - 1], s[i]);
        }
        Deque<Integer> d = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            if (in[i] == 0) d.addLast(i);
        }
        int loc = 0;
        while (!d.isEmpty()) {
            if (d.size() != 1) return false;
            int t = d.pollFirst();
            if (nums[loc++] != t) return false;
            for (int i = he[t]; i != -1; i = ne[i]) {
                int j = e[i];
                if (--in[j] == 0) d.addLast(j);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ReconstructionSequence reconstructionSequence = new ReconstructionSequence();
        System.out.println(reconstructionSequence.sequenceReconstruction(new int[]{3, 2, 1}, new int[][]{{1, 2}, {1, 3}, {1, 2, 3}}));
    }

}
