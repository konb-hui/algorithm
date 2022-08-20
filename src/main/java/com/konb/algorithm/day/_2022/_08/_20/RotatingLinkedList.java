package com.konb.algorithm.day._2022._08._20;

import com.konb.algorithm.day.ListNode;

/**
 * @author konb
 * @version 1.0
 * @date 2022-08-20 14:21
 * leetcode 61 旋转链表
 */
public class RotatingLinkedList {

    public ListNode rotateRight(ListNode head, int k) {

        if (k == 0) {
            return head;
        }

        int size = sum(head);
        if (size == 0) {
            return head;
        }
        if (k % size == 0) {
            return head;
        }

        int step = k % size;

        int index = size - step;

        int count = 1;
        ListNode temp = head;
        while (count < index) {
            temp = temp.next;
            count ++;
        }
        ListNode r = temp.next;
        temp.next = null;
        ListNode l = r;
        while (l.next != null) {
            l = l.next;
        }
        l.next = head;
        return r;
    }

    private int sum(ListNode head) {
        int count = 0;
        ListNode temp = head;
        while (temp != null) {
            count ++;
            temp = temp.next;
        }
        return count;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        RotatingLinkedList rotatingLinkedList = new RotatingLinkedList();
        System.out.println(rotatingLinkedList.rotateRight(listNode1, 2));
    }

}
