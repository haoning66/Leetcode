import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

class Solution {
    public void rotate(int[] nums, int k) {
        if (nums.length == 0 || k % nums.length == 0)
            return;
        int pre;
        int temp;
        for (int i = 0; i < k; i++) {
            pre = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = pre;
                pre = temp;
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        double x = 5.5;
        System.out.println(Math.log10(x));
    }
}
