import java.util.*;

class Solution {
    public int numSquares(int n) {  //coin change dp solution
        int sqr = new Double(Math.sqrt(n)).intValue();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < sqr + 1; j++) {
                if (i >= j * j)
                    dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {


    }
}
