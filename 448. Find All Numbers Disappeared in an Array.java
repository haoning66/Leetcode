import java.util.*;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int i, j;
        for (i = 0; i < nums.length; i++) {
            j = Math.abs(nums[i]) - 1;     //because 0<= a[i] <=n, so the index of nums can be used to represent a certain number appear or not
            if (nums[j] > 0)               //if it appear, we'll set nums[i] = -nums[i], to reserve the information of nums[j]
                nums[j] = -nums[j];        //after modification, if the nums[i] < 0 means the number i+1 appeared
        }

        List<Integer> res = new ArrayList<>();
        for (i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                res.add(i + 1);
        }
        return res;
    }

    public static void main(String args[]) {
        Solution s = new Solution();
    }
}
