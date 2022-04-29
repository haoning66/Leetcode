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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        
        while(l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        
        while(l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        
        int sum = 0;
        int carry = 0;
        int l1_val = 0;
        int l2_val = 0;
        ListNode cur = null;
        ListNode dummy = new ListNode(-1);
        
        while(!s1.empty() || !s2.empty() || carry != 0) {
            l1_val = s1.empty() ? 0 : s1.pop();
            l2_val = s2.empty() ? 0 : s2.pop();
            sum = l1_val + l2_val + carry;
            carry = sum / 10;
            sum = sum % 10;
            cur = new ListNode(sum);
            cur.next = dummy.next;     // 链表头插法
            dummy.next = cur;
        }
        
        return dummy.next;
    }
}