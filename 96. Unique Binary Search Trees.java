import java.util.HashMap;
import java.util.Map;

class Solution {
    /*
    * Use catalan formula
    * dp[i] means how many nodes can be used to construct the tree
    * dp[i+1] = dp[0]*dp[i]+dp[1]dp[i-1]+....+dp[i]dp[0]
    * dp[0] = 1(null tree)
    * dp[1] = 1, when n = 1, we can only use 1 for root and both left subtree and right subtree is null, so dp[1] = dp[0]*dp[0]=1
    * dp[2], when n = 2, we can use 1 for root and left subtree is null right subtree is 2 so it is dp[0]*dp[1]
    * plus when 2 is root left subtree is 1 right subtree is null which is dp[1]*dp[0]
    * */

    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }
}