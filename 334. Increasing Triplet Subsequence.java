import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

class Solution {
    //my own efficient solution
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3)
            return false;
        int min = Integer.MAX_VALUE;
        int sec_min = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > sec_min)
                return true;
            min = Math.min(min, nums[i]);
            if (nums[i] > min)
                sec_min = Math.min(sec_min, nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
    }
}
