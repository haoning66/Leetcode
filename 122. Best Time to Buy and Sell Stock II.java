import java.util.*;

class Solution {
    //pretty much the same solution with leetcode 390, slow
//    public int maxProfit(int[] prices) {
//        int n = prices.length;
//        if (n == 0 || n == 1)
//            return 0;
//        int[] dp = new int[n];
//
//        for (int i = 0; i < n; i++) {
//            if (i == 0)
//                dp[i] = 0;
//            else if (i == 1)
//                dp[i] = Math.max(prices[i] - prices[i - 1], 0);
//            else {
//                dp[i] = dp[i - 1];
//                for (int j = 0; j < i; j++) {
//                    int pre_profit = j > 1 ? dp[j - 1] : 0;
//                    dp[i] = Math.max(dp[i], pre_profit + prices[i] - prices[j]);
//                }
//            }
//        }
//        return dp[n - 1];
//    }

    //if you plot the prices array, you'll find the max profit is the sum of the peek - its previous valley
    public int maxProfit(int[] prices) {
        if (prices.length == 0 || prices.length == 1)
            return 0;
        int valley = prices[0];
        int peek = prices[0];
        int profit = 0;
        int i = 0;
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1])
                i++;
            valley = prices[i];

            while (i < prices.length - 1 && prices[i] <= prices[i + 1])
                i++;
            peek = prices[i];
            profit += peek - valley;
        }
        return profit;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

    }
}
