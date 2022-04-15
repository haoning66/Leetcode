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
    public ListNode insertionSortList(ListNode head) {
        if (head.next == null)
            return head;
        
        ListNode dummy = new ListNode(-9999);
        dummy.next = head;
        ListNode cur = head.next;  // the first node is considered sorted
        ListNode prev = head;    //prev is the prev of cur, cur is the cur of the original list
        ListNode sPrev, sCur = null;  //sPrev is the prev of sCur, sCur is the cur of the already sorted part
        
        while (cur != null) {
            if (cur.val >= prev.val) { //if cur >= prev, it should appear last of the sorted part
                prev = cur;
                cur = cur.next;
            } else {          // else find a place to insert it
                sPrev = dummy;
                sCur = dummy.next;
                
                while (cur.val > sCur.val) {
                    sPrev = sCur;
                    sCur = sCur.next;
                }
                
                prev.next = cur.next;
                cur.next = sCur;
                sPrev.next = cur;
                cur = prev.next;
            }
        }
        
        return dummy.next;
    }
}