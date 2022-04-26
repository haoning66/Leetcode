/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA ==  null || headB == null)
            return null;
        
        ListNode la = headA;
        ListNode lb = headB;
        
        int a = 0;
        int b = 0;
        
        while(la != null) {
            a++;
            la = la.next;
        }
        
        while(lb != null) {
            b++;
            lb = lb.next;
        }
        
        la = headA;
        lb = headB;
        
        if(a > b) {
            a = a - b;
            
            while(a > 0) {
                la = la.next;
                a--;
            }
        } else if(b > a) {
            b = b - a;

            while(b > 0) {
                lb = lb.next;
                b--;
            }
        }
        
        while(la != lb && la != null && lb != null) {
            la = la.next;
            lb = lb.next;
        }
        
        if(la == lb)
            return la;
        else
            return null;
    }
}