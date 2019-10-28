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
    public boolean findTarget(TreeNode root, int k) {
        if (root == null)
            return false;
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        int i = 0;
        int j = list.size() - 1;
        while (j > i) {
            int sum = list.get(i) + list.get(j);
            if(sum<k)
                i++;
            else if(sum>k)
                j--;
            else
                return true;
        }
        return false;

    }

    private void helper(TreeNode cur, List<Integer> list) {
        if (cur == null)
            return;
        if (cur.left != null)
            helper(cur.left, list);
        list.add(cur.val);
        if (cur.right != null)
            helper(cur.right, list);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
    }
}