class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode pre = sentinel;
        ListNode cur = head;
        while(cur != null){
            if(cur.val == val)
                pre.next = cur.next;
            else
                pre = cur;
            cur = cur.next;
        }
        return sentinel.next;
    }
}

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
    }
}