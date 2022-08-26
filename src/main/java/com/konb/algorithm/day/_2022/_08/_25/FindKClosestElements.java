package com.konb.algorithm.day._2022._08._25;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author konb
 * @version 1.0
 * @date 2022-08-25 10:35
 * leetcode 658 找到 K 个最接近的元素
 */
public class FindKClosestElements {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int length = arr.length;
        if (k == arr.length) {
            List<Integer> list = new ArrayList<>(length);
            for (int i : arr) {
                list.add(i);
            }
            return list;
        }

        LinkedList<Integer> r = new LinkedList<>();
        int min = Math.abs(arr[0] - x);
        for (int i = 1; i < length; i ++) {
            int m = Math.abs(arr[i] - x);
            if (m > min || (m == min && arr[i] > arr[i - 1])) {
                int left = i - 2;
                int right = i;
                r.add(arr[i - 1]);
                while (r.size() < k) {
                    if (left < 0 && right >= length) {
                        break;
                    } else if (left >= 0 && right >= length) {
                        r.addFirst(arr[left]);
                        left --;
                    } else if (left < 0 && right < length) {
                        r.addLast(arr[right]);
                        right ++;
                    } else {
                        int m1 = Math.abs(arr[left] - x);
                        int m2 = Math.abs(arr[right] - x);
                        if (m1 <= m2) {
                            r.addFirst(arr[left]);
                            left --;
                        } else {
                            r.addLast(arr[right]);
                            right ++;
                        }
                    }

                }
                return r;
            } else {
                min = m;
            }
        }

        int i = length - 1;
        while (r.size() < k) {
            r.addFirst(arr[i]);
            i --;
        }

        return r;
    }

    public static void main(String[] args) {
        FindKClosestElements findKClosestElements = new FindKClosestElements();
        System.out.println(findKClosestElements.findClosestElements(new int[] {1, 3}, 1, 2));
    }

}
