package com.konb.algorithm.day._2022._08._16;

import java.util.ArrayList;
import java.util.List;

/**
 * @author konb
 * @version 1.0
 * @date 2022-08-16 10:13
 * leetcode 1656 设计有序流
 */
public class OrderedStream {

    private String[] data;
    private int ptr;

    public OrderedStream(int n) {
        data = new String[n];
        ptr = 0;
    }

    public List<String> insert(int idKey, String value) {
        data[idKey - 1] = value;
        List<String> list = new ArrayList<>();
        while (ptr < data.length && data[ptr] != null) {
            list.add(data[ptr]);
            ptr ++;
        }

        return list;
    }

}
