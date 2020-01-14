import java.util.*;

class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int max = 0;     //the maximum customer can be satisfied, only contain customers when grumpy[i]==1
        int cur = 0;     //in current window how many customers can be satisfied if use the technique during current window
        int res = 0;     //customers with grump[i] = 0
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0)
                res += customers[i];
            else {
                cur += customers[i];
            }

            if (i >= X && grumpy[i-X]== 1)    //window overflow, subtract the customers in previous window
                cur-=customers[i-X];
            max = Math.max(max, cur);
        }
        return res + max;
    }
}