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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        dummy.next = list1;
        ListNode cur = dummy;
        ListNode tmp = null;
        int t = a;
        
        while(cur != null && t > 0) {
            cur = cur.next;
            t--;
        }
        
        tmp = cur.next;
        cur.next = list2;
        cur = tmp;
        t = b - a + 1;
        
        while(t > 0) {
            cur = cur.next;
            t--;
        }
        
        tmp = cur;
        cur = list2;
        
        while(cur.next != null) {
            cur = cur.next;
        }
        cur.next = tmp;
        
        return dummy.next;
    }
}