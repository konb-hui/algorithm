package com.konb.algorithm.linear.list;

import java.util.List;

/**
 * @author konb
 * @version 1.0
 * @date 2022-06-30 10:41
 */
public class SeparateLinkedList {

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode partition(ListNode head, int x) {

        ListNode lastSmallNode = null;

        ListNode node = head;

        ListNode prev = null;

        while (node != null) {
            if (node.val < x) {
                if (lastSmallNode == null) {
                    if (prev == null) {
                        lastSmallNode = node;
                    } else {
                        lastSmallNode = node;
                        prev.next = node.next;
                        node.next = head;
                    }
                    head = lastSmallNode;

                } else {
                    prev.next = node.next;
                    node.next = lastSmallNode.next;
                    lastSmallNode.next = node;
                    lastSmallNode = node;
                }
            }
            prev = node;
            node = node.next;
        }

        return head;

    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(2);
        ListNode listNode1 = new ListNode(1);
//        ListNode listNode2 = new ListNode(3);
//        ListNode listNode3 = new ListNode(2);
//        ListNode listNode4 = new ListNode(5);
//        ListNode listNode5 = new ListNode(2);

        listNode.next = listNode1;
//        listNode1.next = listNode2;
//        listNode2.next = listNode3;
//        listNode3.next = listNode4;
//        listNode4.next = listNode5;

        SeparateLinkedList separateLinkedList = new SeparateLinkedList();
        ListNode node = separateLinkedList.partition(listNode, 2);

        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

}
