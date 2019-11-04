import java.util.*;


class Solution {
    public int findDerangement(int n) {
        if(n==0)
            return 0;
        if(n==1)
            return 0;
        int[] dp = new int[n + 1];
        dp[0] = 0;   // this doesnt matter
        dp[1] = 0;
        dp[2] = 1;
                                   //here is the transformation function
                                   //dp[i] = (i+1)*(dp[i-1]+dp[i-2])
                                   //dp[i] is the problem of n elements, each has n-1 choice of position
                                   //consider the 1 element is put in the ith position(there are n-1 choice), there are 2 situations
                                   //(1) the ith element is put in 1st position, then there are n-2 remaining elements each has n-3 choice(because it cannot be in 1st position, ith position and its own position), so this becomes dp[i-2]
                                   //(2) the ith element will not be put in 1st position, then there are n-1 elements, each has n-2 choice(it cannot be put to its own position and ith position, ith element cannot be put to ith position and 1st position), this becomes dp[i-1]
                                   //thus dp[n] = (n-1) * (dp[n-1]+dp[n-2])
        for (int i = 3; i < n + 1; i++) {
            dp[i] = (int) ((i - 1L) * (dp[i - 1] + dp[i - 2])%1000000007);
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(200000000 - 1L);

    }
}


