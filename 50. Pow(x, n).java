import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

class Solution {
    public double myPow(double x, int n) {
        if (x == 0.0)
            return 0.0;

        if (n == 0)
            return 1.0;
        else if (n > 0)
            return helper(x, n);
        else {
            return 1.0 / helper(x, -n);
        }
    }

    private double helper(double x, int n) {
        if (n == 0)
            return 1.0;
        double half = helper(x, n / 2);
        if (n % 2 == 0)
            return half * half;
        else
            return half * half * x;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.myPow(2.0, -2147483648));
    }
}
