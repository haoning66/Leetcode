class MyLinkedList {
    Node head;
    Node tail;
    int length;

    public MyLinkedList() {
        this.length = 0;
        this.head = null;
        this.tail = null;
    }
    
    public int get(int index) {
        if(index > this.length - 1)
            return -1;
        else {
            Node cur = head;
            while (index > 0) {
                cur = cur.next;
                index--;
            }
            
            return cur.val;
        }
    }
    
    public void addAtHead(int val) {
        Node node = new Node(val);
        
        if(this.length == 0) {
            this.head = node;
            this.tail = node;
        } else {
            node.next = this.head;
            this.head = node;
        }
        this.length++;
    }
    
    public void addAtTail(int val) {
        Node node = new Node(val);
        
        if(this.length == 0) {
            this.head = node;
            this.tail = node;
        } else {
            this.tail.next = node;
            this.tail = node;
        }
        this.length++;
    }
    
    public void addAtIndex(int index, int val) {
        if(index == this.length) {
            addAtTail(val);
        } else if(index > this.length) {
            return;
        } else if(index == 0) {
            addAtHead(val);
        } else {
            Node cur = this.head;
            Node nn = new Node(val);
            
            while (index > 1) {
                cur = cur.next;
                index--;
            }
            
            nn.next = cur.next;
            cur.next = nn;
            this.length++;
        }
    }
    
    public void deleteAtIndex(int index) {
        if(index > length - 1)
            return;
        else if(index == 0) {
            Node nh = head.next;
            head.next = null;
            head = nh;
            this.length--;
            if (this.length == 1) {
                tail = head;
            }
        } else {
            int i = index;
            Node cur = head;
            while(i > 1) {
                cur = cur.next;
                i--;
            }
            
            if (index == this.length - 1) {
                cur.next = null;
                tail = cur;
            } else {
                cur.next = cur.next.next;
            }
            this.length--;
            
            if (this.length == 1) {
                head = tail;
            }
        }
        
    }
}

class Node {
    int val;
    Node next;
    
    public Node(int val) {
        this.val = val;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */