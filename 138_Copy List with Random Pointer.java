import javafx.util.Pair;

import java.util.HashMap;


class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> nodeMap = new HashMap<>();
        Node currNode = head;
        while (currNode != null) {
            nodeMap.put(currNode, new Node(currNode.val));
            currNode = currNode.next;
        }

        currNode = head;
        while (currNode != null) {
            nodeMap.get(currNode).next = nodeMap.get(currNode.next);
            nodeMap.get(currNode).random = nodeMap.get(currNode.random);
            currNode = currNode.next;
        }
        return nodeMap.get(head);

    }


    public static void main(String[] args) {
        Solution s = new Solution();
        Node n1 = new Node();
        n1.val = 1;
        Node n2 = new Node();
        n2.val = 2;
        n1.next = n2;
        n2.next = null;
        n1.random = n2;
        n2.random = n2;
        Node temp = s.copyRandomList(n1);


    }
}

class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {
    }

    public Node(int _val, Node _next, Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
}

