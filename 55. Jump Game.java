import java.util.*;

class Solution {
//    boolean can_jump = false;    intuitive dfs solution, TLE because of the last big testcase
//    public boolean canJump(int[] nums) {
//        if (nums.length == 0 || nums[0] == 0 && nums.length != 1)
//            return false;
//
//        helper(0, nums);
//        return can_jump;
//    }
//
//    private void helper(int index, int[] nums) {
//        if (can_jump)
//            return;
//
//        if (nums[index] >= nums.length - 1 - index) {
//            can_jump = true;
//            return;
//        }
//        else {
//            for (int i = 1; i <= nums[index]; i++) {
//                helper (index + i, nums);
//            }
//        }
//    }

    public boolean canJump(int[] nums) {// brilliant
        if (nums.length == 0 || nums[0] == 0 && nums.length != 1)
            return false;

        int cur_index = 0;
        int max_index = 0;//max_index is the maximum index you can get to from current index

        while (cur_index <= max_index) {   //which means you cannot get to current index
            max_index = Math.max(cur_index + nums[cur_index], max_index);  //cur_index + nums[cur_index] doesnt necessarily be max_index
            if (max_index >= nums.length - 1)
                return true;
            cur_index++;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.canJump(new int[]{3,2,1,0,4}));
    }
}
