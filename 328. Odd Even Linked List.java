/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        
        ListNode oh = head;
        ListNode eh = new ListNode(-1);
        ListNode oc = oh;
        ListNode ec = eh;
        
        while (oc.next != null) {
           
                if (oc.next.next != null) {
                    ec.next = oc.next;
                    oc.next = oc.next.next;
                    oc = oc.next;
                    ec = ec.next;
                    ec.next = null;
                } else {
                    ec.next = oc.next;
                    oc.next = null;
                }
            }
        oc.next = eh.next;
        
        return oh;
    }
}