import java.util.*;

class Solution {

    //merge sort solution, the idea of merge sort is to divide the list into two parts, sort each part
    //the interval will keep getting smaller util there is only one element, then merge two parts together
    //the method to merge two parts is same as merge sorted list
    //time: O(nlogn) space: o(n) originally, but o(1) for linkedlist
    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null)
            return head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) { //use slow fast pointer to divide the list into two parts
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode right = sortList(slow.next);
        slow.next = null;
        ListNode left = sortList(head);

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;      //space originally should be o(n) because to merge the list, if for array we have
                                    //to use a temp array to store the element, but for linkedlist we only have to use a node

        while (left != null && right != null) {
            if (left.val < right.val) {
                temp.next = left;
                left = left.next;
                temp = temp.next;
            } else {
                temp.next = right;
                right = right.next;
                temp = temp.next;
            }
        }

        if (left == null)  //small elements in left are all used, but elements are left in right
            temp.next = right;
        else
            temp.next = left;  //small elements in right are all used, still elements in left
        return dummy.next;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode a1 = new ListNode(4);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(1);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        ListNode x = s.sortList(a1);
        while (x != null) {
            System.out.println(x.val);
            x = x.next;
        }
    }
}
