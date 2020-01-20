import java.util.*;

class Solution {
    // public boolean containsDuplicate(int[] nums) {
    //     Set<Integer> set = new HashSet<>();
    //     for (int num : nums) {
    //         if (set.contains(num))
    //             return true;
    //         set.add(num);
    //     }
    //     return false;
    // }

    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1])
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

    }
}
