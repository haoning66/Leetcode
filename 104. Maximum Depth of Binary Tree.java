import java.util.*;

class Solution {
    //     public int maxDepth(TreeNode root) {  slower iterative solution
//         if (root == null)
//             return 0;
//         Queue<TreeNode> queue = new LinkedList<>();
//         queue.add(root);
//         int level = 0;
//         int size;

    //         while (!queue.isEmpty()) {
//             size = queue.size();
//             for (int i = 0; i < size; i++) {
//                 TreeNode temp = queue.poll();
//                 if (temp.left != null)
//                     queue.offer(temp.left);
//                 if (temp.right != null)
//                     queue.offer(temp.right);
//             }
//             level += 1;
//         }
//         return level;
//     }
    
    int level = 0;

    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        helper(root, 1);
        return level;
    }

    private void helper(TreeNode cur, int cur_level) {
        level = Math.max(level, cur_level);
        if (cur.left != null)
            helper(cur.left, cur_level + 1);
        if (cur.right != null)
            helper(cur.right, cur_level + 1);
    }
}