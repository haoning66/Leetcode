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
//     public List<Integer> preorder(Node root) {
//         List<Integer> list = new ArrayList<>();
        
//         if(root == null)
//             return list;
        
//         helper(list, root);
        
//         return list;
//     }
    
//     public void helper(List<Integer> list, Node root) {
//         list.add(root.val);
        
//         if(root.children != null) {
//             for(int i = 0; i < root.children.size(); i++) {
//                 Node child = root.children.get(i);
//                 helper(list, child);
//             }
//         }
//     }
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        
        if(root == null)
            return list;
        
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        int size = 0;
        
        while(!stack.isEmpty()) {
            root = stack.pop();
            list.add(root.val);
            
            if(root.children != null) {
                for(int i = root.children.size() - 1; i >= 0; i--) {
                    if(root.children.get(i) != null) {
                        stack.push(root.children.get(i));
                    }
                }
            }
        }
        
        return list;
    }  
}