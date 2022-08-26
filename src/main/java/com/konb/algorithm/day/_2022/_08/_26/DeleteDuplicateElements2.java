package com.konb.algorithm.day._2022._08._26;

import com.konb.algorithm.day.ListNode;

/**
 * @author konb
 * @version 1.0
 * @date 2022-08-26 16:00
 */
public class DeleteDuplicateElements2 {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;
        boolean remove = false;

        while (temp != null) {
            if (temp.val == temp.next.val) {
                if (! remove) {
                    remove = true;
                }
                temp = temp.next;
            } else {
                if (remove) {

                }
            }
        }
    }

}
