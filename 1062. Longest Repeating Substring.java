import java.util.*;

class Solution {
//    public int longestRepeatingSubstring(String S) {    this is the brute force solution, very slow
//        int max = 0;
//        int n = S.length();
//        for (int i = 1; i < n; i++) {
//            Set<String> seen = new HashSet<>();
//            for (int j = 0; j <= n - i; j++) {
//                String s = S.substring(j, j + i);
//                if (!seen.contains(s))
//                    seen.add(s);
//                else
//                    max = i;
//            }
//        }
//        return max;
//    }

    public int longestRepeatingSubstring(String S) {
        int max = 0;
        int n = S.length();
        int start = 0;
        int end = n - 1;
        while (end >= start) {
            int mid = start + (end - start) / 2;
            if (helper(mid, S)) {
                max = mid;
                start = mid + 1;
            } else
                end = mid-1;
        }

        return max;
    }

    private boolean helper(int mid, String S) {
        Set<String> seen = new HashSet<>();
        for (int i = 0; i <= S.length() - mid; i++) {
            String s = S.substring(i, i + mid);
            if (!seen.contains(s))
                seen.add(s);
            else
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "aabcaabdaab";
        Solution x = new Solution();
        System.out.println(x.longestRepeatingSubstring(s));
    }
}


