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
    private int L;
    private int R;
    private int sum = 0;

    public int rangeSumBST(TreeNode root, int L, int R) {
        this.L = L;
        this.R = R;
        helper(root);
        return sum;
    }

    private void helper(TreeNode root) {
        if (root == null)
            return;
        if (root.val < L)
            helper(root.right);
        else if (root.val > R)
            helper(root.left);
        else {
            sum += root.val;
            helper(root.left);
            helper(root.right);
        }
    }
}