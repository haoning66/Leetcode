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
    private int res;

    public int diameterOfBinaryTree(TreeNode root) {
        res = 0;
        helper(root);
        return res;
    }

    private int helper(TreeNode cur) {  //this can also be used to find the max depth of a binary tree
        if (cur == null)                //the return value of this function represents the maximum number of paths from this node or its children to
                                        //its parent nodes.
            return 0;                   //                  1
                                         //                / \
        int left = helper(cur.left);     //               2  3
        int right = helper(cur.right);  //               / \
        res = Math.max(res, left + right);//            4  5       the return value of 4,5 is 1, the return value of 2 is 2, the return value of 3 is 1
                                             //for each of the node if its left+right is bigger than res than res=left+right, so that at each intersection it will check whether
                                             //there exist a longer path
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode a1 = new TreeNode(1);
        TreeNode a2 = new TreeNode(1);
        TreeNode a3 = new TreeNode(1);
        TreeNode a4 = new TreeNode(1);
        TreeNode a5 = new TreeNode(1);
        TreeNode a6 = new TreeNode(1);
        TreeNode a7 = new TreeNode(1);
        a1.left = a2;
        a1.right = a3;
        a2.left = a4;
        a2.right = a5;
        a4.left = a6;
        a6.left = a7;
        System.out.println(s.diameterOfBinaryTree(a1));
    }

}


