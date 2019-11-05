import java.util.*;

class Solution {
    public int numRollsToTarget(int d, int f, int target) {
        if (target > f * d)
            return 0;                                      //dp[i][j] represents how many way to get target j in i remaining dices
        final int m = 1000000007;                         //transformation function is dp[i][j] = dp[i-1][j-1]+dp[i-1][j-2]+dp[i-1][j-3]+....+dp[i-1][i-k]
        int[][] dp = new int[d + 1][target + 1];          //using i dices to get target j equals to the sum of using i-1 dices to get from j-1 to j-k(k is the number of this dice)
        dp[0][0] = 1;
        for (int i = 1; i <= d; i++) {
            for (int j = 0; j <= target; j++) {
                for(int k=1;k<=f;k++){
                    if(j>=k)
                        dp[i][j] = (dp[i][j] + dp[i-1][j-k])%m;
                }
            }
        }
        return dp[d][target];
    }

    public static void main(String[] args) {
        Solution s = new Solution();

    }

}


