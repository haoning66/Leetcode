import java.util.*;

class Solution {
//    public void reorderList(ListNode head) {  initial solution, slow, dont know why
//        ListNode temp = head;
//        Map<Integer, ListNode> map = new HashMap<>();
//        int n = 0;
//        while (temp != null) {
//            map.put(n++, temp);
//            temp = temp.next;
//        }
//        n--;
//
//
//        temp = head;
//        int m = 1;
//        while (m <= n) {
//            if (m % 2 == 0)
//                temp.next = map.get(m / 2);
//            else
//                temp.next = map.get(n - m / 2);
//            m++;
//
//            temp = temp.next;
//        }
//
//        temp.next=null;
//    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy;     //use fast and slow pointer to find the middle element of the list
        ListNode fast = dummy;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode second_half_start = slow.next;   //the start of the second half list is slow.next
        slow.next = null;         //break the original list

        ListNode second_half_reverse = reverseList(second_half_start);   //reverse the second half

        ListNode temp = head;

        while (temp != null && second_half_reverse != null) {  //merge these two
            ListNode temp_next = temp.next;
            ListNode second_next = second_half_reverse.next;
            temp.next = second_half_reverse;
            second_half_reverse.next = temp_next;
            second_half_reverse = second_next;
            temp = temp_next;
        }

        ListNode x = head;
        while (x != null) {
            System.out.println(x.val);
            x = x.next;
        }
    }

    private ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode temp = head;
        ListNode next;
        while (temp != null) {
            next = temp.next;    //dont ListNode next = temp.next; here, it will become much slower, dont know why
            temp.next = pre;
            pre = temp;
            temp = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        s.reorderList(n1);

    }
}
