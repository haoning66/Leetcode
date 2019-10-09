import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}

class Solution{
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> list = new ArrayList<>();
        for(ListNode l : lists){
            while(l != null){
                list.add(l.val);
                l = l.next;
            }
        }
        Collections.sort(list);
        ListNode head = new ListNode(0);
        ListNode h = head;
        for(int i:list){
            ListNode t = new ListNode(i);
            h.next = t;
            h = h.next;
        }
        h.next = null;
        return head.next;
    }
}