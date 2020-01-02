import javafx.util.Pair;

import java.util.*;

class Solution {
    public int monotoneIncreasingDigits(int N) {  //only have to find the digit that smaller than its previous digit and subtract one from
        String s = N+"";                         //its previous digit(if its previous digit then become smaller that its previous previous digit the loop continue)
        char[] s_arr = s.toCharArray();          //change all the digit after the last legal digit to 9
        int i = 1;                                                            //1573 -> 1563 -> 1569
        while (i < s_arr.length - 1 && s_arr[i - 1] <= s_arr[i]) i++;
        while (i > 0 && i < s_arr.length && s_arr[i] < s_arr[i - 1]) {
            s_arr[i - 1]--;
            i--;
        }
        for (int j = i + 1; j < s_arr.length; j++) {
            s_arr[j] = '9';
        }
        return Integer.parseInt(String.valueOf(s_arr));
    }

    public static void main(String[] args) {
        Solution s = new Solution();
    }
}
