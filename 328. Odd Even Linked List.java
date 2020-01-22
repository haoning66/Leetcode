import java.util.*;

class Solution {
//    public ListNode oddEvenList(ListNode head) {  slow, slow, slow
//        if (head == null || head.next == null)
//            return head;
//        int n = 1;
//        ListNode odd = new ListNode(-1);
//        ListNode to = odd;
//        ListNode even = new ListNode(-1);
//        ListNode eo = even;
//
//        while (head != null) {
//            if (n % 2 != 0) {
//                to.next = head;
//                to = to.next;
//            } else {
//                eo.next = head;
//                eo = eo.next;
//            }
//            head = head.next;
//            n++;
//            if (head == null) {
//                to.next = null;
//                eo.next = null;
//            }
//        }
//
//        odd = odd.next;
//        even = even.next;
//        to.next = even;
//        return odd;
//    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode mid = even;
        while (odd.next != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = mid;
        return head;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(5);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
        s.oddEvenList(a1);
    }

}
