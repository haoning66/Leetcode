import java.util.*;

/*  nums [3,   4,   7,   2,   -3,     1,    4,   2,     1]
 *  {0,1}{3,1}{7,1}{14,1}{16,1}{13,1}{14,1}{18,1}{20,1}{21,1}
 *                    |                |
 *                 this two becomes {14,2}, this is because when {21,1} appears there are two point at which the sum is 14, so
 *                 the new subarray can start from both of them, this is why map.put(sum,map.getOrDefault(sum,0)+1) and count+=map.get(sum-k)
 */

class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);    // so that when it comes to {7,1} sum-k = 0({0,1})
        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }




//    public int subarraySum(int[] nums, int k) {    //naive approach
//        int count = 0;
//        for(int i = 0; i < nums.length; i++) {
//            int sum=0;
//            for(int j = i ; j < nums.length; j++) {
//                sum += nums[j];
//                if(sum == k)
//                    count += 1;
//            }
//        }
//        return count;
//    }
    public static void main(String[] args) {
        Solution s = new Solution();
    }
}