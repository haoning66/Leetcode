import java.util.*;

class Solution {
    public int findPeakElement(int[] nums) {
        if (nums.length == 0)
            return -1;
        if (nums.length == 1)
            return 0;
        int i = 0;

        while (i < nums.length) {
            if (i == 0 && nums[i] > nums[i + 1])
                return i;
            else if (i == nums.length - 1 && nums[i] > nums[i - 1])
                return i;

            else if (nums[i] > nums[i + 1] && nums[i] > nums[i - 1])
                return i;
            i++;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

    }
}
