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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode right = sortList(slow.next); // slow is the tail of the left list
        slow.next = null;
        ListNode left = sortList(dummy.next);
        
        merge(dummy, left, right);
        
        return dummy.next;
    }
    
    public void merge(ListNode dummy, ListNode left, ListNode right) {
        ListNode cur = dummy;
        
        while (left != null && right != null) {
            if (left.val <= right.val) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        
        if (left != null)
            cur.next = left;
        
        if (right != null)
            cur.next = right;
    }
}