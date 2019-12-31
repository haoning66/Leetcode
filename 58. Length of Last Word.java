import java.util.*;

class Solution {
    public int lengthOfLastWord(String s) {// what a stupid question
        if (s.length() == 0)
            return 0;
        String[] spl = s.split(" ");
        if (spl.length == 0)
            return 0;
        return spl[spl.length - 1].length();
    }

    public static void main(String[] args) {
        Solution s = new Solution();

    }
}
