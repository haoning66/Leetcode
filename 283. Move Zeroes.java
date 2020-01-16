import java.util.*;

class Solution {
//    public int countSubstrings(String s) {    slow
//        int res = 0;
//        if (s.length() == 0)
//            return 0;
//        for (int i = 0; i < s.length(); i++) {
//            for (int j = i + 1; j < s.length() + 1; j++) {
//                if (j == i + 1)
//                    res += 1;
//                else if (isPalind(s.substring(i, j)))
//                    res += 1;
//            }
//        }
//        return res;
//    }
//
//    private boolean isPalind(String s) {
//        int i = 0;
//        int j = s.length() - 1;
//        while (j > i && s.charAt(i) ==s.charAt(j)) {
//            i++;
//            j--;
//        }
//        if (i >= j)
//            return true;
//        else
//            return false;
//    }

    public int countSubstrings(String s) {    //dp solution
        int n = s.length();
        int res = 0;
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for(int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 2) {    //if char[i]=char[j] and j-i<=2 then it must be palindrome
                        dp[i][j] = 1;
                        res++;
                    }
                    else if (dp[i + 1][j - 1] == 1) {   //if j-i>3 it will depend on dp[i + 1][j - 1] is palindrome or not 
                        dp[i][j] = 1;
                        res++;
                    }
                }
            }
        }
        return res;
    }
}
