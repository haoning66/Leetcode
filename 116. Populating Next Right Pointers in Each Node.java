import java.util.*;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

class Solution {
//    public Node connect(Node root) {      recursive approach, really cool
//        if (root == null)
//            return root;
//        connect(root.left, root.right);
//        return root;
//    }
//
//    private void connect(Node left, Node right) {
//        if (left == null)
//            return;
//        left.next = right;
//        connect(left.left, left.right);
//        connect(left.right, right.left);
//        connect(right.left, right.right);
//    }

    public Node connect(Node root) {     //iteration solution, also good
        if (root == null)
            return root;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node temp = queue.poll();
                if (temp.left != null)
                    queue.offer(temp.left);
                if (temp.right != null)
                    queue.offer(temp.right);
                if (i < size - 1)
                    temp.next = queue.peek();
            }
        }
        return root;
    }
}