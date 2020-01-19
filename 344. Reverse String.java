import java.util.*;

class Solution {
    public void reverseString(char[] s) {
        if (s.length == 0)
            return;
        int i = 0;
        int j = s.length - 1;
        while (j > i) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

    }
}
