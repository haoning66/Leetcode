class Solution {
    public int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
            if(sum>result)
                result=sum;
            if(sum<0)
                sum=0;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums={-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(s.maxSubArray(nums));
    }
}

