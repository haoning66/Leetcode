import javafx.util.Pair;

import java.util.*;


class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;

        for (int i = 0; i < n; i++) {
            first = first.next;
        }

        while (first.next != null) {
            second = second.next;
            first = first.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {

    }

}
