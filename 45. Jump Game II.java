import java.util.*;

class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int pos = 0; pos < nums.length; pos++) {
            for (int jump = 1; jump <= nums[pos]; jump++) {
                if (pos + jump > nums.length - 1)
                    break;
                if (dp[pos + jump] > 1 + dp[pos])
                    dp[pos + jump] = 1 + dp[pos];
            }
        }
        return dp[nums.length-1];
    }
}