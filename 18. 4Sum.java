import javafx.util.Pair;

import java.util.*;


class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {  //basically the same idea with 3Sum
        if (nums.length == 0 || nums.length < 4)
            return Collections.emptyList();

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;  //because when j = i + 1, this j is the first j in this iteration, no need to skip, it is the same with
                int left = j + 1;                                   //if (i > 0 && nums[i] == nums[i - 1]) continue;
                int right = nums.length - 1;

                while (right > left) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum < target)
                        left++;
                    else if (sum > target)
                        right--;
                    else{
                        result.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[left], nums[right])));
                        left++;
                        right--;
                        while (left < right && nums[left] == nums[left - 1]) left++;
                        while (left < right && nums[right] == nums[right + 1]) right--;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
    }
}
