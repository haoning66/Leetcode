class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int num : prices) {
            if (num < min)
                min = num;
            else if (num - min > maxprofit)
                maxprofit = num - min;
        }
        return maxprofit;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] prices = {1, 4, 2};
        System.out.println(s.maxProfit(prices));
    }
}