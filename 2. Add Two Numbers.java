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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        int carry = 0;
        int sum = 0;
        int v1, v2 = 0;
        
        while(l1 != null || l2 != null) {
            v1 = l1 == null? 0 : l1.val;   // even if one list is null, use 0 as its value to keep them going
            v2 = l2 == null? 0 : l2.val;
            
            sum = v1 + v2 + carry;
            carry = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);
            
            if(l1 != null) l1 = l1.next;
            
            if(l2 != null) l2 = l2.next;
            cur = cur.next;
        }
        
        if(carry != 0) {
            cur.next = new ListNode(carry);
        }
        
        return dummy.next;
    }
}