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
    public ListNode swapPairs(ListNode head) {
        if (head == null) return head;
        
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = cur.next;
        
        while (next != null) {
            cur.next = next.next;
            next.next = cur;
            
            if (prev != null) {      // means cur not the head
                prev.next = next;    
            } else {                 // cur is the head
                head = next;
            }
            
            prev = cur;
            cur = cur.next;
            
            if (cur == null) {   // reach the tail
                break;
            }
            
            next = cur.next;
        }
        return head;
    }
}



