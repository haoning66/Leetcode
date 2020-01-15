import java.util.*;

class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null)
            return null;
        else if (t1 == null && t2 != null)
            return t2;
        else if (t1 != null && t2 == null)
            return t1;
        else if (t1 != null && t2 != null) {
            TreeNode temp = t1;
            t1.val += t2.val;
            t1.left = mergeTrees(temp.left, t2.left);
            t1.right = mergeTrees(temp.right, t2.right);
        }
        return t1;
    }


    public static void main(String args[]) {
        Solution s = new Solution();
    }
}
