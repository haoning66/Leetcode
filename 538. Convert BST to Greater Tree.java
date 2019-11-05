import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {

    //    public TreeNode convertBST(TreeNode root) {   //perform reverse in-order traversal
//        helper(root);
//        return root;
//    }
//
//    private void helper(TreeNode cur) {
//        if (cur == null)
//            return;
//        if (cur.right != null)
//            helper(cur.right);
//        sum += cur.val;
//        cur.val = sum;
//        if (cur.left != null)
//            helper(cur.left);
//    }


    public TreeNode convertBST(TreeNode root) {   //iteration version, much slower
        int sum=0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(!stack.isEmpty() || cur!=null){
            if(cur!=null){
                stack.push(cur);
                cur = cur.right;
            }
            else{
                TreeNode temp = stack.pop();
                sum+=temp.val;
                temp.val = sum;
                cur = temp.left;
            }
        }
        return root;
    }

}