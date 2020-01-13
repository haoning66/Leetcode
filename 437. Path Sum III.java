import java.util.*;

class Solution {
    public int pathSum(TreeNode root, int sum) {
        if (root == null)
            return 0;
        return pathSum(root.left, sum) + pathSum(root.right, sum) + findPath(root, sum);
    }
    //the function pathSum is how many ways to get the sum with the root(root may not be contained in the path)

    private int findPath(TreeNode cur, int cur_sum) {
        if (cur == null) //the base case is the node is null, we cannot use cur_sum < 0 is a base case because there may be negative elements, and even if cur_sum = 0, the recursion has to go on
            return 0;
        return (cur.val == cur_sum ? 1: 0) + findPath(cur.left, cur_sum - cur.val) + findPath(cur.right, cur_sum - cur.val);
    }

    //this function is how many ways to get the cur_sum with the node cur contained in the path


    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode a1 = new TreeNode(0);
        TreeNode a2 = new TreeNode(1);
        TreeNode a3 = new TreeNode(1);
        a1.left = a2;
        a2.right = a3;
        System.out.println(s.pathSum(a1, 1));
    }

}