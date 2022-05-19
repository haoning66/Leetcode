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
import java.util.*;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if(n == 0)
            return null;
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        // How comparator works:
        // compare(a, b): if return < 0 -> a < b, 
        //                if return > 0 -> b > a,
        //                if return = 0 -> b == a,
        // and dont forget it follows ascending order by default (smaller element has higher priority)
        
        for(ListNode l : lists) {
            if(l != null)
                pq.add(l);
        }
        
        ListNode dummy = new ListNode(-1);
        ListNode temp = null;
        ListNode cur = dummy;
        
        while(!pq.isEmpty()) {
            temp = pq.poll();
            cur.next = temp;
            
            if(temp.next != null)
                pq.add(temp.next);
            cur = cur.next;
            
        }
        return dummy.next;
    }
    
//  Note: There is also a divide and conquer merge solution, basically the same as merge sort, 
// Time complexity: O(klogn), the dumb solution below is O(k * n)
//
//     public ListNode mergeKLists(ListNode[] lists) {
//         int n = lists.length;
//         if(n == 0)
//             return null;
        
//         if(n == 1)
//             return lists[0];
        
//         ListNode dummy = new ListNode(-1);
//         dummy.next = lists[0];
        
//         for(int i = 1; i < n; i++) {
//             dummy.next = merge(dummy.next, lists[i]);
//         }
        
//         return dummy.next;
//     }
    
//     public ListNode merge(ListNode a, ListNode b) {
//         ListNode dummy = new ListNode(-1);
//         ListNode cur = dummy;
        
//         while(a != null && b != null) {
//             if(a.val <= b.val) {
//                 cur.next = a;
//                 a = a.next;
//             } else {
//                 cur.next = b;
//                 b = b.next;
//             }
//             cur = cur.next;
//         }
        
//         if(a != null)
//             cur.next = a;
        
//         if(b != null)
//             cur.next = b;
        
//         return dummy.next;
//     }
}