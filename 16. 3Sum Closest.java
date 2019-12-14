import javafx.util.Pair;

import java.util.*;


class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length == 0)
            return 0;
        int res = 0;
        int min_diff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;             //only use num on the left of nums[i] as the second num, to avoid duplicate
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                int diff = Math.abs(sum - target);
                if (diff < min_diff) {
                    min_diff = diff;
                    res = sum;
                }
                if (sum < target)
                    left += 1;
                else if (sum > target)
                    right -= 1;
                else
                    return sum;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
    }
}
