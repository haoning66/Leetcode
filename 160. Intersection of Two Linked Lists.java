import java.util.*;

class Solution {
    //let a be headA and b be headB, move to the next element during each iteration, when a reach the end of A let a be headB
    //and when b reach the end of B, let b be headA, the distance between a and b is caused by the length of A and B before the intersection
    //if switch their route, one pointer will catch up the other pointer, and the only possibility is that they meet at the intersection
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        ListNode a = headA;
        ListNode b = headB;
        ListNode lastA = null;
        ListNode lastB = null;
        while (a != b) {
            if (lastA != null && lastB != null) {
                if (lastA != lastB)
                    return null;
            }
            if (a.next == null) {
                lastA = a;
                a = headB;
            }
            else
                a = a.next;
            if (b.next == null) {
                lastB = b;
                b = headA;
            }
            else
                b = b.next;

        }
        return a;
    }
}