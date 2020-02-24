import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        List<Integer> cur = new ArrayList<>();
        cur.add(root.val);
        helper(root, res, cur, root.val, sum);
        return res;
    }

    private void helper(TreeNode root, List<List<Integer>> res, List<Integer> cur, int cur_sum, int sum) {
        if (root.right == null && root.left == null) {
            if (cur_sum == sum) {
                res.add(new ArrayList<>(cur));
            }
            return;
        }

        if (root.left != null) {
            cur.add(root.left.val);
            helper(root.left, res, cur, cur_sum + root.left.val, sum);
            cur.remove(cur.size() - 1);
        }

        if (root.right != null) {
            cur.add(root.right.val);
            helper(root.right, res, cur, cur_sum + root.right.val, sum);
            cur.remove(cur.size() - 1);
        }
    }


    public static void main(String[] args) {
        Solution s = new Solution();
    }
}
