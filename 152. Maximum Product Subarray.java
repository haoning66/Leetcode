import java.util.*;

class Solution {
    //max is the max value that contains current element, min is the min value contains the current element
    //the next max value may come from
    //1. nums[i] 2.nums[i]*max 3.nums[i]*min(min<0 and nums[i]<0)
    //so update max with these three, and update min with these three(min may also come from these three)
    public int maxProduct(int[] nums) {
        if (nums.length == 0)
            return 0;
        int max = nums[0];
        int min = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = max * nums[i];
            max = Math.max(nums[i], Math.max(max * nums[i], min * nums[i]));
            min = Math.min(nums[i], Math.min(temp, min * nums[i]));
            res = Math.max(res, max);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
    }

}