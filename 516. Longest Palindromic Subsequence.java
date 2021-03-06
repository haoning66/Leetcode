import java.util.*;

class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;              //dp[i][j] means the length of longest palindrome sub sequence in substring (i,j)
        }                              //so when i==j, dp[i][j] =1, the char itself

        for (int i = n - 2; i >= 0; i--) {        //update from the bottom-right, because the value in the bottom-left area is correct
            
            for (int j = i + 1; j < n; j++) {     //because when i>j, dp[i][j]=0;
                if(s.charAt(i)==s.charAt(j))
                    dp[i][j] = dp[i+1][j-1] + 2;
                else
                    dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
            }
        }
        return dp[0][n-1];
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.longestPalindromeSubseq("bbbab"));
    }
}


