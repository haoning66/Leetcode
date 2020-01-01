import java.util.*;

class Solution {
//    int result = 0;     intuitive recursive solution, too much recursion, TLE
//    public int climbStairs(int n) {
//        if (n == 0)
//            return 0;
//
//        helper(n - 1);
//        helper(n - 2);
//        return result;
//    }
//
//    private void helper(int remain) {
//        if (remain == 1 || remain == 0) {
//            result += 1;
//            return;
//        }
//
//        if (remain > 1)
//            helper (remain - 1);
//
//        if (remain >= 2)
//            helper (remain - 2);
//    }

//    public int climbStairs(int n) {   //recursive dp solution
//        int[] memo = new int[n + 1];
//        return helper(0, n, memo);
//    }
//
//    private int helper(int i, int n, int[] memo) {
//        if (i > n)
//            return 0;
//        if (i == n)
//            return 1;
//
//        if (memo[i] > 0)
//            return memo[i];
//
//        memo[i] = helper(i + 1, n, memo) + helper(i + 2, n, memo);
//
//        return memo[i];
//    }

    public int climbStairs(int n) { //another dp solution, like fibonacci sequence, to get to dp[i] you must come from dp[i-1] or dp[i-2]
        if (n == 1)             //so dp[i] = dp[i-1]+dp[i-2], dp[i] means how many ways to get to i from 0
            return 1;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }



    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.climbStairs(44));
    }
}
