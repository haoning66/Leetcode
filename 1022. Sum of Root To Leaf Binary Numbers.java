import java.util.*;

class Solution {
    public int sumRootToLeaf(TreeNode root) {
        return helper(root, 0);

    }

    private int helper(TreeNode cur, int sum) {
        if (cur == null)
            return 0;

        sum = sum * 2 + cur.val;     //how to convert binary to decimal

        if (cur.left == null && cur.right == null)
            return sum;

        return helper(cur.left, sum) + helper(cur.right, sum);
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        
    }
}