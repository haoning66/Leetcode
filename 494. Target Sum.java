import java.util.*;

class Solution {
    //intuitive solution , slow, a lot of recursion is duplicate
//    int res = 0;
//    public int findTargetSumWays(int[] nums, int S) {
//        helper(nums, 0, 0, S);
//        return res;
//    }
//
//    private void helper(int[] nums, int index, int cur, int S) {
//        if (index == nums.length && cur == S) {
//            res += 1;
//            return;
//        }
//
//        if (index < nums.length) {
//            helper(nums, index + 1, cur + nums[index], S);
//            helper(nums, index + 1, cur - nums[index], S);
//        }
//    }

    public int findTargetSumWays(int[] nums, int S) {  //recursion with memo array
        int[][] memo = new int[nums.length][2500];  //because S <= 1000
        for (int[] row : memo)
            Arrays.fill(row, Integer.MIN_VALUE);
        return helper(nums, 0, 0, S, memo);
    }

    private int helper(int[] nums, int index, int cur, int S, int[][] memo) {
        if (index == nums.length)
            return cur == S ? 1 : 0;

        if (memo[index][cur + 1000] != Integer.MIN_VALUE)    //the value of memo[index][cur+1000] means in current index how many ways to get S from cur
            return memo[index][cur + 1000];

        memo[index][cur + 1000] = helper(nums, index + 1, cur + nums[index], S, memo) + helper(nums, index + 1, cur - nums[index], S, memo);
        return memo[index][cur + 1000];
    }


}
