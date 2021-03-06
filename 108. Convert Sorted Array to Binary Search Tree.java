import java.util.*;

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0)
            return null;
        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int left, int right) {
        while (left <= right) {
            int mid = (left + right) / 2;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = helper(nums, left, mid - 1);
            root.right = helper(nums, mid + 1, right);
            return root;
        }
        return null;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

    }
}
