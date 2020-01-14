import java.util.*;

class Solution {
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for(int i = 1; i < res.length; i++) {
            res[i] = res[i & (i - 1)] + 1;     // this is the rule, i&(i-1) is used to check if i is exponential of 2, if i&(i-1)=0, then it is
        }
        return res;
    }
}