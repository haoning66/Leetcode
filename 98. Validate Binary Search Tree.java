import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    private boolean helper(TreeNode cur, Integer lower, Integer upper) {
        if (cur == null)
            return true;
        boolean cur_is_valid = (lower == null ? true : cur.val > lower) && (upper == null ? true : cur.val < upper);

        return cur_is_valid && helper(cur.left, lower, new Integer(cur.val)) && helper(cur.right, new Integer(cur.val), upper);
    }

    /*
    * Instead of checking the cur node with its left child and right child we check the cur node with its lower and upper boundary
    * each node in BST should have a boundary, for the root node there is no boundary and when we go left, its upper bound will change
    * when we go right its lower bound will change. If we keep going left it will have no lower bound
    * for each node, we just have to compare it with its lower bound and upper bound, we dont have to worry about its parent node, and when
    * we call the function recursively, just update the boundary
    * */
}