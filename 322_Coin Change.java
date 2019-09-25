import java.lang.reflect.Array;
import java.util.Arrays;

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        for (int amt = 0; amt < amount + 1; amt++) {
            for (int i = 0; i < coins.length; i++) {
                if (amt >= coins[i]) {
                    dp[amt] = Math.min(dp[amt], dp[amt - coins[i]] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] coins = {2};
        System.out.println(s.coinChange(coins, 3));

    }
}

