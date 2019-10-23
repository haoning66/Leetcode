import java.util.*;

class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i : nums) {
            res ^= i;    // 1^1=0; 0^1=1; every two nums will become 0, leave the single one
        }
        return res;
    }
}