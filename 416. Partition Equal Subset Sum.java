import java.util.*;

class Solution {
    //dp solution, dp[i] means whether we can get i using the elements in nums
    //first compute the sum of nums, then the problem becomes can we get sum/2 using elements in nums, if we can use
    //certain elements to get sum/2 then sum of elements left unused must also be sum/2, and since how many elements in each
    //partition doesnt matter, so dont worry about that
    //to update dp we must use elements in nums as outer loop and dp in reverse order as inner loop
    //use nums as outer loop because one element can only be used once
    //use dp in reverse order because large i in dp[i] depends on smaller dp[i-num]
    //if num is used in making smaller dp[i] be true it cannot be used again to make dp[i+num] be true
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0)
            return false;
        sum /= 2;
        boolean[] dp = new boolean[sum + 1];
        Arrays.fill(dp, false);
        dp[0] = true;

        for (int num : nums) {
            for (int i = dp.length - 1; i >= 0; i--) {
                if (i >= num)
                    dp[i] = dp[i] || dp[i - num];
            }
        }
        return dp[sum];
    }

    public static void main(String[] args) {
        Solution s = new Solution();

    }
}
