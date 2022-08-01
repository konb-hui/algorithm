package com.konb.algorithm.day._20220728;

import com.konb.algorithm.day.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author konb
 * @version 1.0
 * @date 2022-07-28 17:32
 * leetcode 21 合并两个有序链表
 */
public class MergeTwoOrderedLinkedLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }

        ListNode root1 = list1;
        ListNode root2 = list2;
        ListNode r = root1;

        Deque<ListNode> deque = new LinkedList<>();

        while (true) {
            if (root1.val > root2.val) {
                if (deque.isEmpty()) {
                    r = root2;
                } else {
                    deque.pop().next = root2;
                }
                deque.push(root2);
                root2 = root2.next;
             } else {
                if (! deque.isEmpty()) {
                    deque.pop().next = root1;
                }
                deque.push(root1);
                root1 = root1.next;
            }

            if (root1 == null) {
                deque.pop().next = root2;
                break;
            }

            if (root2 == null) {
                deque.pop().next = root1;
                break;
            }
        }

        return r;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node4.next = node5;
        node5.next = node6;

        MergeTwoOrderedLinkedLists mergeTwoOrderedLinkedLists = new MergeTwoOrderedLinkedLists();
        System.out.println(mergeTwoOrderedLinkedLists.mergeTwoLists(node1, node4));
    }

}
