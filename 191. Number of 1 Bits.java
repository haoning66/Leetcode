import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            count += n & 1;
            n = n >> 1;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
    }
}
