import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

class Solution {
    //a very complex dp problem
    public int numDecodings(String s) {
        if (s.length() == 0)
            return 0;
        int n = s.length();
        if (s.charAt(0) == '0')     //nothing can decode 0, if it starts with 0, no way to decode
            return 0;
        if (s.length() == 1)
            return 1;
        int[] dp = new int[n];
        dp[0] = 1;

        if (s.charAt(0) < '2') {    //the first two digits is very important
            if (s.charAt(1) == '0')
                dp[1] = 1;
            else
                dp[1] = 2;
        }
        else if(s.charAt(0) == '2') {
            if (s.charAt(1) == '0')
                dp[1] = 1;
            else if (s.charAt(1) <= '6')
                dp[1] = 2;
            else
                dp[1] = 1;
        }
        else {
            if (s.charAt(1) == '0')
                dp[1] = 0;
            else
                dp[1] = 1;
        }

        for (int i = 2; i < n; i++) {
            if (s.charAt(i) != '0')   //if i != 0, then i can be added to all the combinations in dp[i-1], so this much combination should be added to dp[i]
                dp[i] += dp[i - 1];
            if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2' && s.charAt(i) <= '6')
                dp[i] += dp[i - 2];   //if i-1==1 || i-1==2&& i<=6 then (i-1)(i) can be added to all the combinations in dp[i-2], these two conditions is not mutually exclusive
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
    }
}
