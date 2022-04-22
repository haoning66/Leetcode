/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten_h(Node head) {
        if(head == null)
            return head;
        Node cur = head;
        Node next, tail = null;
        
        while(cur != null) {
            if (cur.child != null) {
                next = cur.next;
                tail = flatten_h(cur.child);
                cur.next = cur.child;
                cur.child.prev = cur;
                cur.child = null;
                tail.next = next;
                if(next != null) {                // two conditions here: 1. cur.next != null, the loop goes on 
                   next.prev = tail; 
                } else {                          // cur.next == null, because cur.child != null (otherwise we wont enter here), the tail became 'tail' which is the tail
                    return tail;                  // of the flattened child list
                }
                
                cur = next;
            } else {
                if(cur.next == null) {            // also two conditions, 1. cur.next != null, loop goes on
                    return cur;                   // 2. cur.next == null, the tail is 'cur'
                } else { 
                    cur = cur.next;
                }
            }
        }
        return head;
    }
    
    public Node flatten(Node head) {
        flatten_h(head);
        
        return head;
    }
}