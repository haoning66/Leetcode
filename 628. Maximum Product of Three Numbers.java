import java.util.*;

class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int left = nums[0]*nums[1]*nums[n-1];     //if there is more than one element<0, then max = nums[0]*nums[1]*nums[n-1] or nums[n-1]*nums[n-2]*nums[n-3]
        int right = nums[n-1]*nums[n-2]*nums[n-3];//if there is no element<0 or there is only one element<0, then max = nums[n-1]*nums[n-2]*nums[n-3]
        return Math.max(left,right);
    }

    public static void main(String[] args) {

    }

}


