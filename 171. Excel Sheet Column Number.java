import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

class Solution {
    public int titleToNumber(String s) {
        if (s.length() == 0)
            return 0;
        int res = 0;
        int x = 1;
        for (int i = 0 ; i < s.length(); i++) {     //'Y'-'A'=24
                                                    //   |
            res += (s.charAt(s.length() - 1 - i) - 'A' + 1) * x;
            x *= 26;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println('Z'-'A');
    }
}
