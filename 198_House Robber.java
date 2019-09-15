import java.util.*;

class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        if (len == 1) return nums[0];
        if (len == 2) return Math.max(nums[0], nums[1]);
        int[] money = new int[len];
        money[0] = nums[0];
        money[1] = Math.max(nums[0],nums[1]);
        int max=0;
        for(int i=2;i<len;i++){
            money[i] = Math.max((money[i-2]+nums[i]),money[i-1]);
            if(money[i]>max) max=money[i];
        }

        return max;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {2,1,1,2};
        System.out.println(s.rob(nums));
    }
}

