import java.util.*;

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        TreeNode left;
        TreeNode right;
        while (!queue.isEmpty()) {
            left = queue.poll();
            right = queue.poll();
            if (left == null && right == null)
                continue;
            else if (left == null || right == null)
                return false;

            if (left.val != right.val)
                return false;
            else {
                queue.offer(left.left);
                queue.offer(right.right);
                queue.offer(left.right);
                queue.offer(right.left);
            }
        }
        return true;
    }


//     public boolean isSymmetric(TreeNode root) { recursive
//         if (root == null)
//             return true;
//         return helper(root.left, root.right);
//     }

//     private boolean helper (TreeNode left, TreeNode right) {
//         if (left == null && right == null)
//             return true;
//         if (left == null || right == null)
//             return false;
//         if (left.val == right.val)
//             return helper(left.left, right.right) && helper(left.right, right.left);
//         else return false;
//     }
}