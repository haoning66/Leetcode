class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days.length + 1];
        int weekly_start = 0;   //they are the best day to start a weekly pass or monthly pass
        int monthly_start = 0;
        dp[0] = 0;

        for (int i = 1; i < dp.length; i++) {

            dp[i] = dp[i - 1] + costs[0];   //cost if choose day pass

            while (days[i - 1] - days[weekly_start] >= 7)// update weekly_start to calculate what if we start weekly pass on weekly_start, and compare the
                weekly_start++;                          //the cost with the other two

            while (days[i - 1] - days[monthly_start] >= 30)
                monthly_start++;
                                            //dp[weekly_start] stores the cost from the first day to the day weekly_start
            dp[i] = Math.min(dp[i], Math.min(dp[weekly_start] + costs[1], dp[monthly_start] + costs[2]));
        }
        return dp[dp.length - 1];
    }

    /*
    * Lets take days[1,4,6,7,8,20] costs[2,7,15] for example, dp[i] means the minimum cost on days[i-1]
    * the final result of dp is [0,2,4,6,7,9,11] for day[-1] its cost is 0 which is dp[0], for days[0] which is the first day
    * its cost is 2, for days[1] which is 4, its cost is 2+2=4. The cost will accumulate buy 2 if the length between the cur day and the days[weekly_start](days[0] now)
    * but when days[i - 1] - days[weekly_start] >= 7, it means now the accumulated cost for these days can be replaced with a weekly pass
    *and by adding weekly_start we can get a most suitable start date for weekly pass that can cover days[i-1](dp[i])
    * */

    public static void main(String[] args) {
        int[] days = {1, 4, 6, 7, 8, 20};
        int[] cost = {2, 7, 15};
        Solution s= new Solution();
        s.mincostTickets(days, cost);
    }
}