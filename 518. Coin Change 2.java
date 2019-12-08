import java.util.*;

class Solution {
    public int change(int amount, int[] coins) {
        //dp[i] is how many ways to get amount i
        //the for loop is to update dp[i] with the current and previous denominations of coins
        //if j(the target amount) is bigger or equal to the current coin then use this coin, the new dp[j] is
        //its previous ways plus 1*dp[j-coin](which is how many ways can add up to amount j-coin and now there is one way to add up to amount coin which is with one coin itself)
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for(int coin : coins) {
            for(int j = 1; j <= amount; j++) {
                if (j >= coin)
                    dp[j] += dp[j - coin];
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
    }
}
