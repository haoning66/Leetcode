import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0)
            return digits;

        int n = digits.length;
        digits[n - 1] += 1;
        for (int i = n - 1; i > 0; i--) {
            if (digits[i] == 10) {
                digits[i] = digits[i] % 10;
                digits[i - 1] += 1;
            } else break;
        }

        if (digits[0] >= 10) {
            int[] digitsnew = new int[n + 1];
            digitsnew[0] = 1;
            digits[0] = 0;
            for (int i = 0; i < n; i++) {
                digitsnew[i+1] = digits[i];
            }
            return digitsnew;
        }
        return digits;

    }
}