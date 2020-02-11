import java.util.*;

class Solution {
    //this is my original solution, not the solution from solution of leetcode
    //remember, you are good :-)
    public int missingNumber(int[] nums) {
        int sum1 = (1 + nums.length) * nums.length / 2;
        int sum2 = 0;
        for (int num : nums)
            sum2 += num;
        return sum1 - sum2;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
    }
}
