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
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        res.add(root.val);
        findElement(root.left, res, true, false);
        findElement(root.right, res, false, true);
        return res;
    }

    private void findElement(TreeNode cur, List<Integer> res, boolean leftboundary, boolean rightboundary) {
        if (cur == null)
            return;

        if (cur.left == null && cur.right == null) {
            res.add(cur.val);
            return;
        }

        if (leftboundary == true)
            res.add(cur.val);

        findElement(cur.left, res, cur.left != null && leftboundary, cur.right == null && rightboundary);
        findElement(cur.right, res, cur.left == null && leftboundary, cur.right != null && rightboundary);

        if(rightboundary)
            res.add(cur.val);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("hello");
    }
}