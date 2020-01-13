import java.util.*;

class Solution {
    // public ListNode detectCycle(ListNode head) {  slow
    //     Set<ListNode> set = new HashSet<>();
    //     while (head != null) {
    //         if (set.contains(head))
    //             return head;
    //         set.add(head);
    //         head = head.next;
    //     }
    //     return null;
    // }

    public ListNode detectCycle(ListNode head) {  //brilliant slow fast pointer solution
        if (head == null || head.next == null)    //not easy to explain, go to https://www.cnblogs.com/hiddenfox/p/3408931.html
            return null;

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow)
                break;
        }

        if (fast != slow)
            return null;

        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return fast;
    }
}