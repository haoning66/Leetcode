import javafx.util.Pair;

import java.util.*;


class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0 || nums.length == 1)
            return nums.length;

        int n = 0;
        for (int i = 0; i < nums.length; i++) {
            while (i < nums.length - 1 && nums[i + 1] == nums[i]) {
                i++;

            }
            nums[n] = nums[i];
            n++;
        }
        return n;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.removeDuplicates(new int[]{1,1,2}));
    }

}
