import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

class Solution {
    public int findSubstringInWraproundString(String p) {
        if (p.length() == 0)
            return 0;
        int[] count = new int[26];
        char[] p_arr = p.toCharArray();
        int len = 0;
        for (int i = 0; i < p_arr.length; i++) {
            if (i > 0 && (p_arr[i] - p_arr[i - 1] == 1 || p_arr[i] - p_arr[i - 1] == -25))  //when a new character comes and it satisfies the requirement, it can add len new qualified sub string
                len++;                                                           //because there are len-1 characters in the old sub string, each of that can form a new qualified sub string with the
                                                                                //new character, and the new character itself.
            else                                                                //e.g.  abc and now d comes, len = 4, there are 4 new sub string with d: d, abcd, bcd, cd
                len = 1;
            count[p_arr[i] - 'a'] = Math.max(len, count[p_arr[i] - 'a']);
        }
        int res = 0;

        for (int c : count)
            res += c;

        return res;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println('a'-'z');
    }
}
