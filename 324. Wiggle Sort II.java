import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

class Solution {
    //sort and insert solution, pretty fast
    public void wiggleSort(int[] nums) {
        if (nums.length == 0 || nums.length == 1)
            return;
        Arrays.sort(nums);
        int[] res = new int[nums.length];
        int i = nums.length % 2 == 0 ? (nums.length / 2) - 1 : nums.length / 2;
        int j = nums.length - 1;
        for (int k = 0; k < nums.length; k++) {
            if (k % 2 == 0) {
                res[k] = nums[i];
                i--;
            } else {
                res[k] = nums[j];
                j--;
            }
        }

        System.arraycopy(res,0,nums,0,nums.length);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.wiggleSort(new int[]{4,5,5,6});
    }
}
