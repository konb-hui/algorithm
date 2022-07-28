package com.konb.algorithm.day._20220728;

import com.konb.algorithm.day.ListNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author konb
 * @version 1.0
 * @date 2022-07-28 16:25
 */
public class DeleteThePenultimateNodeOfTheLinkedList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        Deque<ListNode> deque = new LinkedList<>();

        ListNode root = head;

        while (head != null) {
            deque.push(head);
            head = head.next;
        }

        ListNode node = null;
        while (n > 0 && deque.peek() != null) {
            node = deque.pop();
            n --;
        }

        if (n == 0) {
            if (deque.peek() != null) {
                deque.pop().next = node.next;
            } else {
                root = node.next;
            }
        }

        return root;
    }

    public static void main(String[] args) {
        DeleteThePenultimateNodeOfTheLinkedList deleteThePenultimateNodeOfTheLinkedList = new DeleteThePenultimateNodeOfTheLinkedList();
    }

}
