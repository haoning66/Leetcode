import java.util.*;

class Solution {
    public int reverse(int x) {
        long res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            x /= 10;
        }
        return res > Integer.MAX_VALUE || res < Integer.MIN_VALUE ? 0 : (int) res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.reverse(-1233);

        System.out.println(-1233 % 10);
    }
}
