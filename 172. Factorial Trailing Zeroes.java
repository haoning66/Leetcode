import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

class Solution {
    public int trailingZeroes(int n) {
        int res = 0;
        while (n != 0) {
            n = n / 5;
            res += n;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
    }
}
