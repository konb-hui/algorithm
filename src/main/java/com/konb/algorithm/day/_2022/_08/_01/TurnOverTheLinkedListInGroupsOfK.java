package com.konb.algorithm.day._2022._08._01;

import com.konb.algorithm.day.ListNode;

import java.util.*;

/**
 * @author konb
 * @version 1.0
 * @date 2022-08-01 10:13
 * leetcode 25 K 个一组翻转链表
 */
public class TurnOverTheLinkedListInGroupsOfK {

    public ListNode reverseKGroup(ListNode head, int k) {

        Deque<ListNode> deque = new LinkedList<>();

        ListNode root = null;
        ListNode r = null;

        while (head != null) {
            deque.push(head);
            head = head.next;
            if (deque.size() == k) {
                while (! deque.isEmpty()) {
                    if (root == null) {
                        root = deque.pop();
                        r = root;
                        continue;
                    }
                    root.next = deque.pop();
                    root = root.next;
                }
            }
        }

        if (! deque.isEmpty()) {
            while (deque.size() > 1) {
                deque.pop();
            }
            root.next = deque.pop();
        } else {
            root.next = null;
        }

        return r;

    }

}
