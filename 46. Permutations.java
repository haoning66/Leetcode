import java.util.*;

class Solution {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs_helper(result, nums, 0);
        return result;
    }

    private void dfs_helper(List<List<Integer>> result, int[] nums, int cur_index) {
        if (cur_index == nums.length-1) {
            List<Integer> temp = new ArrayList<>();
            for (int num : nums)
                temp.add(num);
            result.add(temp);
        } else {
            for (int i = cur_index; i < nums.length; i++) {
                swap(nums, cur_index, i);
                dfs_helper(result, nums, cur_index + 1);
                swap(nums, cur_index, i);   //swap it back, recover nums
            }
        }
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
    }
}
