import java.util.*;

class Solution {
    int result = 0;    

    public int maxAncestorDiff(TreeNode root) {
        if (root == null)
            return 0;
        helper(root);
        return result;

    }

    private int[] helper(TreeNode cur) {
        if (cur.left == null && cur.right == null)
            return new int[]{cur.val, cur.val};

        int min;
        int max;

        if (cur.left == null) {
            int[] right = helper(cur.right);
            min = right[0];
            max = right[1];
        } else if (cur.right == null) {
            int[] left = helper(cur.left);
            min = left[0];
            max = left[1];
        } else {
            int[] left = helper(cur.left);
            int[] right = helper(cur.right);
            min = Math.min(left[0], right[0]);
            max = Math.max(left[1], right[1]);
        }

        result = Math.max(Math.max(Math.abs(cur.val - min), Math.abs(cur.val - max)), result);

        return new int[]{Math.min(min, cur.val), Math.max(max, cur.val)};
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(0);
        TreeNode n4 = new TreeNode(3);
        n1.right = n2;
        n2.right = n3;
        n3.left = n4;
        Solution s = new Solution();
        System.out.println(s.maxAncestorDiff(n1));
    }
}