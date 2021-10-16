class Solution {
    // iteration way, the linked list gets built top to bottom, the right node get pushed first
    // because then the left node stays on top of the stack and then it gets poped first
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            
            if (cur.right != null)
                stack.push(cur.right);
            
            if (cur.left != null) 
                stack.push(cur.left);
            
            // for the last node, the stack will be empty
            if (!stack.isEmpty())
                cur.right = stack.peek();
            
            cur.left = null;
        }
        return;
    }

    // recursive, the function stack keeps track of the visit route, the list gets built bottom up
    TreeNode prev = null;
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        
        flatten(root.right);
        flatten(root.left);
        
        root.right = prev;
        root.left = null;
        prev = root;
    }
}
