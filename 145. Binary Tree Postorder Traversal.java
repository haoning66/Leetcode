/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        
        if(root == null)
            return list;
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        while(!stack.empty()) {     // LRM is hard, we do a reversed MRL
            root = stack.pop();
            list.add(0, root.val);          //M
            
            if(root.left != null)           // L, but it is a stack L first in, L last out
                stack.push(root.left);
            
            if(root.right != null)          // R, R gets out before L
                stack.push(root.right);       
        }
        
        return list;
    }
}