import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

class Solution {
    public boolean isPowerOfThree(int n) {
        return (Math.log10(n) / Math.log10(3)) % 1 == 0;  //x%1==0 to check if x is an integer
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        double x = 5.5;
        System.out.println(Math.log10(x));
    }
}
