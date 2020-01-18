import java.util.*;

class Solution {
    //brilliant dp solution, dp[i] means the maximum profit when day i is the last day.
    //so what kind of day day i is? It cannot be a buy day, because it can never sell it, so it can only be a cooldown day or buy day
    // A. if it is a cooldown day, then dp[i] = dp[i-1]
    // B. if it is a sell day, then which day is the buy day, lets say day j, j can be any day between 0 to i-1
    //whatever gives bigger profit, so in this case dp[i] = previous_profit + prices[i] - prices[j]
    //how to calculate previous_profit? If day j is a buy day, then day j-1 cannot be a buy day, you cannot buy twice
    //j-1 cannot be a sell day because you haven't buy it yet, so j - 1 must be a cooldown day, so previous_profit = dp[j-1] = dp[j-2]
    //so dp[i] = max(dp[i-1], max(dp[j-2] + prices[i] - prices[j]))

    public int maxProfit(int[] prices) {
        if (prices.length == 0)
            return 0;
        int n = prices.length;
        int[] dp = new int[n];
        for (int i = 0; i < dp.length; i++) {
            if (i == 0)
                dp[i] = 0;
            else if (i == 1)
                dp[i] = Math.max(prices[1] - prices[0], 0);
            else {
                dp[i] = dp[i - 1];
                for (int j = 0; j < i; j++) {
                    int pre_sum = j > 2 ? dp[j - 2] : 0;
                    dp[i] = Math.max(dp[i], pre_sum + prices[i] - prices[j]);
                }
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
    }
}
