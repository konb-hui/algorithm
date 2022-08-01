package com.konb.algorithm.day._2022._07._29;

import com.konb.algorithm.day.ListNode;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author konb
 * @version 1.0
 * @date 2022-07-29 16:53
 * leetcode 23 合并K个升序链表
 */
public class MergeKAscendingLinkedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        for (ListNode node : lists) {
            while (node != null) {
                treeMap.put(node.val, treeMap.getOrDefault(node.val, 0) + 1);
                node = node.next;
            }
        }

        ListNode root = null;
        ListNode r = root;
        for (Map.Entry<Integer, Integer> map : treeMap.entrySet()) {
            int count = map.getValue();
            while (count > 0) {
                if (root == null) {
                    root = new ListNode(map.getKey());
                    r = root;
                    count --;
                    continue;
                }
                root.next = new ListNode(map.getKey());
                root = root.next;
                count --;
            }
        }

        return r;
    }

}
