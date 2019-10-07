import apple.laf.JRSUIUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> result = new ArrayList<>();
//        if (root == null)
//            return result;
//        dfs(root, result);
//
//        return result;
//    }
//
//    private void dfs(TreeNode cur, List<Integer> result) {
//        if(cur.left != null)
//            dfs(cur.left, result);
//        result.add(cur.val);
//        if(cur.right != null)
//            dfs(cur.right, result);
//    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root == null) {
            return result;
        }
        TreeNode cur = root;
        while(!stack.isEmpty() || cur != null){
            if(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            else{
                TreeNode temp = stack.pop();
                result.add(temp.val);
                cur = temp.right;
            }
        }
        return result;
    }
}