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

//https://www.youtube.com/watch?v=1UOPsfP85V4

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode groupPrev = dummy;        // the previous node of the current group, but it does not belong to cur group
        ListNode groupNext = null;
        ListNode prev, cur, next, newTail = null;
        
        while(true) {
            ListNode kth = getKth(groupPrev, k);
            if (kth == null)
                break;
            groupNext = kth.next;
            
            // reverse
            prev = groupNext;  // if like the easy reverse linked list, and set prev=null, we will end up spliting the list, set this to groupNext to stay connected
            cur = groupPrev.next;  // the head of the cur group
            
            while(cur != groupNext) {
                next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            }
            
            newTail = groupPrev.next;  // newTail used to be the head of the cur group, but after reversal, it is the tail of the current group
            groupPrev.next = kth;    // kth is the new head after reverse
            groupPrev = newTail;
        }
        
        return dummy.next;
    }
    
    public ListNode getKth(ListNode head, int k) {
        while(head != null && k > 0) {
            head = head.next;
            k--;
        }
        
        return head;
    }
}