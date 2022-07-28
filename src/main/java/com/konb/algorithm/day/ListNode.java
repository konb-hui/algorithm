package com.konb.algorithm.day;

/**
 * @author konb
 * @version 1.0
 * @date 2022-07-28 16:23
 */
public class ListNode {

    public int val;

    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
