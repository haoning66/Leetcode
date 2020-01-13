import java.util.*;

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return root;
        helper(root);
        return root;
    }

    private void helper(TreeNode cur) {
        if (cur.left == null && cur.right == null)
            return;
        TreeNode temp = cur.right;
        cur.right = cur.left;
        cur.left = temp;
        if (cur.left != null)
            helper(cur.left);
        if (cur.right != null)
            helper(cur.right);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
    }

}