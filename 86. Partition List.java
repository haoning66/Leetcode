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
    public ListNode partition(ListNode head, int x) {
        if (head == null)
            return head;
        
        ListNode less = new ListNode(-1);
        ListNode cur_l = less;
        ListNode greater = new ListNode(-1);
        ListNode cur_g = greater;
        
        while (head != null) {
            if (head.val < x) {
                cur_l.next = head;
                cur_l = cur_l.next;
            } else {
                cur_g.next = head;
                cur_g = cur_g.next;
            }
            head = head.next;
        }
        cur_g.next = null;
        cur_l.next = greater.next;
        
        return less.next;
    }
}