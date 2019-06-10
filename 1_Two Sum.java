class Solution {
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        int[] result = new int[2];
        for(int i=0; i<len;i++){
            for(int j=0; j<len; j++){
                if(j!=i){
                    if(target == nums[i]+nums[j]){
                        result[0] = i;
                        result[1] = j;
                    }
                }
            }

        }
        return result;
    }
}
