package com.konb.algorithm.day._2022._07._29;

import com.konb.algorithm.day.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author konb
 * @version 1.0
 * @date 2022-07-29 17:17
 * leetcode 24 两两交换链表中的节点
 */
public class ExchangeTheNodesInTheLinkedListInPairs {

    public ListNode swapPairs(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode root = null;
        ListNode r = null;

        Deque<ListNode> deque = new LinkedList<>();

        while (head != null) {
            if (deque.size() == 2) {
                while (deque.size() > 0) {
                    if (root == null) {
                        root = deque.pop();
                        r = root;
                    }
                    root.next = deque.pop();
                    root = root.next;
                }
            }

            deque.push(head);
            head = head.next;
        }

        while (! deque.isEmpty()) {
            if (root == null) {
                root = deque.pop();
                r = root;
                continue;
            }
            root.next = deque.pop();
            root = root.next;
        }

        root.next = null;

        return r;

    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ExchangeTheNodesInTheLinkedListInPairs exchangeTheNodesInTheLinkedListInPairs = new ExchangeTheNodesInTheLinkedListInPairs();
        System.out.println(exchangeTheNodesInTheLinkedListInPairs.swapPairs(listNode));
    }

}
