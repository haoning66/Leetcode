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
    public ListNode[] splitListToParts(ListNode head, int k) {
        if (head == null)
            return  new ListNode[k];
        
        ListNode cur = head;
        int n = 0;
        
        while(cur != null) {
            cur = cur.next;
            n++;
        }
        cur = head;
        
        int d = n / k;         // how many element in one partition
        int r = n % k;       // first r partitions need to add one extra element
        int tk = k;          // which partition is this
        int td = d;          // which element of this partition
        ListNode temp = null;
        ListNode next = null;
        ListNode[] res = new ListNode[k];
        
        while(tk > 0 && cur != null) {
            td = d;
            temp = cur;
            
            while(td > 1) {
                cur = cur.next;
                td--;
            }
            
            if (r-- > 0) {
                if (d == 0) {          // no regular element to add, only extra ones
                    next = cur.next;
                    cur.next = null;
                    res[k - tk] = temp;
                    cur = next;
                    tk--;
                    continue;
                } else {
                cur = cur.next;
                }
            }
            
            next = cur.next;
            cur.next = null;
            res[k - tk] = temp;
            cur = next;
            tk--;
        }
        
        return res;
    }
}