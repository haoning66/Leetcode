import java.util.*;

class Solution {
    int cur_root_pre_idx;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        cur_root_pre_idx = 0;  // inorder.length-1 -> 0
        Map<Integer, Integer> map = new HashMap<>();
        int index = 0;
        for (int node : inorder) {
            map.put(node, index++);
        }
        return helper(0, inorder.length - 1, map, inorder, preorder);
    }

    private TreeNode helper(int in_left, int in_right, Map<Integer, Integer> map, int[] inorder, int[] postorder) {
        if (in_left > in_right)
            return null;
        int cur_root_val = postorder[cur_root_pre_idx];
        TreeNode cur_root = new TreeNode(cur_root_val);
        int cur_root_in_idx = map.get(cur_root_val);
        cur_root_pre_idx++;   //-- -> ++
        cur_root.left = helper(in_left, cur_root_in_idx - 1, map, inorder, postorder);  //to convert the code from constructing binary tree from in-order and post-order to
        cur_root.right = helper(cur_root_in_idx + 1, in_right, map, inorder, postorder); //in-order pre-order construct left first then right

        return cur_root;
    }


    public static void main(String[] args) {
        Solution s = new Solution();

    }
}