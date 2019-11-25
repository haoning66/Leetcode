import java.util.*;

class Solution {                //index of cur root in in-order divide the elements in in-order to its left and right
    int cur_root_post_idx;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        cur_root_post_idx = inorder.length - 1;
        Map<Integer, Integer> map = new HashMap<>();
        int index = 0;
        for (int node : inorder) {
            map.put(node, index++);
        }
        return helper(0, inorder.length - 1, map, inorder, postorder);
    }

    private TreeNode helper(int in_left, int in_right, Map<Integer, Integer> map, int[] inorder, int[] postorder) {
        if (in_left > in_right)
            return null;
        int cur_root_val = postorder[cur_root_post_idx];
        TreeNode cur_root = new TreeNode(cur_root_val);
        int cur_root_in_idx = map.get(cur_root_val);
        cur_root_post_idx--;
        cur_root.right = helper(cur_root_in_idx + 1, in_right, map, inorder, postorder);//construct right tree first because in post-order right tree is at the end, cur_root_post_idx is length-1
        cur_root.left = helper(in_left, cur_root_in_idx - 1, map, inorder, postorder);
        return cur_root;
    }


    public static void main(String[] args) {
        Solution s = new Solution();

    }
}