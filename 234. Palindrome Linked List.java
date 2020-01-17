import java.util.*;

class Solution {
    //slow fast pointer solution, reverse the first half of the list, compare with the second half
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;
        ListNode fast = head;
        ListNode slow = head;
        ListNode slow_pre = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            ListNode slow_next = slow.next;
            slow.next = slow_pre;
            slow_pre = slow;
            slow = slow_next;
        }

        if (fast != null)        //if fast != null, means the length of the linkedlist is odd, move slow to its next
            slow = slow.next;

        while (slow_pre != null && slow != null && slow_pre.val == slow.val) {
            slow_pre = slow_pre.next;
            slow = slow.next;
        }
        return slow == null && slow_pre == null;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
    }
}
