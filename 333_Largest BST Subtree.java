class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}


class Solution {
    public int largestBSTSubtree(TreeNode root) {
        if (root == null)
            return 0;

        Integer[] res = dfs(root);

        return res[1];    //res[if it is a bst,size of bst, min value of bst,max value of bst]
    }

    private Integer[] dfs(TreeNode cur) {
        if (cur == null)
            return new Integer[]{1, 0, null, null};
        if (cur.left == null && cur.right == null)
            return new Integer[]{1, 1, cur.val, cur.val};

        Integer[] left = dfs(cur.left);
        Integer[] right = dfs(cur.right);

        if (left[0] == 0 || right[0] == 0 || (left[3] != null && left[3] >= cur.val) || (right[2] != null && right[2] <= cur.val))
            return new Integer[]{0, Math.max(left[1], right[1]), null, null};

        return new Integer[]{1, 1 + left[1] + right[1], left[2] == null ? cur.val : left[2], right[3] == null ? cur.val : right[3]};

    }
}