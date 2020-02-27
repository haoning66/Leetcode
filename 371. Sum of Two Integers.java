import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

class Solution {
    //lets say 4 + 5      ^:if the digits are the same then 0, different 1
    //4: 100 5: 101    4 ^ 5 = 001(which is the sum without carry)  4 & 5 = 100(which is the carry, but need move one digit forward)
    // (4 & 5) << 1 = 1000(which is the carry)
    // 0001 ^ 1000 = 1001     (0001 & 1000) << 1 = 00000 = 0
    public int getSum(int a, int b) {
        if (b == 0)
            return a;
        int sum = a ^ b;
        int carry = (a & b) << 1;
        return getSum(sum, carry);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(0^0);
    }
}
