import java.util.*;

class Solution {
//    public int lengthOfLIS(int[] nums) { intuitive dp solution O(n2)
//        if (nums.length == 0)
//            return 0;
//        int max = 1;
//        int[] dp = new int[nums.length];
//        dp[0] = 1;
//
//        for (int i = 1; i < nums.length; i++) {
//            int j = i - 1;
//            int max_prefix = 0;
//            while (j >= 0) {
//                if (nums[i] > nums[j])
//                    max_prefix = Math.max(max_prefix, dp[j]);
//                j--;
//            }
//            dp[i] = max_prefix + 1;
//            max = Math.max(max, dp[i]);
//        }
//        return max;
//    }


    //the function Arrays.binarySearch(dp, 0, len, num) will use binary search to find the insertion point in array dp for element num from index 0 to len
    //if dp already contains num then return its index, if not it will return -insertion -1 , where insertion is the index of the first element smaller than num, which is the index num should be inserted into
    //what stored in dp is the LIS so far, when one element come, it should be put to the position behind the first element that is smaller than it, and when
    //a bigger element comes, but smaller than the biggest element in current LIS it will replace the element that is smaller than it
    public int lengthOfLIS(int[] nums) {     //binary search solution
        int[] dp = new int[nums.length];
        int len = 0;

        for (int num : nums) {
            int insertion = Arrays.binarySearch(dp, 0, len, num);
            if (insertion < 0)
                insertion = -(insertion + 1);   //get the insertion index
            dp[insertion] = num;         //insert it into dp
            if (insertion == len)        //which means this element is the last element of current LIS
                len++;
        }
        return len;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {0, 8, 4, 12, 2};
        s.lengthOfLIS(nums);

    }
}
