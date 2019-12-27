import javafx.util.Pair;

import java.util.*;


class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode newhead = head.next;
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = null;

        while (cur != null) {
            next = cur.next;

            if (next != null) {    //number of nodes may not be even
                ListNode temp = next.next;
                cur.next = temp;
                next.next = cur;
            }

            if (pre != null && next != null) {
                pre.next = next;
            }

            pre = cur;
            cur = cur.next;
        }
        return newhead;
    }
}
