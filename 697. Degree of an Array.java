import javafx.util.Pair;

import java.util.*;

class Solution {
    public int findShortestSubArray(int[] nums) {
        if (nums.length == 0)
            return 0;
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();

        int degree = 0;
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            degree = Math.max(degree, map.getOrDefault(nums[i], 0));
            if (!left.containsKey(nums[i]))
                left.put(nums[i], i);
            right.put(nums[i], i);
        }

        int min_dis = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == degree) {
                min_dis = Math.min(min_dis, right.get(nums[i]) - left.get(nums[i]) + 1);
            }
        }
        return min_dis;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] num = {1, 2};
        String str = "aa";

    }
}
