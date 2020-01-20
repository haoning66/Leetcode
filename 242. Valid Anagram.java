import java.util.*;

class Solution {
    public boolean isAnagram(String s, String t) {
        char[] hs = new char[100];
        char[] ht = new char[100];

        for (char c : s.toCharArray())
            hs[c - 'a']++;

        for (char c : t.toCharArray())
            ht[c - 'a']++;
        return Arrays.equals(hs, ht);
    }

    public static void main(String[] args) {
        Solution s = new Solution();

    }
}
