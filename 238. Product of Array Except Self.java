class Solution {
    public int[] productExceptSelf(int[] nums) {
        int mul = 1;
        int zero = 0;

        int[] result = new int[nums.length];
        for (int num: nums) {
            if (num != 0)
                mul *= num;
            else
                zero += 1;
        }

        for (int i = 0; i < nums.length; i++) {
            if ( zero > 1)
                result[i] = 0;
            else if (zero == 1) {
                if (nums[i] == 0)
                    result[i] = mul;
                else
                    result[i] = 0;
            }
            else
                result[i] = mul / nums[i];
        }
        return result;
    }
}