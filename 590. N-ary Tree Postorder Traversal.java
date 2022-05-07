/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        
        if(root == null) {
            return list;
        }
        
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        int size = 0;
        
        while(!stack.isEmpty()) {
            root = stack.pop();
            list.add(0, root.val);
            
            if(root.children != null) {
                size = root.children.size();
                
                for(int i = 0; i < size; i++) {
                    stack.push(root.children.get(i));
                }
            }
        }
        
        return list;
    }
}