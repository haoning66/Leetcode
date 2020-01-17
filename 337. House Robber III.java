import java.util.*;

class Solution {
    //remember when use recursion for tree, can use a map or array for memo
    Map<TreeNode, Integer> map = new HashMap<>();
    public int rob(TreeNode root) {
        if (root == null)
            return 0;
        if (map.containsKey(root))
            return map.get(root);

        int sum1 = root.val + (root.left == null ? 0 : rob(root.left.left) + rob(root.left.right)) + (root.right == null ? 0 : rob(root.right.left) + rob(root.right.right));

        int sum2 = rob(root.left) + rob(root.right);
        int max = Math.max(sum1, sum2);
        map.put(root, max);
        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
    }
}
