import java.util.*;

class Solution {
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {  //this function is used to control the level of root2
        if (root1 == null || root2 == null)
            return false;
        return helper(root1, target - root2.val) || twoSumBSTs(root1, root2.left, target) || twoSumBSTs(root1, root2.right, target);
    }
    //immobilize one tree and search the other

    private boolean helper(TreeNode root1, int target) { //this function is used to search root1
        if (root1 == null)
            return false;
        if (root1.val == target)
            return true;
        else if (root1.val > target)
            return helper(root1.left, target);
        else
            return helper(root1.right, target);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode n1 = new TreeNode(0);
        TreeNode n2 = new TreeNode(-10);
        TreeNode n3 = new TreeNode(10);
        TreeNode n4 = new TreeNode(5);
        TreeNode n5 = new TreeNode(1);
        TreeNode n6 = new TreeNode(7);
        TreeNode n7 = new TreeNode(0);
        TreeNode n8 = new TreeNode(2);
        n1.left = n2;
        n1.right = n3;
        n4.left = n5;
        n4.right = n6;
        n6.left = n7;
        n6.right = n8;
        System.out.println(s.twoSumBSTs(n1, n4, 18));

    }
}