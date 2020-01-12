import java.util.*;

class Solution {
    // public boolean hasCycle(ListNode head) {   //time: O(n) space O(n)
    //     Set<ListNode> set = new HashSet<>();
    //     while (head != null) {
    //         if (set.contains(head))
    //             return true;
    //         set.add(head);
    //         head = head.next;
    //     }
    //     return false;
    // }

    //space O(1) only use two pointers, the reason that if there is a cycle fast will be the same place of slow
    //is that when fast is one element behind slow it will catch up in the next iteration, and when fast is two three ... n elements behind
    //slow it will reduce the distance during each iteration, and eventually their distance will be one and will catch up
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return true;
        }
        return false;
    }
}