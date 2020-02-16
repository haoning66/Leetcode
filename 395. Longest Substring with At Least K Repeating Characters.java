import java.util.*;

class Solution {
    //divide and conquer
    public int longestSubstring(String s, int k) {
        if (s.length() == 0 || k > s.length())
            return 0;
        return helper(s, k, 0, s.length() - 1);
    }

    private int helper(String s, int k, int start, int end) {
        if (start > end)
            return 0;
        int[] count = new int[26];
        for (int i = start; i <= end; i++) {
            count[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0 && count[i] < k) {
                int pos = s.indexOf((char)(i + 'a'), start);
                return Math.max(helper(s, k, start, pos - 1), helper(s, k, pos + 1, end));
            }
        }
        return end - start + 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.longestSubstring("bbaaacbd", 3));
    }
}
